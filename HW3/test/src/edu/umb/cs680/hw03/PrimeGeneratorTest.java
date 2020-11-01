package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrimeGeneratorTest {

	@Test
	public void generatePrimes1to20()
	{
		PrimeGenerator p = new PrimeGenerator(1,20);
		p.generatePrimes();
		Long[] expectedPrimes = {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L};
		assertArrayEquals( expectedPrimes,p.getPrimes().toArray());
	}

	@Test
	public void is46Prime() {
		PrimeGenerator p = new PrimeGenerator(1,200);
		boolean expected=true;
		boolean actual = p.isPrime(197);
		assertEquals(expected,actual);
		
	}
	@Test
	public void is198Prime() {
		PrimeGenerator p = new PrimeGenerator(1,200);
		boolean expected=false;
		boolean actual = p.isPrime(198);
		assertEquals(expected,actual);
		
	}
	@Test
	public void WrongRange100to1() {
		try{
			PrimeGenerator p = new PrimeGenerator(100,1);
			fail("Wrong input values: from=" + p.from + " to=" + p.to);
		}
		catch(RuntimeException ex){
			assertEquals("Wrong input values: from=100 to=1", ex.getMessage());
		}
		
	}
	@Test
	public void WrongRangeNegative10to10() {
		try{
			PrimeGenerator p = new PrimeGenerator(-10,10);
			fail("Wrong input values: from=" + p.from + " to=" + p.to);
		}
		catch(RuntimeException ex){
			assertEquals("Wrong input values: from=-10 to=10", ex.getMessage());
		}
		
	}

}
