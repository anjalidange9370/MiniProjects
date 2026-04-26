package Ternary_oprator;
import java.util.Scanner;
public class Shopping {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("============Online Shopping Billing System=========");
	System.out.println("enter the total amount");
	double tamount=sc.nextDouble();
	System.out.println("Are you prime Customer(Yes/No)");
	String custtype=sc.next();
	double dilcharge=0;
	double discount=0;
	double famount=0;
	if(tamount>5000) {
		discount = tamount * 0.20;
	}
	else if (tamount > 2000) {
      discount = tamount * 0.10;
  } else {
      discount=0;
  }
	if(custtype.equals("Yes")) {
		System.out.println("No delivery charge");
		dilcharge=0;
	}
	else if(tamount>1000){
		dilcharge=0;
	}
	else if(tamount>500) {
		dilcharge=20;
	}
	else {
		dilcharge=50;
	}
	famount=tamount-discount+dilcharge;
	   System.out.println("Discount is: " + discount);
     System.out.println("Dilivery Charge is: " + dilcharge);
    System.out.println("Final Amount is : " + famount);
      
	}
}











