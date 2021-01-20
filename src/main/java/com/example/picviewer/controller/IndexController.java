package com.example.picviewer.controller;

import com.example.picviewer.service.FileManage;
import com.example.picviewer.util.MyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @Autowired
    private FileManage fileManage;
    @Autowired
    private MyProperties properties;

    @RequestMapping("/view")
    public String view(Model model, @RequestParam(value = "name") String name) {
        model.addAttribute("fileNames", fileManage.getFileNames());
        model.addAttribute("current", name);
//        model.addAttribute("url", properties.getProperty("address")
//                + properties.getProperty("server.servlet.context-path").substring(1) + "/"
//                + properties.getProperty("defaultDir"));
        model.addAttribute("contextPath", properties.getProperty("server.servlet.context-path"));
        model.addAttribute("url", "/" + properties.getProperty("defaultDir"));
        return "view";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("defaultDir", properties.getProperty("defaultDir"));
        model.addAttribute("contextPath", properties.getProperty("server.servlet.context-path"));
        model.addAttribute("fileNames", fileManage.getFileNames());
        model.addAttribute("dir1", properties.getProperty("dir1"));
        model.addAttribute("dir2", properties.getProperty("dir2"));
        model.addAttribute("dir3", properties.getProperty("dir3"));
        model.addAttribute("dir4", properties.getProperty("dir4"));
        model.addAttribute("dir5", properties.getProperty("dir5"));
        model.addAttribute("dir6", properties.getProperty("dir6"));
        return "index";
    }

    @RequestMapping(value = "/changeDir", method = RequestMethod.POST)
    public String changeDir(Model model, @RequestParam(value = "dir") String dir) {
        properties.setProperty("defaultDir", dir);
        model.addAttribute("fileNames", fileManage.getFileNames());
        model.addAttribute("defaultDir", dir);
        model.addAttribute("contextPath", properties.getProperty("server.servlet.context-path"));
        model.addAttribute("dir1", properties.getProperty("dir1"));
        model.addAttribute("dir2", properties.getProperty("dir2"));
        model.addAttribute("dir3", properties.getProperty("dir3"));
        model.addAttribute("dir4", properties.getProperty("dir4"));
        model.addAttribute("dir5", properties.getProperty("dir5"));
        model.addAttribute("dir6", properties.getProperty("dir6"));
        return "index";
    }
}
