package niu.study.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ThreadDownload extends Thread {
    private String name;//saved filename
    private String url;//internet picture address

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("the filename: "+name+" has been downloaded");
        super.run();
    }

    public  ThreadDownload(String url,String name){
        this.url = url;
        this.name = name;
    }

    public static void main(String[] args) {
        ThreadDownload thread0 = new ThreadDownload("https://ae01.alicdn.com/kf/He3e426f4090f46198d13bfea313379eeA.png","1.png");
        ThreadDownload thread1 = new ThreadDownload("https://ae01.alicdn.com/kf/He3e426f4090f46198d13bfea313379eeA.png","2.png");
        ThreadDownload thread2 = new ThreadDownload("https://ae01.alicdn.com/kf/He3e426f4090f46198d13bfea313379eeA.png","3.png");
        thread0.start();
        thread1.start();
        thread2.start();
    }
}
//Downloader
class WebDownloader{
    //download method
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Exception,which is in downloader method");
        }
    }
}
