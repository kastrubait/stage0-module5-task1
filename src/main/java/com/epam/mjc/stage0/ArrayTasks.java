package com.epam.mjc.stage0;

/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        String[] seasons = new String[] {"winter", "spring", "summer", "autumn"};
        return seasons;
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int[] numbersTemp = new int[length + 1];
        for(int i = 0; i < length + 1; i++){
            numbersTemp[i] = i;
        }
        int[] numbers = new int[length];
        System.arraycopy(numbersTemp, 1, numbers, 0, length );
        return numbers;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        String[] reverse = new String[arr.length];
        int j = 0;
        for (int i = arr.length -1; i >= 0 ; i--) {
            reverse[j] = arr[i];
            j++;
        }
        return reverse;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int[] temp = new int[arr.length];
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                j++;
                temp[j] = arr[i];
            }
        }
        int[] positiveNumber = new int[j + 1];
        System.arraycopy(temp, 0, positiveNumber, 0, j + 1 );
        return positiveNumber;
    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public int[][] sortRaggedArray(int[][] arr) {
        int pos;
        int[] temp;
        for (int i = 0; i < arr.length; i++) {
            int posArr;
            int tempArr;
            for (int a = 0; a < arr[i].length; a++)
            {
                posArr = a;
                for (int b = a+1; b < arr[i].length; b++)
                {
                    if (arr[i][b] < arr[i][posArr])                  //find the index of the minimum element
                    {
                        posArr = b;
                    }
                }

                tempArr = arr[i][posArr];            //swap the current element with the minimum element
                arr[i][posArr] = arr[i][a];
                arr[i][a] = tempArr;
            }
        }
        for (int i = 0; i < arr.length; i++) {

            pos = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[j].length < arr[pos].length)
                {
                    pos = j;
                }
            }
            temp = arr[pos];
            arr[pos] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

}
