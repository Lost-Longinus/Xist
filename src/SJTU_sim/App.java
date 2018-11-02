package SJTU_sim;
import SJTU_sim.utils.ResultFromOutput;
import SJTU_sim.utils.SampleCaculate;
import SJTU_sim.utils.SetValue;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        String input = "D:\\Xist_inputs\\Xist_01.dat";
        String output = "D:\\Xist_outputs\\Xist_01.dat";

        //考察折流板间距对换热系数影响---出现大量无效值，很诡异！！
        execute(input,output);
    }

    public static void execute(String input, String output){
        ResultFromOutput result = new ResultFromOutput();
        for (int i = 0; i < 2; i++) {
            String value = 600 + i + "";
            SetValue.setValue(input, 8, 7, value);
            SampleCaculate.run(input,output);
            //设置需获取参数所在行第一个字符串
            String[] headsArray = {"41", "13", "13"};
            //设置需获取参数是所在行第几个字符串，from 0
            Integer[] indexsArray = {4, 6, 7};
            //收集参数并导出到Xist_results文件夹中
            result.getResults("D:\\Xist_outputs\\Xist_01.dat", Arrays.asList(headsArray), Arrays.asList(indexsArray));
        }
    }
}
