package SJTU_sim;
import SJTU_sim.utils.GetValue;
import SJTU_sim.utils.SampleCaculate;
import SJTU_sim.utils.SetValue;

public class App {
    public static void main(String[] args) {
        String input = "D:\\Github\\Xist\\resource\\Xist_inputs\\Xist_01.dat";
        String output = "D:\\Github\\Xist\\resource\\Xist_outputs\\Xist_01.dat";
        SetValue.setValue(input, 8, 7, "800");
        System.out.println(GetValue.getValue(input,"BAFF,",7));
        SampleCaculate.run(input,output);
        System.out.println(GetValue.getValue(output,"13",6)+" / "+GetValue.getValue(output,"13",7));
        //考察折流板间距对换热系数影响---出现大量无效值，很诡异！！
        /*for (int i = 0; i < 100; i++) {
            String value = 800 + i + "";
            SetValue.setValue(input, 8, 7, value);
            System.out.println(GetValue.getValue(input,"BAFF,",7));
            SampleCaculate.run(input,output);
            System.out.println(GetValue.getValue(output,"13",6)+" / "+GetValue.getValue(output,"13",7));
        }*/
    }
}
