package SJTU_sim;

import SJTU_sim.utils.GetValue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class XistConnect {
    public static void main(String[] args) {
        Process process = null;
        InputStream inputStream = null;
        String input = "D:\\Xist_inputs\\Xist_01.dat";
        String output = "D:\\Xist_outputs\\Xist_01.dat";
        try {
            //process = Runtime.getRuntime().exec("C:\\HTRI\\XchangerSuite6\\Xist\\xist.exe -i D:\\Xist_inputs\\Xist_01.dat -o D:\\Xist_outputs\\Xist_01.dat -r");
            process = Runtime.getRuntime().exec("C:\\HTRI\\XchangerSuite6\\Xist\\xist.exe -i " + input + " -o " + output + " -r");
            //process.waitFor();
            inputStream = process.getInputStream();
            byte[] b = new byte[1024];
            int size = 0;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            while ((size = inputStream.read(b)) > 0) {
                outputStream.write(b, 0, size);
            }
            System.out.println(outputStream.toString("gbk"));
            if(process.waitFor()!=0){
                if(process.exitValue()==1)
                System.err.println("failedrun!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (null != process) {
                process.destroy();
            }
        }
        System.out.println(GetValue.getValue(output,"13",6));
    }
}
