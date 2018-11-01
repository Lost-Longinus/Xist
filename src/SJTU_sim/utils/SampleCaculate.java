package SJTU_sim.utils;


public class SampleCaculate {
    /**
     *
     * @param input input.dat文件绝对路径
     * @param output output.dat文件绝对路径
     */
    public static void run(String input, String output) {
        Process process = null;
        try {
            String cmd = "C:\\HTRI\\XchangerSuite6\\Xist\\xist.exe -i " + input + " -o " + output + " -r";
            //process = Runtime.getRuntime().exec("C:\\HTRI\\XchangerSuite6\\Xist\\xist.exe -i D:\\Xist_inputs\\Xist_01.dat -o D:\\Xist_outputs\\Xist_01.dat -r");
            process = Runtime.getRuntime().exec(cmd);
            //非常重要，决定output.dat文件能否生成！！！
            if(process.waitFor()!=0){
                if(process.exitValue()==1)
                    System.err.println("failed run!!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(null!= process){
                process.destroy();
            }
        }
    }
}
