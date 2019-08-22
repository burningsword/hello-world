package pers.wk.test.java8.functionreference;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: wuke
 * @create: 2019-07-06 16:14
 **/
public class FunctionReferenceTest {

    public static void main(String[] args) {
        // 构造器引用
        Car car = Car.create(Car::new);

        List<Car> cars = Arrays.asList(car);

        // 静态方法引用
        cars.forEach(Car::collide);

        // 特定类任意对象的方法引用
        cars.forEach(Car::breakDwon);

        // 特定对象的方法引用
        Car police = Car.create(Car::new);
        cars.forEach(police::follow);
    }
}
