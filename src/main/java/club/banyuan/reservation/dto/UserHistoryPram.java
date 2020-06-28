package club.banyuan.reservation.dto;


import java.util.Date;
/**
 * @author HanChao
 * @date 2020-06-24 09:53
 * 描述信息：
 */
public class UserHistoryPram {
    private Integer id;
    private Integer userId;
    private Integer positionId;
    private Byte hour;
    private String createdAt;
    private String updatedAt;
    private Boolean cancelFlag;
    private position position;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getCancelFlag() {
        return cancelFlag;
    }

    public void setCancelFlag(Boolean cancelFlag) {
        this.cancelFlag = cancelFlag;
    }

    public club.banyuan.reservation.dto.position getPosition() {
        return position;
    }

    public void setPosition(club.banyuan.reservation.dto.position position) {
        this.position = position;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Byte getHour() {
        return hour;
    }

    public void setHour(Byte hour) {
        this.hour = hour;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
