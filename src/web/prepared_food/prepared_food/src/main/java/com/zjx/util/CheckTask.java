package com.zjx.util;

import com.zjx.dao.BaseDao;
import com.zjx.dao.BaseInfoDao;
import com.zjx.dao.CommentDao;
import com.zjx.entity.BaseInfo;
import com.zjx.entity.Comment;
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
@EnableScheduling
public class CheckTask {
    public CheckTask(){
        System.out.println("初始化Check");
    }

    private int dayMax = 1;
    private int hourMax = 1;
    private int weekMax = 1;

    final int hour = 1000*60*60;
    final int day = 24 * hour;
    final int week = 7 * day;

    @Resource
    private CommentDao commentDao;
    @Resource
    private BaseInfoDao baseInfoDao;

    @Scheduled(fixedDelay = 5000)
    public void checkHour(){
        check(hourMax,1);
//        System.out.println("check");
    }
//    @Scheduled(fixedDelay = 1000)
//    public void checkDay(){
//        check(dayMax,2);
//    }
//    @Scheduled(fixedDelay = 1)
//    public void checkWeek(){
//        check(weekMax,3);
//    }

    public void check(int max,int type){
        System.out.println("开始检测");
        List<BaseInfo> baseInfos = baseInfoDao.getAllItems();
        for(BaseInfo item : baseInfos){
            int count = 0;
            switch (type){
                case 1:
                    count = commentDao.queryItemInHour(item.getIdentificationCode());
                    break;
                case 2:
                    count = commentDao.queryItemInDay(item.getIdentificationCode());
                    break;
                case 3:
                    count = commentDao.queryItemInWeek(item.getIdentificationCode());
            }
            if(count >= max){
                System.out.println("异常");
            }
        }
    }
}
