package com.yukong.chapter6.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author qinjunjie
 * @projectName testDemo
 * @title: SpliceMusic
 * @description: IO流 拼接音频
 * @date 2019/7/3017:16
 */
public class SpliceMusic {

    public static void main(String[] args) {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        String[] fileNames = {"D:\\备份\\示例歌曲\\我只在乎你.mp3","D:\\备份\\示例歌曲\\星月神话.mp3","D:\\备份\\示例歌曲\\K. Williams - 夜的钢琴曲.mp3"};
        System.out.println("文件个数: "+fileNames.length);
        // 每次读取8K
        byte[] bytes = new byte[1024*8];
        try {
            outputStream = new FileOutputStream("D:\\备份\\合并.mp3");
            for (int i=0;i<fileNames.length;i++){
                int count = 0;
                inputStream = new FileInputStream(fileNames[i]);
                // 跳过前面3M
                inputStream.skip(1024*1024*3);
                while (inputStream.read(bytes) != -1){
                    outputStream.write(bytes);
                    count ++;
                    //System.out.println("写入次数: "+count);
                    if (count == (1024*2/8)){
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                outputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
