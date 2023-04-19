import java.util.Objects;
import java.util.Scanner;

/* 2.2.5: Write a program to calculate sum, difference, product, and quotient
of 2 double numbers which are entered by users*/
public class Calculator {
    public static void main(String[] args) {
        boolean check = true;
        int opt;
        double num1;
        double num2;
        do{
            printMenu();
            Scanner sc = new Scanner(System.in);
            System.out.print("Choose an option: ");
            opt = sc.nextInt();
            //Get 2 numbers
            System.out.print("Enter the 1st number: ");
            num1 = sc.nextDouble();
            System.out.print("Enter the 2nd number: ");
            num2 = sc.nextDouble();
            switch (opt){
                case 1:
                    System.out.println("The sum of " + num1 + " and " + num2 + " is " + (num1+num2));
                    break;
                case 2:
                    System.out.println("The difference of " + num1 + " and " + num2 + " is " + (num1-num2));
                    break;
                case 3:
                    System.out.println("The product of " + num1 + " and " + num2 + " is " + (num1*num2));
                    break;
                case 4:
                    if(num2!=0) System.out.println("The quotient of " + num1 + " and " + num2 + " is " + (num1/num2));
                    else System.out.println("The 2nd number is 0! \nCannot do quotient operation!");
                    break;
                default:
                    System.out.println("Wrong input option!");
                    break;
            }
            String c;
            System.out.print("Continue?(yes/no): ");
            c = sc.next();
            if(Objects.equals(c, "no")) check = false;
        }while(check);
    }

    public static void printMenu(){
        System.out.println("\n\nCalculator program");
        System.out.println("1. Sum of 2 numbers");
        System.out.println("2. Difference of 2 numbers");
        System.out.println("3. Product of 2 numbers");
        System.out.println("4. Quotient of 2 numbers\n");
    }

}
