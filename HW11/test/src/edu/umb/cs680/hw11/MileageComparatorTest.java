package edu.umb.cs680.hw11;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MileageComparatorTest {

	@Test
	public void MileageCompare() {
		Car[] carArray = { new Car("Toyota", "RAV 4", 1000, 2019, 300000), new Car("Toyota", "RAV 4", 2000, 2018, 100000),
				new Car("Toyota", "RAV 4", 4000, 2020, 1000000) };
		ArrayList<Car> cars = new ArrayList<Car>(Arrays.asList(carArray));
		Collections.sort(cars, new MileageComparator());
		assertEquals(1000, cars.get(0).getMileage());
		assertEquals(2000, cars.get(1).getMileage());
		assertEquals(4000, cars.get(2).getMileage());
	}
}