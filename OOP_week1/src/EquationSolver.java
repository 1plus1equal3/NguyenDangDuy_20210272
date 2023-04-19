import java.util.Objects;
import java.util.Scanner;

public class EquationSolver {
    public static void main(String[] args) {
        boolean check = true;
        int opt;
        do {
            printMenu();
            Scanner sc = new Scanner(System.in);
            System.out.print("Choose an option: ");
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    firstDegreeEq();
                    break;
                case 2:
                    systemFirstDegreeEq();
                    break;
                case 3:
                    secondDegreeEq();
                    break;
                default:
                    System.out.println("Wrong input option!");
                    break;
            }
            String c;
            System.out.print("Continue?(yes/no): ");
            c = sc.next();
            if (Objects.equals(c, "no")) check = false;
        } while (check);
    }

    public static void printMenu() {
        System.out.println("\n\nEquation solving program");
        System.out.println("1. First-degree equation ");
        System.out.println("2. System of first-degree equations");
        System.out.println("3. Second-degree equation \n");
    }

    private static void firstDegreeEq() {
        double a, b;
        Scanner sc = new Scanner(System.in);
        System.out.println("The equation has the form: ax+b=0");
        System.out.print("Enter a: ");
        a = sc.nextDouble();
        System.out.print("Enter b: ");
        b = sc.nextDouble();
        if(a!=0) System.out.println("The solution for the equation " + a + "x+" + b + "=0 is: " + (b / a));
        else if(b==0) System.out.println("The equation has infinite solution!");
        else System.out.println("The eqution has no solution!");
    }

    private static void systemFirstDegreeEq() {
        double[] a = new double[3];
        double[] b = new double[3];
        Scanner sc = new Scanner(System.in);
        System.out.println("The equation has the form:\n a1*x+a2*y=a3\n b1*x+b2*y=b3");
        System.out.print("Enter a1, a2, a3: ");
        for (int i = 0; i < 3; i++) {
            a[i] = sc.nextDouble();
        }
        System.out.print("Enter b1, b2, b3: ");
        for (int i = 0; i < 3; i++) {
            b[i] = sc.nextDouble();
        }
        double D = Math.abs(a[0] * b[1] - a[1] * b[0]);
        double Dx = Math.abs(a[2]*b[1]-b[2]*a[1]);
        double Dy = Math.abs(a[0]*b[2]-b[0]*a[2]);
        if(D==0){
            System.out.println("The equation has infinite solution!");
        } else{
            System.out.println("The solution for the equation is:\n x = "+(Dx/D)+"\n y = "+(Dy/D));
        }

    }

    private static void secondDegreeEq() {
        double a, b, c;
        Scanner sc = new Scanner(System.in);
        System.out.println("The equation has the form: ax^2+bx+c=0");
        System.out.print("Enter a: ");
        a = sc.nextDouble();
        System.out.print("Enter b: ");
        b = sc.nextDouble();
        System.out.print("Enter c: ");
        c = sc.nextDouble();
        double delta = b * b - 4 * a * c;
        if (delta > 0)
            System.out.println("The equation has 2 solutions:\n x1 = " + ((-b + Math.sqrt(delta)) / (2 * a)) + " x2 = " + ((-b - Math.sqrt(delta)) / (2 * a)));
        else if (delta == 0) System.out.println("The equation has 1 solution: x = " + ((-b) / (2 * a)));
        else System.out.println("The equation has no solution!");
    }
}
