package ir.amirza.test.controller;

import ir.amirza.test.dto.CarDto;
import ir.amirza.test.model.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/car")
public class CarController {

    public static List<Car> cars = List.of(new Car(1L, "benz", 2023), new Car(2L, "pegeout", 2014));

    @PostMapping(value = "/list")
    List<Car> listCar() {
        return cars;
    }

    @GetMapping(value = "/get")
    Car getCar(@RequestParam("id") Long id) {
        return cars.stream().filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException(" id is not valid "));
    }

    @GetMapping("/{company}/list")
    public String listByCompany(@PathVariable String company) {
        System.out.println(company);
        return company;
    }

    @PutMapping("/add")
    public boolean addCar(@RequestBody(required = true) CarDto newCarDto){
        var newCar = new Car(newCarDto);
        return true;
    }


}
