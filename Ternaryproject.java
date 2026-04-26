package Ternary_oprator;
import java.util.Scanner; 
public class Ternaryproject {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	while(true) {
	System.out.println("enter your marks");
	int marks=sc.nextInt();
	//pass or fail
	  String result = (marks >= 40) ? "Pass" : "Fail";
	//grade
	String grade=(marks>90)?"A":(marks>70)?"B":(marks>60)?"C":(marks>50)?"D":"F";
	//ScholershipEligibility
	String Scholership=(marks>80)?"full scholership":(marks>50)?"Half Scholership":"No schoership";
    //Remark
	String remark=(marks>90)?"Excellent":(marks>80)?"very good":(marks>70)?"good":"Avergare marks";
	System.out.println("Result : "+result);
	System.out.println("Grade  : "+grade);
    System.out.println("Schoership Status : "+Scholership);
    System.out.println("marks  : "+marks);
}
}
}