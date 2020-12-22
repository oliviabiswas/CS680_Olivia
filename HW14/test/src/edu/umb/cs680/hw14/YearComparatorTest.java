package edu.umb.cs680.hw14;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class YearComparatorTest {

	@Test
	public void YearCompare() {
		Car[] carArray = { new Car("Toyota", "RAV 4", 1000, 2019, 300000), new Car("Toyota", "RAV 4", 2000, 2018, 100000),
		new Car("Toyota", "RAV 4", 4000, 2020, 100000) };
		ArrayList<Car> cars = new ArrayList<Car>(Arrays.asList(carArray));
		Collections.sort(cars,(Car car1, Car car2) -> {
			return car2.getYear() - car1.getYear();
		});
		assertEquals(2019, cars.get(0).getYear());
		assertEquals(2018, cars.get(1).getYear());
		assertEquals(2020, cars.get(2).getYear());
	}
}