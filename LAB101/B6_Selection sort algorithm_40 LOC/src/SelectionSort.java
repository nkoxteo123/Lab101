public class SelectionSort {
    int[] array;

    SelectionSort(int numberofarray) {
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
    public void SecSort() {
        if (array.length > 0) {
            int n = array.length;
 
            // One by one move boundary of unsorted subarray
            for (int i = 0; i < n-1; i++)
            {
                // Find the minimum element in unsorted array
                int min_idx = i;
                for (int j = i+1; j < n; j++)
                    if (array[j] < array[min_idx])
                        min_idx = j;
     
                // Swap the found minimum element with the first
                // element
                int temp = array[min_idx];
                array[min_idx] = array[i];
                array[i] = temp;
            }
        }
    }
}

