package edu.umb.cs680.hw11;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PriceComparatorTest {

	@Test
	public void compareTest() {
		Car[] carArray = { new Car("Toyota", "RAV 4", 1000, 2019, 300000), new Car("Toyota", "RAV 4", 2000, 2018, 100000),
				new Car("Toyota", "RAV 4", 4000, 2020, 1000000) };
		ArrayList<Car> cars = new ArrayList<Car>(Arrays.asList(carArray));
		Collections.sort(cars, new PriceComparator());
		assertEquals(300000, cars.get(0).getPrice());
		assertEquals(100000, cars.get(1).getPrice());
		assertEquals(1000000, cars.get(2).getPrice());
	}
}