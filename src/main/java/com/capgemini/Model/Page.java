package com.capgemini.Model;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Page {
    String title;
    String content;

    public String getTitle(String title) {
        return title;
    }

    public void setTitle(String s) {
        this.title = title;
    }

    public String getContent(String content) {
        return content;
    }

    public void setContent(String s) {
        this.content = content;
    }


}
