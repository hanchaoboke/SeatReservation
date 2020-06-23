package club.banyuan.reservation.dto;

import club.banyuan.reservation.model.Seat;

import java.sql.Timestamp;

/**
 * @author HanChao
 * @date 2020-06-22 20:45
 * 描述信息：
 */
public class ResercationPram extends Seat {

    private Integer userId;
    private Byte duration;
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private String durationAt;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Byte getDuration() {
        return duration;
    }

    public void setDuration(Byte duration) {
        this.duration = duration;
    }

    public String getDurationAt() {
        return durationAt;
    }

    public void setDurationAt(String durationAt) {
        this.durationAt = durationAt;
    }
}
