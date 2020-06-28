package club.banyuan.reservation.dto;

import club.banyuan.reservation.model.Seat;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * @author HanChao
 * @date 2020-06-22 20:45
 * 描述信息：
 */
@Getter
@Setter
public class ResercationPram{
    private Integer id;
    private Integer userId;
    private Integer positionId;
    private position position;
    private String date;
    private Integer hour;
    private Boolean cancelFlag;
    private String createdAt;
    private String updatedAt;

}
