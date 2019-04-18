package com.xdclass.domain;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

/**
 * Greated by Terry on 2019/4/19
 * Time: 3:30
 */
public class FileInfo {

    public  FileInfo(String path){
        this.path=path;
    }


    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {

        return path;
    }
}
