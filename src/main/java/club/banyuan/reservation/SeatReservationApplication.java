package club.banyuan.reservation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@RestController
@MapperScan("club.banyuan.reservation.mapper")
public class SeatReservationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeatReservationApplication.class, args);
    }

//    @GetMapping(value = "/")
//    public String test () {
//        return "<p>Hello</p>";
//    }
}
