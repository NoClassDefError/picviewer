package com.example.picviewer.util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

@Component
public class MyProperties extends Properties {
    public MyProperties(){
        super();
        try {
            this.load(this.getClass().getResourceAsStream("/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

