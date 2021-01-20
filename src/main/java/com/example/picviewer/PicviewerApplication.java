package com.example.picviewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PicviewerApplication  extends SpringBootServletInitializer {

//    打包成war
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(PicviewerApplication.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(PicviewerApplication.class, args);
    }

}
