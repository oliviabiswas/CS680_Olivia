package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	public void testGetYear() {
		Car car = new Car("Toyota", "RAV 4", 20, 2019, 100000);
		int actual = car.getYear();
		int expected = 2018;
		assertEquals(actual, expected);
	}

	@Test
	public void testGetMileage() {
		Car car = new Car("Toyota", "RAV 4", 20, 2019, 100000);
		int actual = car.getMileage();
		int expected = 20;
		assertEquals(actual, expected);
	}

	@Test
	public void testGetPrice() {
		Car car = new Car("Toyota", "RAV 4", 20, 2019, 100000);
		float actual = car.getPrice();
		float expected = 10000;
		assertEquals(actual, expected);
	}
}