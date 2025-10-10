package lab2;
import java.util.Scanner;

class OddException extends Exception {
    public OddException(String message) {
        super(message);
    }
}

public class Main {
    static void Odd(int num) throws OddException {
        if (num % 2 == 0) {
            throw new OddException("Error! Even number entered: " + num);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int count = 0;

        System.out.println("Enter 10 odd numbers:");

        while (count < 10) {
            try {
                System.out.print("Number #" + (count + 1) + ": ");
                int num = sc.nextInt();
                Odd(num); 
                arr[count] = num;
                count++;
            } catch (OddException e) {
                System.out.println(e.getMessage() + ". Please try again.");
            } catch (Exception e) {
                System.out.println("Input error! Please try again.");
                sc.next(); 
            }
        }

        sc.close();
        System.out.println("Entered numbers:");
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
