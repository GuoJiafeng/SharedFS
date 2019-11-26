package io.gjf.controller;

import io.gjf.entity.FileBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Creat by GuoJF on 2019-11-25
 */
@RequestMapping("TestController")
@Controller
public class TestController {
     static final String BASE_PATH = "/Users/guojf/FileTest/";

    @RequestMapping("list")
    public @ResponseBody
    List<FileBean> list() {

        File file = new File(BASE_PATH);

        ArrayList<FileBean> fileList = new ArrayList<FileBean>();


        for (File eachFile : file.listFiles()) {


            FileBean fileBean = new FileBean();
            fileBean.setName(eachFile.getName());
            fileBean.setPath(eachFile.getAbsolutePath());
            fileBean.setTimestamps(String.valueOf(eachFile.lastModified()));


            fileList.add(fileBean);
        }

        return fileList;
    }




}
