import java.util.*;

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
        // In this we have made use of the collection framework in java to store sort
        // and then print the divisors
        // The interfaces we use form the java collection framework are present in the
        // java.util.*; package

        System.out.println("Enter the number : ");
        int n = sc.nextInt();
        System.out.println();
        ArrayList<Integer> al = new ArrayList<>();
        System.out.println("The divisors are :-");
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                al.add(i);
                if (n / i != i) {
                    al.add(n / i);
                }
            }
        }
        al.sort(null);
        System.out.println(al);
    }

    public void prime() {
        // Prime or not OPTIMIZED O(sqrt(n))
        System.out.println("Enter the number : ");
        int n = sc.nextInt();
        System.out.println();
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (n / i != i) {
                    count++;
                }
            }
        }
        if (count == 2) {
            System.out.println("Yes a prime number");
        } else {
            System.out.println("No not a prime number");
        }
    }

    public void gcd() {
        System.out.println("Enter the number a : ");
        int a = sc.nextInt();
        System.out.println();
        System.out.println("Enter the number b : ");
        int b = sc.nextInt();
        System.out.println();
        while (a > 0 && b > 0) {
            if (a > b && b != 0) {
                a = a % b;
            }
            if (b > a && a != 0) {
                b = b % a;
            }
        }
        if (a == 0) {
            System.out.println("Gcd is : " + b);
        } else if (b == 0) {
            System.out.println("Gcd is : " + a);
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
        // operation.divisors();
        // operation.prime();
        operation.gcd();

    }
}