package io.gjf.controller;

import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import io.gjf.entity.FileBean;
import io.gjf.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Creat by GuoJF on
 */

@Controller
@RequestMapping("FileController")
public class FileController {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private FileService fileService;


    /*
     * 下载
     * */

    @RequestMapping("download")
    public void download(HttpServletResponse response, String uuid, String name) throws Exception {


        GridFSDBFile fsdbFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(uuid)));

        // 穿件输入对象
        InputStream fis = fsdbFile.getInputStream();
        // 设置相关格式
        response.setContentType("application/force-download");
        // 设置下载后的文件名以及header
        response.addHeader("Content-disposition", "attachment;fileName=" + name);
        // 创建输出对象
        OutputStream os = response.getOutputStream();
        // 常规操作
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = fis.read(buf)) != -1) {
            os.write(buf, 0, len);
        }
        fis.close();
    }


    @RequestMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        // 获取原始名字
        String fileName = file.getOriginalFilename();

        String originname = fileName;

        // 文件重命名，防止重复
        fileName = UUID.randomUUID() + fileName;


        GridFSFile fsFile = gridFsTemplate.store(file.getInputStream(), fileName, file.getContentType());


        FileBean fileBean = new FileBean();

        fileBean.setUuid(fsFile.getId().toString());
        fileBean.setTimestamps(String.valueOf(fsFile.getUploadDate().getTime()));
        fileBean.setName(fileName);
        fileBean.setOriginalName(originname);


        fileService.insertOne(fileBean);

        fsFile.save();


        return "redirect:/index.jsp";
    }

    @RequestMapping("list")
    public @ResponseBody
    List<FileBean> list() {

        List<FileBean> list = fileService.findAll();

        return list;
    }


    @RequestMapping("del")
    public String del(String uuid) {

        FileBean fileBean = new FileBean();

        fileBean.setUuid(uuid);

        fileService.deleteOne(fileBean);


        return "redirect:/index.jsp";
    }


}
