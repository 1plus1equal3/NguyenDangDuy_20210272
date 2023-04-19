import java.util.Scanner;

//Triangle.java

public class Triangle {
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the triangle's height: ");
        num = sc.nextInt();
        for(int i = 1; i<=num; i++){
            for(int j = i; j<num; j++) System.out.print(" ");
            for(int k = 0; k<i*2-1; k++) System.out.print("*");
            System.out.println();
        }
    }
}
