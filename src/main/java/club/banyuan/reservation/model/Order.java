package club.banyuan.reservation.model;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.id
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.user_id
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.seat_id
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    private Integer seatId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.created_at
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    private Date createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.duration
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    private Byte duration;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.actived
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    private Boolean actived;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table order
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.id
     *
     * @return the value of order.id
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.id
     *
     * @param id the value for order.id
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.user_id
     *
     * @return the value of order.user_id
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.user_id
     *
     * @param userId the value for order.user_id
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.seat_id
     *
     * @return the value of order.seat_id
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    public Integer getSeatId() {
        return seatId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.seat_id
     *
     * @param seatId the value for order.seat_id
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.created_at
     *
     * @return the value of order.created_at
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.created_at
     *
     * @param createdAt the value for order.created_at
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.duration
     *
     * @return the value of order.duration
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    public Byte getDuration() {
        return duration;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.duration
     *
     * @param duration the value for order.duration
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    public void setDuration(Byte duration) {
        this.duration = duration;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.actived
     *
     * @return the value of order.actived
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    public Boolean getActived() {
        return actived;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.actived
     *
     * @param actived the value for order.actived
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    public void setActived(Boolean actived) {
        this.actived = actived;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", seatId=").append(seatId);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", duration=").append(duration);
        sb.append(", actived=").append(actived);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}