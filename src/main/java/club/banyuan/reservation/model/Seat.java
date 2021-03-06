package club.banyuan.reservation.model;

import java.io.Serializable;
import java.util.Date;

public class Seat implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column seat.id
     *
     * @mbg.generated Tue Jun 23 11:13:40 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column seat.created_at
     *
     * @mbg.generated Tue Jun 23 11:13:40 CST 2020
     */
    private Date createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column seat.actived
     *
     * @mbg.generated Tue Jun 23 11:13:40 CST 2020
     */
    private Byte actived;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column seat.repair
     *
     * @mbg.generated Tue Jun 23 11:13:40 CST 2020
     */
    private Boolean repair;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table seat
     *
     * @mbg.generated Tue Jun 23 11:13:40 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column seat.id
     *
     * @return the value of seat.id
     *
     * @mbg.generated Tue Jun 23 11:13:40 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column seat.id
     *
     * @param id the value for seat.id
     *
     * @mbg.generated Tue Jun 23 11:13:40 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column seat.created_at
     *
     * @return the value of seat.created_at
     *
     * @mbg.generated Tue Jun 23 11:13:40 CST 2020
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column seat.created_at
     *
     * @param createdAt the value for seat.created_at
     *
     * @mbg.generated Tue Jun 23 11:13:40 CST 2020
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column seat.actived
     *
     * @return the value of seat.actived
     *
     * @mbg.generated Tue Jun 23 11:13:40 CST 2020
     */
    public Byte getActived() {
        return actived;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column seat.actived
     *
     * @param actived the value for seat.actived
     *
     * @mbg.generated Tue Jun 23 11:13:40 CST 2020
     */
    public void setActived(Byte actived) {
        this.actived = actived;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column seat.repair
     *
     * @return the value of seat.repair
     *
     * @mbg.generated Tue Jun 23 11:13:40 CST 2020
     */
    public Boolean getRepair() {
        return repair;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column seat.repair
     *
     * @param repair the value for seat.repair
     *
     * @mbg.generated Tue Jun 23 11:13:40 CST 2020
     */
    public void setRepair(Boolean repair) {
        this.repair = repair;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seat
     *
     * @mbg.generated Tue Jun 23 11:13:40 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", actived=").append(actived);
        sb.append(", repair=").append(repair);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}