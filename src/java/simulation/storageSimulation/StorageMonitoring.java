import java.math.BigDecimal;

import model.environment.*;

public class StorageMonitoring {

    /*
        监测系统具有唯一对应的监测环境
        同时对于所有监测值具有确定的正常标准
    */
    private StorageEnvironment storageEnvironment;
    private EnvironmentStandard temperature_Standard;
    private EnvironmentStandard humidity_Standard;
    private EnvironmentStandard oxigenContent_Standard;

    public StorageMonitoring (EnvironmentModel temperature , EnvironmentStandard temperature_Standard,
    EnvironmentModel humidity , EnvironmentStandard humidity_Standard,
    EnvironmentModel oxigenContent , EnvironmentStandard oxigenContent_Standard) {

        this.storageEnvironment = new StorageEnvironment(temperature,humidity,oxigenContent);
        this.temperature_Standard = temperature_Standard;
        this.humidity_Standard = humidity_Standard;
        this.oxigenContent_Standard = oxigenContent_Standard;
    }

    String checkRange(double value,double stdMin,double stdMax) {
        if(stdMin <= value && value <= stdMax) return "正常";
        return "异常";
    }

    void update() {
        //环境波动
        storageEnvironment.environmentRand();

        double temperature = storageEnvironment.getTemperature();
        double humidity = storageEnvironment.getHumidity();
        double oxigenContent =storageEnvironment.getOxigenContent(); 

        showInfo(temperature,humidity,oxigenContent);
    }

    void showInfo(double temperature,double humidity,double oxigenContent) {
        System.out.println("温度："+temperature+"度，环境"+checkRange(temperature,temperature_Standard.getMinimum(),temperature_Standard.getMaximum()));
        System.out.println("湿度："+humidity   +"% ，环境"+checkRange(humidity,humidity_Standard.getMinimum(),humidity_Standard.getMaximum()));
        System.out.println("含氧量"+oxigenContent+"% ，环境"+checkRange(oxigenContent,oxigenContent_Standard.getMinimum(),oxigenContent_Standard.getMaximum()));
    }
}