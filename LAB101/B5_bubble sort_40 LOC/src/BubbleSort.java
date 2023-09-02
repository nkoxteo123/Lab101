
public class BubbleSort {
    int[] array;

    BubbleSort(int numberofarray) {
        array = new int[numberofarray];
        for (int i = 0; i < array.length; i++) {
            int randomNum = (int) (Math.random() * ((99 + 1)));
            array[i] = randomNum;
        }
    }

    // return an string with data is array
    public String toStringArray() {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result = result + array[i] + " ";
        }
        return result;
    }

    // bubblesort
    public void bubblesort() {
        if (array.length > 0) {
            int i, j, temp;
            boolean swapped;
            int n = array.length;
            for (i = 0; i < n - 1; i++) {
                swapped = false;
                for (j = 0; j < n - i - 1; j++) {
                    if (array[j] > array[j + 1]) {

                        // Swap array[j] and array[j+1]
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        swapped = true;
                    }
                }

                // If no two elements were
                // swapped by inner loop, then break
                if (swapped == false)
                    break;
            }
        }
    }
}
