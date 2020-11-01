package edu.umb.cs680.hw04;

public class Student {
	
	private float tuition;
	private String name; 
	private int i20num;
	private String usAddr; 
	private int yrsInState;
	private String foreignAddr;
	private StudentStatus status;
	
public enum StudentStatus {
		INSTATE ,OUTSTATE, INTL
}
	
 public Student( String name, String usAddr ,int yrsInState, int i20num, String foreignAddr, StudentStatus status) {
	 this.name=name;
	 this.usAddr=usAddr;
	 this.yrsInState=yrsInState;
	 this.i20num=i20num;
	 this.foreignAddr=foreignAddr;
	 this.status=status;
 }
 public String getName() {
		return name;
		}
 public String getUsAddr(){
	 return usAddr;
	 
 }
 public String getForeignAddr() {
	 return foreignAddr;
 }
public float getTuition(){
	
	if (status.equals(StudentStatus.INSTATE))
		return 8000;
		else if (status.equals(StudentStatus.OUTSTATE))
		return 16000;
		else
		return 20000;
	}

public StudentStatus getStatus() {
	return status;
}
public int getI20Num() {
	return i20num;
}
public int getYrsInState() {
	return yrsInState;
}

public static void main(String[] args) {
	Student inStateStudent= StudentFactory.createInStateStudent("Sam", "Boston");
	System.out.println("Status of student: " + inStateStudent.getStatus() +"\n"
            +"Name of student : "+inStateStudent.getName()+ "\n"
            +"US address : "+inStateStudent.getUsAddr()+"\n"
            +"Student tuitionFee : "+inStateStudent.getTuition()+"\n");
	
	Student outStateStudent=StudentFactory.createOutStateStudent("Rohit", "Cambridge", 8);
	System.out.println("Status of student: " + outStateStudent.getStatus() +"\n"
            +"Name of student : "+ outStateStudent.getName()+ "\n"
            +"US address : "+ outStateStudent.getUsAddr()+"\n"
            +"Years In State : "+ outStateStudent.getYrsInState()+ "\n"
            +"Student tuitionFee : "+ outStateStudent.getTuition() + "\n");
	
	Student intlStudent=StudentFactory.createIntlStudent("Joy", "California", 56324, "India");
	System.out.println("Status of student: " + intlStudent.getStatus() +"\n"
            +"Name of student : "+intlStudent.getName()+ "\n"
            +"US address : "+intlStudent.getUsAddr()+"\n"
            +"I20 number : "+intlStudent.getI20Num()+ "\n"
            +"Student tuitionFee : "+intlStudent.getTuition() + "\n");

}

}
