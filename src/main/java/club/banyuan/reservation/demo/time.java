package club.banyuan.reservation.demo;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author HanChao
 * @date 2020-06-22 22:36
 * 描述信息：
 */
public class time {
    public static void main(String[] args) {
        DateTime time = DateTime.now();
        System.out.println(time);
        int dat = time.hour(true);
        System.out.println(dat);


        int hour = DateUtil.hour(time,true);
        System.out.println(hour);


    }
}
