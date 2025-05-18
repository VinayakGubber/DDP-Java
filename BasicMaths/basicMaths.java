import java.util.Scanner;

class HelperFunctions {
    public static Scanner sc = new Scanner(System.in);

    // Power of a Number
    public int power(int base, int power) {
        int res = 1;
        for (int i = 1; i <= power; i++) {
            res = res * base;
        }
        return res;
    }

    // Count of numbers
    public int count(int n) {
        int count = 0;
        while (n > 0) {
            n = n / 10;
            count++;
        }
        return count;
    }
}

class Concepts extends HelperFunctions {
    public static Scanner sc = new Scanner(System.in);

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
        int orgNum = n;
        int sum = 0;
        int count = count(orgNum);
        while (n > 0) {
            int ld = n % 10;
            sum += power(ld, count);
            n = n / 10;

        }
        String result = sum == orgNum ? " Is a Amstrong Number " : " Is not a Amstrong Number ";
        System.out.println(result);
    }

    public void divisors() {

        System.out.println("Enter the number : ");
        int n = sc.nextInt();
        System.out.println();

        System.out.println("The divisors are :-");
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i + " ");
                if (n / i != i) {
                    System.out.println(n / i + " ");
                }
            }
        }
    }
}

public class basicMaths {
    public static void main(String args[]) {
        Concepts operation = new Concepts();
        HelperFunctions helper = new HelperFunctions();
        // operation.revNum();
        // operation.palindrome();
        // operation.amstrong();
        // operation.count();
        // helper.count(25);
        // helper.power(2, 3);
        operation.divisors();

    }
}