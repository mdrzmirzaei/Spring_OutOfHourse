package ir.amirza.test.model;

import ir.amirza.test.dto.CarDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private Long Id;
    private String carName;
    private Integer yearOfProduce;

    public Car(CarDto carDto) {
        this.carName = carDto.getCarName();
        this.yearOfProduce = carDto.getYearOfProduce();
    }
}
