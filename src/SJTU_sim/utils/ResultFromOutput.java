package SJTU_sim.utils;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ResultFromOutput {
    public Boolean getResults(String outputPath, List<String> heads, List<Integer> indexs){
        System.out.println("Xist计算完成，正在收集数据并导出。。。");
        int count = heads.size();
        OutputStream outputStream = null;
        //判断行头与位置指数数目是否匹配
        if (count == indexs.size()){
            GetValue getValue = new GetValue();
            String [] results = new String[count];
            for (int i = 0; i < heads.size(); i++) {
                results[i] = getValue.getValue(outputPath, heads.get(i), indexs.get(i));
                if (results[i] == null){
                    return false;
                }
            }
            try {
                DateFormat dateFormat = new SimpleDateFormat("_yyyy_MM_dd_HH_mm");
                File resultsFile = new File("D:\\Xist_results\\result" + dateFormat.format(new Date()) + ".dat");
                outputStream = new FileOutputStream(resultsFile, true);
                for (int i = 0; i < count - 1; i++) {
                    outputStream.write((results[i]+"\t").getBytes());
                }
                outputStream.write((results[count-1] + "\n").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }else{
            System.out.println("搜索参数的行头和指数未配齐!!\n 请重新输入参数。。。");
            return false;
        }
    }
}
