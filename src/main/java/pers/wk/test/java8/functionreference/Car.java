package pers.wk.test.java8.functionreference;

import lombok.Data;

import java.util.function.Supplier;

/**
 * @description:
 * @author: wuke
 * @create: 2019-07-06 16:16
 **/
@Data
public class Car {

    public static Car create(Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void breakDwon() {
        System.out.println(this + " broke down");
    }

    public void follow(Car car) {
        System.out.println(this + " is following " + car);
    }
}
