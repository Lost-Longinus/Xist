package SJTU_sim.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetValue {
    /**
     *
     * @param path output.dat文件绝对路径
     * @param label 参数所在行标签，如13
     * @param index 参数是该行第几个subString，from 0
     * @return 返回获取参数值，String
     */
    public String getValue(String path, String label, int index){
        try {
            File file = new File(path);
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String tempString = null;
            while((tempString = br.readLine()) != null){
                if (tempString.contains("FATAL ERRORS")){
                    break;
                }
                if (tempString.startsWith(label)){
                    String[] paras = tempString.split("\\s+");
                    return paras[index];
                }
            }
            br.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
