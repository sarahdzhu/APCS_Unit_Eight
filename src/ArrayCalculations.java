public class ArrayCalculations {

    public static int rowSum(int[][] arr, int row) {

        if (row > arr.length || row < 0) {
            return -1;
        }
        int total = 0;
        for (int col = 0; col < arr[row].length; col++) {
            total += arr[row][col];
        }
        return total;
    }


    public static int columnSum(int[][] arr, int col) {
        // create a variable to keep track of the total
        if (col < 3 || col <0) {
            return -1;
        }
        int total = 0;
        for (int row= 0; col < arr.length; row++) {
            total += arr[col][row];
        }
        return total;
    }


        /* check to see if the given col variable is valid. If col is less than 0 or is greater than
        the number of columns (the length of one array) it is not valid. Return -1 if not valid.
         */


        /* if col is valid, create a loop to calculate the sum. hint: elements in a 2D array are found like this:
        arr[row][column]. If you are finding the sum of a col, the [column] number will not change,
        only the [row] part will.
         */

        // return the total


    public static int diagonalSum(int[][] arr, int direction) {

        return 0;

    }



}
