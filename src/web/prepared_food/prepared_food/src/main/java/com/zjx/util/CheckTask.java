package com.zjx.util;

import com.zjx.dao.BaseDao;
import com.zjx.dao.BaseInfoDao;
import com.zjx.dao.CommentDao;
import com.zjx.entity.BaseInfo;
import com.zjx.entity.Comment;
import com.zjx.websocket.WebSocket;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.TimerTask;

/**
 * @author 周锦兴
 */

@Component
//@EnableScheduling
public class CheckTask {
    public CheckTask(){
        System.out.println("初始化Check");
    }

    private int dayMax = 1;
    private int hourMax = 0;
    private int weekMax = 1;

    final int hour = 1000*60*60;
    final int day = 24 * hour;
    final int week = 7 * day;

    @Resource
    private WebSocket socket;
    @Resource
    private CommentDao commentDao;
    @Resource
    private BaseInfoDao baseInfoDao;

    @Scheduled(fixedDelay = 5000)
    public void checkHour(){
        check(hourMax,1);
//        System.out.println("check");
    }
    @Scheduled(fixedDelay = day)
    public void checkDay(){
        check(dayMax,2);
    }
    @Scheduled(fixedDelay = week)
    public void checkWeek(){
        check(weekMax,3);
    }

    public void check(int max,int type){
        System.out.println("开始检测");
        List<BaseInfo> baseInfos = baseInfoDao.getAllItems();
        for(BaseInfo item : baseInfos){
            int count = 0;
            switch (type){
                case 1:
                    Integer temp = commentDao.queryItemInHour(item.getIdentificationCode());
                    count = temp == null ? 0 : temp;
                    break;
                case 2:
                    Integer temp2 = commentDao.queryItemInDay(item.getIdentificationCode());
                    count = temp2 == null ? 0 : temp2;
                    break;
                case 3:
                    Integer temp3 = commentDao.queryItemInWeek(item.getIdentificationCode());
                    count = temp3 == null ? 0 : temp3;
            }
            if(count >= max){
                socket.sendAllMessage("异常");
            }
        }
    }
}
