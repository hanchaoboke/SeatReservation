package club.banyuan.reservation.mapper;

import club.banyuan.reservation.model.Seat;
import club.banyuan.reservation.model.SeatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SeatMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seat
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    long countByExample(SeatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seat
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    int deleteByExample(SeatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seat
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seat
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    int insert(Seat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seat
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    int insertSelective(Seat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seat
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    List<Seat> selectByExample(SeatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seat
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    Seat selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seat
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    int updateByExampleSelective(@Param("record") Seat record, @Param("example") SeatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seat
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    int updateByExample(@Param("record") Seat record, @Param("example") SeatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seat
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    int updateByPrimaryKeySelective(Seat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seat
     *
     * @mbg.generated Mon Jun 22 15:26:39 CST 2020
     */
    int updateByPrimaryKey(Seat record);
}