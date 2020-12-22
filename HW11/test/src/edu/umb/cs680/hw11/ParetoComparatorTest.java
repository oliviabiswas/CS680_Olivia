package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class ParetoComparatorTest {
	@Test
	public void ParetoCompare() {
		Car[] carArray = { new Car("Toyota", "RAV 4", 1000, 2019, 300000), new Car("Toyota", "RAV 4", 2000, 2018, 100000),
				new Car("Toyota", "RAV 4", 4000, 2020, 100000),new Car("Toyota", "RAV 4", 3000, 2019, 150000) };
		ArrayList<Car> cars = new ArrayList<Car>(Arrays.asList(carArray));
		for (Car car : cars) {
			car.setDominationCount(cars);
		}
		Collections.sort(cars, new ParetoComparator());
		assertEquals(300000, cars.get(0).getPrice());
		assertEquals(100000, cars.get(1).getPrice());
		assertEquals(100000, cars.get(2).getPrice());
		assertEquals(150000, cars.get(3).getPrice());
	}
}