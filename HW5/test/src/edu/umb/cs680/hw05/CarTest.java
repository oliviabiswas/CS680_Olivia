package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {
	
	private String[] carToStringArray(Car car) {
		String[] carString= { car.getMake(),car.getModel(),String.valueOf(car.getYear()) };
		return carString;
	}

	@Test
	public void verifyCarEqualityWithMakeModelYear() {
		String[] expected = {"Toyota", "RAV4", "2018"};
		Car actual = new Car("Toyota", "RAV4", 25, 2018,20000);
		assertArrayEquals(expected,carToStringArray(actual) );
	}

}
