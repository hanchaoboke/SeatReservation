package club.banyuan.reservation.demo;

import java.sql.Timestamp;

/**
 * @author HanChao
 * @date 2020-06-22 22:36
 * 描述信息：
 */
public class time {
    public static void main(String[] args) {
        String str = "2010-12-12 14:23:22";
        Timestamp t1 = Timestamp.valueOf(str);
        System.out.println(t1);
    }
}
