public class InsertionSort {
    int[] array;

    InsertionSort(int numberofarray) {
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
    public void Insertion() {
        if (array.length > 0) {
            int n = array.length;
            for (int i = 1; i < n; ++i) {
                int key = array[i];
                int j = i - 1;
     
                /* Move elements of array[0..i-1], that are
                   greater than key, to one position ahead
                   of their current position */
                while (j >= 0 && array[j] > key) {
                    array[j + 1] = array[j];
                    j = j - 1;
                }
                array[j + 1] = key;
            }
        }
    }
}

