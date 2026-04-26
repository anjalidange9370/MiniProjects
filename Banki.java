package Ternary_oprator;
import java.util.Scanner;
public class Banki {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter bank balance:");
        double bankbalance = sc.nextDouble();
        if (bankbalance >= 1000){
            System.out.println("Enter amount to withdraw:");
            double amount = sc.nextDouble();
            if (amount > 0) {
                if (amount % 100 == 0) {
                    if (amount <= bankbalance) {
                    if ((bankbalance - amount) >= 1000) {
                  bankbalance = bankbalance - amount;
                 System.out.println("Withdrawal Successful");
           System.out.println("Remaining balance = " + bankbalance);
                } else {
                System.out.println("Minimum balance of 1000rs ");
                        }
                    } else {
                        System.out.println("Insufficient balance");
                    }
                } else {
                    System.out.println("Amount should be multiple of 100");
                }
            } else {
                System.out.println("Invalid amount");
            }
        } else {
            System.out.println("At least 1000 balance required");
        }
    }
}




