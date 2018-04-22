import java.util.Arrays;

/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 *
 */
public class RadixSort {
    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     *
     * @return String[] the sorted array
     */
    public static String[] sort(String[] asciis) {
        // TODO: Implement LSD Sort

        return null;
    }

    /**
     * LSD helper method that performs a destructive counting sort the array of
     * Strings based off characters at a specific index.
     * @param asciis Input array of Strings
     * @param index The position to sort the Strings on.
     */
    private static void sortHelperLSD(String[] asciis, int index) {
        // Optional LSD helper method for required LSD radix sort
        int[] intValsArray = new int[asciis.length];

        for (int i = 0; i < asciis.length; i++) {
            int charAtCurrentIndex = asciis[i].charAt(index);
            intValsArray[i] = charAtCurrentIndex;
        }

        for (int i = 0; i < intValsArray.length; i++) {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
            for (int j = i; j < intValsArray.length; j++) {
                if (intValsArray[j] < min) {
                    min = intValsArray[j];
                    minIndex = j;
                }
            }
            swap(i, minIndex, intValsArray, asciis);
        }

        return;
    }

    private static void swap(int i, int j, int[] intValsArray, String[] asciis) {
        int temp = intValsArray[i];
        intValsArray[i] = intValsArray[j];
        intValsArray[j] = temp;

        String temp2 = asciis[i];
        asciis[i] = asciis[j];
        asciis[j] = temp2;
    }

    public static void main(String[] args) {
        String[] blah = new String[3];
        blah[0] = "bbb";
        blah[1] = "aaa";
        blah[2] = "ccc";

        sortHelperLSD(blah, 2);
        System.out.println(Arrays.toString(blah));
    }

    //there is a bug in my helper function
    // in the sort function, call it on every index from LSD until index 0

    /**
     * MSD radix sort helper function that recursively calls itself to achieve the sorted array.
     * Destructive method that changes the passed in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start int for where to start sorting in this method (includes String at start)
     * @param end int for where to end sorting in this method (does not include String at end)
     * @param index the index of the character the method is currently sorting on
     *
     **/
    private static void sortHelperMSD(String[] asciis, int start, int end, int index) {
        // Optional MSD helper method for optional MSD radix sort
        return;
    }
}