package com.example.picviewer.service;

import com.example.picviewer.util.MyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;

@Service
public class FileManage {

    @Autowired
    private MyProperties properties;

    public ArrayList<String> getFileNames() {
        File file = new File(properties.getProperty("actualDir") + "\\" +
                properties.getProperty("defaultDir").replace("/", "\\"));
//        System.out.println(file.getAbsolutePath());
        ArrayList<String> result = new ArrayList<>();
        for (File son : file.listFiles())
            if (son.getName().toLowerCase().contains(".jpg") || son.getName().toLowerCase().contains(".png"))
                result.add(son.getName());
//        System.out.println(result);
        return result;
    }
}
