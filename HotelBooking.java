package Ternary_oprator;
import java.util.Scanner;
public class HotelBooking {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("===== Hotel Booking System =====");
    System.out.println("WELCOME TO RADHESHYAM HOTEL");
    System.out.print("Enter number of nights: ");
    int nights = sc.nextInt();
    System.out.print("Enter room type (1.Standard / 2.Deluxe / 3.Suite): ");
   System.out.println("1.Standard");
   System.out.println("2.Deluxe");
   System.out.println("3.Suite");
   String type=" ";
   int choose=sc.nextInt();
    //String type = sc.next();
   int rent=0;
   switch(choose) {
   case 1:rent = 1500;type = "Standard";break;
   case 2:rent = 2500;type = "Deluxe";break;
   case 3:rent = 4000;type = "Suite";break;
   default:System.out.println("Invalid choice");return;
}double total = rent * nights;
 System.out.print("Do you want breakfast and spa(Y/N)? "); 
 char ans = sc.next().charAt(0);
 double bfast = 300;
 double spa = 300;
 double total_breakfast = 0;
 double total_spa = 0;
        if(ans == 'Y' || ans == 'y') {
            total_breakfast = bfast * nights;
            total_spa = spa * nights;
        }
        double total_bill = total + total_breakfast + total_spa;
        double discount = 0;
        if(nights > 7) {
            discount = total_bill * 0.10; 
        }
        double after_discount = total_bill - discount;
        double tax = after_discount * 0.05;
        double final_bill = after_discount + tax;
        System.out.println("=====Recipt=====");
        System.out.println("You have selected "+type);
        System.out.println("Room Rent: " + total);
        System.out.println("Breakfast: " + total_breakfast);
        System.out.println("Spa: " + total_spa);
        System.out.println("Discount: " + discount);
        System.out.println("Tax: " + tax);
        System.out.println("Final Bill: " + final_bill);
    }
}