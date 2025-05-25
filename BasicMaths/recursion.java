class basicMaths {

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

}

public class recursion {
    public static void main(String args[]) {
        basicMaths recursion = new basicMaths();

        recursion.pName(1, 5);
        recursion.pName(1, 5);
        recursion.pNumber(8, 2);
        recursion.pSumOfNum(1, 5, 0);
        recursion.pSumOfNum(1, 5, 0);
    }
}
