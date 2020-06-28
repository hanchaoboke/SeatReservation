package club.banyuan.reservation.dto;

/**
 * @author HanChao
 * @date 2020-06-22 20:14
 * 描述信息：
 */
public class SeatParm {
    private Integer id;
    private String name;
    private Byte actived;
    private Boolean repair;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getActived() {
        return actived;
    }

    public void setActived(Byte actived) {
        this.actived = actived;
    }

    public Boolean getRepair() {
        return repair;
    }

    public void setRepair(Boolean repair) {
        this.repair = repair;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
