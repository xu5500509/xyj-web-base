package cn.xyj.ssm.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试定时任务
 * Created by xuyangjian on 2018/1/11.
 */
@Component
public class MyProcessor{

    DateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    int[] delays = new int[]{8,3,6,2,2};
    int index = 0;
    int process2Index = 0;

    @Async
    @Scheduled(cron = "0/5 * * * * ?")
    public void process() {
        try {
            if(index > delays.length - 1){
                if(index == delays.length){
                    System.out.println("---------- test end at " + sdf.format(new Date()) + " ---------");
                }
                index ++;
                return;
            }else{
                System.out.println(index + ":process start run at" + sdf.format(new Date()));
            }
            Thread.sleep(delays[index] * 1000);
            System.out.println(index + ":process end run at " + sdf.format(new Date()));
            index ++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    @Scheduled(cron = "0/1 * * * * ?")
//    public void process2() {
//        try {
//            System.out.println(process2Index + ":process2 start run at" + sdf.format(new Date()));
//            Thread.sleep(5000);
//            System.out.println(process2Index + ":process2 end run at " + sdf.format(new Date()));
//            process2Index ++;
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}