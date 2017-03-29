/**
 * 
 */
package com.cn.fd.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * <p> Description: </p>
 * @author fengda
 * @date 2017年3月15日 下午2:11:35
 */
@Component
public class SchedulerTask {

    private int count=0;

//    @Scheduled(fixedRate = 6000) ：上一次开始执行时间点之后6秒再执行
//    @Scheduled(fixedDelay = 6000) ：上一次执行完毕时间点之后6秒再执行
    //@Scheduled(cron="*/6 * * * * ?")
    private void process(){
        System.out.println("this is scheduler task runing  "+(count++));
    }

}
