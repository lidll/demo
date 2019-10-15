package com.noah.demo;
import java.io.*;

/**
 * @ClassName 读取文件
 * @Description TODO
 * @Author noah
 * @Date 2019-08-06 10:44
 * @Version 1.0
 **/
public class ReadFile {

    public static void main(String[] args) {
        //File file = new File("/Users/noah/desktop/2019-04-04.log");

        File file = new File("/Users/noah/desktop/casecluemanage19.6.24的副本.sql");
        //缓冲区
//        try {
//            //一次性读取内容到缓冲区,缓冲区的大小由自己决定
//            FileReader fileReader = new FileReader(file);
//            int num = 0;
//            char[] chars = new char[1024];
//                while((num = fileReader.read(chars)) != -1){
//                    System.out.println(new String(chars,0,num));
//            }
//        } catch ( FileNotFoundException e) {
//            e.printStackTrace();
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//    }

        String filePath = "/Users/noah/desktop/casecluemanage19.6.24的副本.sql";
        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            int count = 0;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                count++;
            }
            bufferedReader.close();
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=总共"+count+"行-=-=-=-=-=-=-=-=-=-=-");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
