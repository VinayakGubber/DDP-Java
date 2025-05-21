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

    /* <------------------------Basic Maths------------------------> */

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

    // Amstrong
    public void amstrong() {
        // Amstrong (Adding the power(power is equal to the count of digits) of the
        // digits of the number should be equal to the
        // number itself)

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

    // Divisors of n
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

    // Check prime or not
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

    // GCD of a given number
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

    /* <------------------------Recursion------------------------> */

    // Print name n times
    public void pName(int i, int n) {
        if (i > n)
            return;
        System.out.println("Vinayak");

        pName(i + 1, n);
        /*
         * The code below doesnt work as the above although it might look like it works
         * Because when the function is called recursively the i is reinitialised to 1
         * and this basically runs till the function stack is full and then terminates
         * 
         * ----public void pName(int n) {
         * int i = 1;
         * if (i > n)
         * return;
         * System.out.println("Vinayak");
         * i++;
         * pName(n);
         * }----
         * 
         */
    }

    // Print number From i - To n || From n - To i BiDirectional
    public void pNumber(int from, int to) {

        System.out.println(from);

        if (from < to) {
            pNumber(from + 1, to);
        } else if (to < from) {
            pNumber(from - 1, to);
        }
    }

    // Print sum of n numbers
    public void pSumOfNum(int i, int n, int sum) {
        /*
         * Note while using recursion any updates in the values over the iterations
         * should be done inside the function call parameter ex:
         * pSumOfNum(i+1,5,sum+i) other wise if we try to update inside the function
         * block it will re initialize the parameters passes while calling the function
         * and lead to infinite recursion
         * Self-note - Beleive it or not it took me 30 minutes to figure out how to
         * print the sum
         * Challenge: I was initializing `sum = 0` inside the
         * function each time,
         * which made me think the recursive function wasn't accumulating correctly.
         * Fix: Pass `sum` as a parameter and accumulate it through the recursive calls.
         * Also, be careful with where you place `System.out.println()` – printing
         * inside the stack
         * instead of after recursion can lead to multiple partial prints.
         */
        if (i > n) {
            /*
             * This plays a crucial role in terminating the function once the condidtion is
             * satisfied and also in printing the cumulative sum before the program
             * execution is terminated.
             */
            System.out.println(sum);
            return;
        }
        pSumOfNum(i + 1, n, sum + i);
    }

    /*---endl---*/

    /*---endl---*/
}

public class basicMaths {
    public static void main(String args[]) {

        Concepts operation = new Concepts();
        // HelperFunctions helper = new HelperFunctions();

        // operation.revNum();
        // operation.palindrome();
        // operation.amstrong();
        // operation.count();
        // helper.count(25);
        // helper.power(2, 3);
        // operation.divisors();
        // operation.prime();
        // operation.gcd();
        // operation.pName(1, 5);
        // operation.pName(1, 5);
        // operation.pNumber(8, 2);
        // operation.pSumOfNum(1, 5, 0);
        operation.pSumOfNum(1, 5, 0);
    }
}