package monitoring;

import java.util.TimerTask;


/*
 * 监控任务，继承TimerTask
 * 指定了计时器的定时监控差评数任务
 */
public class MonitoringTask extends TimerTask{

    private String prefoodId;

    public MonitoringTask(String prefoodId) {
        this.prefoodId = prefoodId;
    }

    @Override
    public void run() {
        CommentMonitoring commentMonitoring = new CommentMonitoring(prefoodId);
        commentMonitoring.commentCheck(prefoodId);
    }
    
}
