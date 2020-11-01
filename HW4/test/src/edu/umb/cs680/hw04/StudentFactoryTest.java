package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw04.Student.StudentStatus;

class StudentFactoryTest {
	
	Student inStateStudent= StudentFactory.createInStateStudent("Sam", "Boston");
	Student outStateStudent=StudentFactory.createOutStateStudent("Rohit", "Cambridge",6);
	Student intlStudent= StudentFactory.createIntlStudent("Joy", "California", 00614, "India");

	@Test
	public void StudentStatus_Instate() throws Exception {
		assertEquals(StudentStatus.INSTATE, inStateStudent.getStatus());
		}
	
	@Test
	public void StudentStatus_OutState() throws Exception{
	assertEquals(StudentStatus.OUTSTATE,outStateStudent.getStatus());
	}
	
	@Test
	public void StudentStatus_IntlState() throws Exception{
	assertEquals(StudentStatus.INTL,intlStudent.getStatus());
	}

}
