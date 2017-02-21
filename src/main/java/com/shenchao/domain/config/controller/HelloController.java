package com.shenchao.domain.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by shenchao on 2017/2/2.
 */
@Controller
@Scope("prototype")
public class HelloController {
    @Autowired
    private WebApplicationContext context;
    @ResponseBody
    @RequestMapping("/hello/1")
    public Bean abc(String path){
        Bean bean = new Bean();
        bean.setName(path);
        System.out.println(path);
        return bean;
    }

    @ResponseBody
    @RequestMapping("/doc")
    public Bean upload(@RequestParam("a1")MultipartFile file) throws IOException {
        byte[] bytes = new byte[1023];
        int n = file.getInputStream().read(bytes);
        String realPath = context.getServletContext().getRealPath("/hello.txt");
        System.out.println(realPath);
        file.transferTo(new File(realPath));
        System.out.println(new String(bytes,0,n));
        Bean bean = new Bean();
        bean.setName("ok");
        return bean;
    }

    @ResponseBody
    @RequestMapping("/hotels")
    public String hotels(@RequestParam("foo") String foo) {
        System.out.println(foo);
        return foo;
    }
}
