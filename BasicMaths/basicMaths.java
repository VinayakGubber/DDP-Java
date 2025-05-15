import java.util.Scanner;

public static Scanner sc = new Scanner(System.in);

class HelperFunctions {

    // Power of a Number
    public int power(int base, int power) {
        int res = 1;
        for (int i = 1; i <= power; i++) {
            res = res * base;
        }
        return res;
    }

    // Count of numbers
    public int count() {
        System.out.println("Enter the number : ");
        int n = sc.nextInt();
        int count = 0;
        while (n > 0) {
            n = n / 10;
            count++;
        }
        System.out.println(count);
        return count;
    }
}

class Concepts extends HelperFunctions {

    // Reversing a number
    public void revNum() {
        System.out.println("Enter the number : ");
        int n = sc.nextInt();
        int revNum = 0;
        while (n > 0) {
            revNum = (revNum * 10) + n % 10;
            n = n / 10;
        }
        System.out.println(revNum);
    }

    // Palindrome(Reverse is same or not)
    public void palindrome() {
        System.out.println("Enter the number : ");
        int n = sc.nextInt();
        int orgNum = n;
        int revNum = 0;
        while (n > 0) {
            revNum = (revNum * 10) + n % 10;
            n = n / 10;
        }
        if (orgNum == revNum) {
            System.out.println("Yes it is palindrome!");
        } else {
            System.out.println("Its not a palindrome!");
        }
    }

    // Amstrong (Adding the power(power is equal to the count of digits) of the
    // digits of the number should be equal to the
    // number itself)
    public void amstrong() {

        System.out.println("Enter the number : ");
        int n = sc.nextInt();
        int powerNum = 0;
        int sum = 0;
        while (n > 0) {
            int ld = n % 10;
            for (int i = 0; i <= count(); i++) {

            }
            n = n / 10;

        }
        if (orgNum == sum) {
            System.out.println("Yes it is Amstrong number");
        } else {
            System.out.println("Its not a Amstrong number");
        }
    }

}

public class basicMaths {
    public static void main(String args[]) {
        Concepts operation = new Concepts();
        // operation.revNum();
        // operation.palindrome();
        operation.amstrong();
        // operation.count();

    }
}