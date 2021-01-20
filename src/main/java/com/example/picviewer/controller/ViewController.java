package com.example.picviewer.controller;

import com.example.picviewer.service.FileManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Deprecated
@RestController
public class ViewController {
    @Autowired
    private FileManage fileManage;

    @RequestMapping(value = "/images", method = RequestMethod.GET)
    public ArrayList<String> list() {
        return fileManage.getFileNames();
    }
}
