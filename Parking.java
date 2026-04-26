//online parking system
package Ternary_oprator;
import java.util.Scanner;
public class Parking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("======= Smart Parking Fee Calculator =======");
        // Step 1: Input
        System.out.print("How many hours do you want to park your vehicle: ");
        int hrs = sc.nextInt();
        double rate;
        double total;
        double fine = 0;
        if (hrs <= 2) {
            rate = 20;
        } else if (hrs <= 5) {
            rate = 30;
        } else {
            rate = 50;
        }
        total = hrs * rate;
        if (hrs > 10) {
            fine = 100;
        }
        double finalAmount = total + fine;
        System.out.println("Rate per hour: " + rate);
        System.out.println("Parking Fee: " + total);
        System.out.println("Fine: " + fine);
        System.out.println("Total Bill: " + finalAmount);
    }
}


