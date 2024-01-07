package monitoring;

import java.util.Timer;

/*
 * 监控中心用
 * 每隔一段时间进行一次异常检测
 */
public class Work {
    public static void main(String[] args) {
        String prefoodId = "?";
        Timer timer = new Timer(true);
        

        timer.schedule(new MonitoringTask(prefoodId),0, 1000);
        
        while(true) {
            
        }
    }
}
