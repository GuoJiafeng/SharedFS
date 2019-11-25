package io.gjf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/**
 * Creat by GuoJF on
 */

@Controller
@RequestMapping("FileController")
public class FileController {
    static final String BASE_PATH = "/Users/guojf/FileTest/";
    /*
     * 下载
     * */

    @RequestMapping("download")
    public void download(HttpServletResponse response, String name) throws Exception {
        // 文件地址，真实环境是存放在数据库中的
        File file = new File(BASE_PATH + name);
        // 穿件输入对象
        FileInputStream fis = new FileInputStream(file);
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
}
