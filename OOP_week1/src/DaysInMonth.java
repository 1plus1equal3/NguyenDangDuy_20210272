import java.util.Scanner;

//DayInMonth.java

public class DaysInMonth {
    public static void main(String[] args) {
        int month, year;
        Scanner sc = new Scanner(System.in);
        //Get year
        do {
            System.out.print("Enter the year: ");
            year = sc.nextInt();
            if(year <= 0) System.out.println("Year must be greater than 0!");
        } while (year <= 0);
        //Get month
        do {
            System.out.print("Enter the month: ");
            month = sc.nextInt();
            if(month < 1 || month > 12) System.out.println("Month must be greater than 0 and less than 13!");
        } while (month < 1 || month > 12);

        if((month==2) && ((year%4==0) || ((year%100==0)&&(year%400==0))))
            System.out.println("Number of days is 29");
        else if(month==2)
            System.out.println("Number of days is 28");
        else if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12)
            System.out.println("Number of days is 31");
        else
            System.out.println("Number of days is 30");
    }
}
