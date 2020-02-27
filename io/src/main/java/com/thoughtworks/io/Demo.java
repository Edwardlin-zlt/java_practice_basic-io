package com.thoughtworks.io;

import java.io.File;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
//        FileUtil.copyFile(new File("/home/edward/Documents/test/a.txt"), new File("/home/edward/Documents/test2/a.txt"));
        FileUtil.copyDirectory(new File("/home/edward/Documents/"), new File("/home/edward/Desktop/"));
    }
}
