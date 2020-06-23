package club.banyuan.reservation.Controller.api.admin;

import club.banyuan.reservation.common.CommonResult;
import club.banyuan.reservation.dto.SeatParm;
import club.banyuan.reservation.mapper.SeatMapper;
import club.banyuan.reservation.model.Seat;
import club.banyuan.reservation.model.SeatExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author HanChao
 * @date 2020-06-22 19:41
 * 描述信息：和座位相关的api
 */
@RestController
@RequestMapping(value = "/api/admin/seat")
public class SeatController {

    @Autowired
    private SeatMapper seatMapper;

    @GetMapping(value = "/list")
    public CommonResult list () {

        SeatExample seatExample = new SeatExample();
        seatExample.setOrderByClause("id DESC");
        List<Seat> seatList = seatMapper.selectByExample(seatExample);
        return CommonResult.success(seatList);
    }

    @PostMapping(value = "/add")
    public CommonResult add () {

        Seat seat = new Seat();
        seat.setCreatedAt(new Date());
        seatMapper.insertSelective(seat);

        return CommonResult.success("OK");
    }

    @PostMapping(value = "/update")
    public CommonResult update (@RequestBody SeatParm parm) {

        // 查看seatID是否存在
        Seat seat = seatMapper.selectByPrimaryKey(parm.getId());
        if (seat == null) {
            return CommonResult.failed("该座位不存在");
        }

        // 修改状态
        SeatExample example = new SeatExample();
        example.createCriteria()
                .andIdEqualTo(parm.getId());
        seat.setRepair(true);
        seat.setActived((byte) 1);
        seatMapper.updateByExampleSelective(seat,example);

        return CommonResult.success("OK");
    }

    @PostMapping(value = "/delete/{id}")
    public CommonResult delete (@PathVariable(value = "id") Integer seatId) {

        // 查看seatID是否存在
        Seat seat = seatMapper.selectByPrimaryKey(seatId);
        if (seat == null) {
            return CommonResult.failed("该座位不存在");
        }

        // 删除座位
        SeatExample seatExample = new SeatExample();
        seatExample.createCriteria()
                .andIdEqualTo(seatId);
        seatMapper.deleteByExample(seatExample);
        return CommonResult.success("OK");
    }

}
