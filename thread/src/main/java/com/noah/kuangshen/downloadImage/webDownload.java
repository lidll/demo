package com.noah.kuangshen.downloadImage;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @ClassName webDownload
 * @Description 线程下载文件
 * @Author noah
 * @Date 4/12/21 2:15 PM
 * @Version 1.0
 **/
public class webDownload implements Runnable{

    private String url;
    private String fileName;

    @Override
    public void run() {
        downloadUtil downloadUtil = new downloadUtil();
        downloadUtil.downloadImg(url,fileName);
        System.out.println(fileName + ",文件已下载");
    }

    public webDownload(String url,String fileName){
        this.url = url;
        this.fileName = fileName;
    }


    public static void main(String[] args) {
        Thread t1 = new Thread(new webDownload("https://tb1.bdstatic.com/tb/%E8%B5%9B%E5%8D%9A%E6%9C%8B%E5%85%8B2077.jpg", "1.jpg"));
        t1.start();
    }

}
class downloadUtil{

    public void downloadImg(String url,String fileName){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("下载文件失败");
        }
    }
}
