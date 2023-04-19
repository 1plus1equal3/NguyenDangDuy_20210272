import java.util.Scanner;

//Matrix.java

public class Matrix {
    public static void main(String[] args) {
        int row, col;
        int[][] matrix1 = new int[100][100];
        int[][] matrix2 = new int[100][100];
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of row: ");
        row = sc.nextInt();
        System.out.print("Enter number of column: ");
        col = sc.nextInt();
        //Enter matrix 1's elements
        System.out.println("Enter matrix1's elements: ");
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        //Enter matrix 2's elements
        System.out.println("Enter matrix2's elements: ");
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        //Print out sum of 2 matrix
        System.out.println("The sum of 2 matrices is: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print((matrix1[i][j] + matrix2[i][j]) + " ");
            }
            System.out.println();
        }
    }
}
