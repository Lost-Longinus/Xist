package SJTU_sim.utils;

import java.io.*;

public class SetValue {
    /**
     * @param path input.dat文件绝对路径
     * @param lineNum 修改参数所在行
     * @param index 所需修改参数，是该行第几个subString，from 0
     * @param value 修改后的值 ！！如果是该行第一个值，前面须加12个空格符，修改前后字符数必须相等
     * @return 修改成功返回true，否则false
     */
    public static Boolean setValue(String path, int lineNum, int index, String value){
        try {
            RandomAccessFile randf = new RandomAccessFile(path, "rw");
            String tempString = null;
            int lineCount = 0;
            while((tempString = randf.readLine()) != null){
                lineCount++;
                StringBuffer sb = new StringBuffer();
                 //定位修改行及修改参数
                if (lineCount == lineNum){
                    Long position = randf.getFilePointer();
                    //包含换行符\n占两个byte
                    randf.seek(position-tempString.length()-2);
                    String [] paras = tempString.split(",?\\s+");
                    //修改参数值
                    paras[index] = value;
                    for (int i = 0; i < paras.length; i++) {
                        sb.append(paras[i] + ",      ");
                    }
                    //加上换行符
                    sb.append(System.getProperty("line.separator"));
                    //写回修改行
                    randf.write(sb.toString().getBytes());
                    randf.close();
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    //以下方法需要修改成另外一个input.dat文件，不如上面方法直接在源文件修改性价比高
    /*public static Boolean setValue(String path, int lineNum, int index, String value){
        try {
            FileReader reader = new FileReader(path);
            BufferedReader br = new BufferedReader(reader);
            FileWriter writer = new FileWriter(new File("D:\\Xist_inputs\\Xist_02.dat"));
            BufferedWriter bw = new BufferedWriter(writer);
            int lineCount = 0;
            String tmp = null;
            StringBuffer sb = new StringBuffer();
            while((tmp = br.readLine()) != null){
                lineCount++;
                if (lineCount == lineNum) {
                    String [] paras = tmp.split(",\\s+");
                    paras[index] = value;
                    for (int i = 0; i < paras.length; i++) {
                        sb.append(paras[i] + ",      ");
                    }

                } else {
                    sb.append(tmp);
                }
                sb.append(System.getProperty("line.separator"));
            }
            bw.write(sb.toString());
            br.close();
            reader.close();
            bw.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }*/
}


