package com.thoughtworks.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {

    /**
     * 完成复制文件夹方法:
     * 1. 把给定文件夹from下的所有文件(包括子文件夹)复制到to文件夹下
     * 2. 保证to文件夹为空文件夹，如果to文件夹不存在则自动创建
     * <p>
     * 例如把a文件夹(a文件夹下有1.txt和一个空文件夹c)复制到b文件夹，复制完成以后b文件夹下也有一个1.txt和空文件夹c
     */
    public static void copyDirectory(File from, File to) throws IOException {
        File[] files = from.listFiles();
        boolean isDirMade = to.mkdirs();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    copyDirectory(file, new File(to.getAbsolutePath()+File.separator+file.getName()));
                } else {
                    copyFile(file, new File(to.getAbsolutePath()+File.separator+file.getName()));
                }
            }
        }
    }

    public static void copyFile(File from, File to) throws IOException {
        FileInputStream fromStream = new FileInputStream(from);
        FileOutputStream toStream = new FileOutputStream(to);
        // 这里的打印可以写吗？工具类能直接写系统打印吗？
//        System.out.println(to.getAbsolutePath()+" Copied");
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fromStream.read(bytes))!= -1) {
            toStream.write(bytes, 0, len);
        }
        fromStream.close();
        toStream.close();
    }
}
