import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//Array.java

public class Array {
    public static void main(String[] args) {
        ArrayList<Long> arr = new ArrayList<>();
        int i = 1;
        System.out.println("Please enter the array's elements!\nType \"stop\" to end the array");
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("Enter the "+i+" element of the array: ");
            if(!sc.hasNextLong()) break;
            arr.add(sc.nextLong());
            i++;
        }while(true);
        //Sort the array
        Collections.sort(arr);
        System.out.println("The sorted array is: ");
        long sum = 0;
        for(int j = 0; j<arr.size(); j++ ){
            System.out.print(arr.get(j)+ " ");
            sum+= arr.get(j);
        }
        System.out.println("\nThe sum of all element is: "+sum);
        System.out.println("The average value of all element is: "+(sum/arr.size()));
    }
}
