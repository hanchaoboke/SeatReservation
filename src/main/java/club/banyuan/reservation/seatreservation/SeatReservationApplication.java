package club.banyuan.reservation.seatreservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SeatReservationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeatReservationApplication.class, args);
    }

    @GetMapping(value = "/")
    public String test () {
        return "<p>Hello</p>";
    }
}
