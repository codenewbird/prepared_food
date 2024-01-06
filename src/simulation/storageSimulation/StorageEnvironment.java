import java.math.BigDecimal;
import model.environment.*;
/*
    实现存储环境的模拟
    环境温度、湿度将会在一个区间内进行波动
    同时数据将上传
*/
class StorageEnvironment {
    /*
        存储环境模拟三个环境
        温度、湿度、含氧量
    */
    private EnvironmentModel temperature;
    private EnvironmentModel humidity;
    private EnvironmentModel oxigenContent;
    
    /*
        构造函数
        设置好各个环境的模拟
    */
    public StorageEnvironment(EnvironmentModel temperature,EnvironmentModel humidity,EnvironmentModel oxigenContent) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.oxigenContent = oxigenContent;
    }

    /*
        模拟环境变化
    */
    void environmentRand() {
        temperature.valRand();
        humidity.valRand();
        oxigenContent.valRand();
    }

    /*
        对于每一个环境模型都要提供返回方法
    */
    double getTemperature() {
        return temperature.getValue();
    }

    double getHumidity() {
        return humidity.getValue();
    }

    double getOxigenContent() {
        return oxigenContent.getValue();
    }

    
}