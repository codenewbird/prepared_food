import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Random;
import model.environment.*;

public class StorageWorking {

    /*
        假设每隔预设时间发送一次相关信息
        单位:ms
    */
    final static private int timeSlice = 1000; 
    private StorageMonitoring storageMonitoring;

    public static void main(String[] args) {
        /*
            温度波动范围
            温度理想范围
        */
        EnvironmentModel temperature = new EnvironmentModel(14,20);
        EnvironmentStandard temperature_Standard = new EnvironmentStandard(16,18);

        /*
            湿度波动范围
            湿度理想范围
        */
        EnvironmentModel humidity = new EnvironmentModel(10,16);
        EnvironmentStandard humidity_Standard = new EnvironmentStandard(12,14);

        /*
            含氧量波动范围
            含氧量理想范围
        */
        EnvironmentModel oxigenContent = new EnvironmentModel(16,22);
        EnvironmentStandard oxigenContent_Standard = new EnvironmentStandard(18,20);


        StorageMonitoring storageMonitoring = new StorageMonitoring(
            temperature,temperature_Standard,
            humidity,humidity_Standard,
            oxigenContent,oxigenContent_Standard
        );

        /*
            输入1正常模拟
            输入2直接输出一个异常
        */

        int flag;
        Scanner scanner = new Scanner(System.in);
        clear();
        System.out.println("仓储环境模拟，输入数字进行操作");
        System.out.println("1.模拟正常环境    2.获取一个异常");
        flag = scanner.nextInt();
        clear();
        
        if(flag == 1) {
            while(true) {
                storageMonitoring.update();

                try {
                    Thread.sleep(timeSlice);
                } catch (Exception e) {

                }
                clear();
            }
        }
        else {
            fakeException(temperature_Standard,humidity_Standard,oxigenContent_Standard);
            System.out.println("按下任意键结束...");
            scanner.nextLine();
            scanner.nextLine();
        }
        
    }

    static void fakeException(EnvironmentStandard temperature_Standard,EnvironmentStandard humidity_Standard,EnvironmentStandard oxigenContent_Standard) {
        Random rand = new Random();
        /*
            模拟随机异常，首先产生1到7的数字
            第一位1表示温度异常
            第二位1表示湿度异常
            第三位1表示含氧量异常
        */
        int state=rand.nextInt(7) + 1;
        System.out.println(state);
        

        double temperature = randException(temperature_Standard.getMinimum(),temperature_Standard.getMaximum(),state&4);
        double humidity = randException(humidity_Standard.getMinimum(),humidity_Standard.getMaximum(),state&2);
        double oxigenContent = randException(oxigenContent_Standard.getMinimum(),oxigenContent_Standard.getMaximum(),state&1);

        System.out.println("温度："+temperature+"度，环境"+checkRange(temperature,temperature_Standard.getMinimum(),temperature_Standard.getMaximum()));
        System.out.println("湿度："+humidity   +"% ，环境"+checkRange(humidity,humidity_Standard.getMinimum(),humidity_Standard.getMaximum()));
        System.out.println("含氧量"+oxigenContent+"% ，环境"+checkRange(oxigenContent,oxigenContent_Standard.getMinimum(),oxigenContent_Standard.getMaximum()));
    }

    static void clear() {
        try {
         new ProcessBuilder("cmd", "/c", "cls")
         .inheritIO()
         .start()
         .waitFor(); // 清屏命令                   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static double randException(double minimum,double maximum,int flag) {
        Random rand = new Random();
        double value;
        if(flag > 0) {
            if(rand.nextInt(2)==1) {
                value = new BigDecimal(maximum)
                .add(new BigDecimal(rand.nextInt(15)+1).divide(new BigDecimal(10)))
                .doubleValue();
            }
            else {
                value = new BigDecimal(minimum)
                .subtract(new BigDecimal(rand.nextInt(15)+1).divide(new BigDecimal(10)))
                .doubleValue();
            }
        }
        else {
            value = new BigDecimal(rand.nextInt((int)(maximum-minimum)))
            .add(new BigDecimal(minimum))
            .doubleValue();
        }

        return value;
    }

    static String checkRange(double value,double stdMin,double stdMax) {
        if(stdMin <= value && value <= stdMax) return "正常";
        return "异常";
    }
}