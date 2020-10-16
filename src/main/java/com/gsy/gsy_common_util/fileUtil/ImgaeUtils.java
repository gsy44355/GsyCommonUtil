package com.gsy.gsy_common_util.fileUtil;
import java.awt.image.BufferedImage;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class ImgaeUtils {
    //写的不好
    public static void main(String[] args) throws IOException {
//        ImageInfo imageInfo = Image
        String resource = "C:\\Program Files (x86)\\Steam\\steamapps\\workshop\\content\\431960\\1494859043\\images";
//        String destinationW  = "D:\\图片\\pic\\宽";
//        String destinationH = "D:\\图片\\pic\\长";
        List<File> files =  DirectoryUtils.listAllFiles(new File(resource),"jpg");
        int length = files.size()/10;
        BufferedImage bufferedImage;
//                    Iterator<File> fileIterator = fileT.iterator();
        System.out.println(files.size());
        int i = 0;
        for (File f:files) {
            System.out.println(f.getName());
            try {
                bufferedImage = ImageIO.read(f);
                f.renameTo(new File(resource,i+++".jpg"));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        String dir = "C:\\Program Files (x86)\\Steam\\steamapps\\workshop\\content\\431960\\1494859043\\images";
//        List<File> list = DirectoryUtils.listAllFiles(new File(dir));
//        for(int i = 0;i<66;i++){
//            File file = list.get(i);
//            file.renameTo(new File("C:\\Program Files (x86)\\Steam\\steamapps\\workshop\\content\\431960\\1494859043\\images\\"+(i+1)+".jpg"));
//        }


    }
}
