import java.util.Scanner;

class Patterns {

    static final Scanner sc = new Scanner(System.in);

    public static void p1() {
        // * * * * *
        // * * * * *
        // * * * * *
        // * * * * *
        // * * * * *

        System.out.println("Enter n : ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void p2() {
        // *
        // * *
        // * * *
        // * * * *
        // * * * * *
        System.out.println("Enter n : ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void p3() {
//          *
//        * * *
//      * * * * *
//    * * * * * * *
        System.out.println("Enter n : ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n-i ; j++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i*2-1 ; j++) {
                System.out.print("* ");
            }



            System.out.println();
        }

    }
public static void p4() {
//    1
//    1 2
//    1 2 3
//    1 2 3 4
//    1 2 3 4 5
    System.out.println("Enter n : ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= i+1 ; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }

    }
public static void p5() {
//    1
//    2 2
//    3 3 3
//    4 4 4 4
//    5 5 5 5 5
    System.out.println("Enter n : ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i-1 ; j++) {
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }

    public static void p6() {

    System.out.println("Enter n : ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {

//numbers
            for (int j = 1; j <= i ; j++) {
                System.out.print(j+" ");
            }
//spaces
            for (int j = 1; j <= n*2-i*2 ; j++) {
                System.out.print("- ");
            }
//numbers
            for (int j = i; j >= 1 ; j--) {
                System.out.print(j+" ");
            }
            System.out.println();
        }

    }

    public static void p7() {
//        1 2 3 4 5
//        1 2 3 4
//        1 2 3
//        1 2
//        1
        System.out.println("Enter n : ");
        int n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= n-i ; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }

    }

    public static void p8() {
//*
//* *
//* * *
//* * * *
//* * * * *
//* * * *
//* * *
//* *
//*
        System.out.println("Enter n : ");
        int n = sc.nextInt();
        for (int i = 0; i <= 2*n-1; i++) { //2n-1 because we are taking the input for the half pattern in suppose n=5 increase to 5 and then decrease
           int stars = i;
            if (i>n)stars = 2*n-i ;

            for (int j = 1; j <= stars ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    public static void p9() {
//        1
//        0 1
//        1 0 1
//        0 1 0 1
//        1 0 1 0 1
//        0 1 0 1 0 1
        System.out.println("Enter n : ");
        int n = sc.nextInt();
        int start = 1;
        for (int i = 0; i <=n; i++) {
           if (i%2==0) start = 1;
           else start = 0;
           for (int j = 0; j <= i ; j++) {
                System.out.print(start+" ");
                start = 1 - start;
            }
            System.out.println();
        }

    }



}

class Main {
    public static void main(String[] args) {
        Patterns pattern = new Patterns();


        pattern.p6();

    }
}