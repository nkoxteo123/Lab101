public class QuickSort {
    int[] array;

    QuickSort(int numberofarray) {
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

    public void quickSort(int[] arr, int L , int R) {
        if(L>=R) return;
        int key = arr[(L+R)/2];

        int pivot = partition(arr,L,R,key);

        quickSort(arr, L, pivot-1);
        quickSort(arr, pivot, R);
    }

    public int partition(int[] arr,int L,int R, int key) {
        int iL = L;
        int iR = R;
        while(iL<iR) {
            while(arr[iL] < key) iL++;
            while(arr[iR] > key) iR--;

            if(iL <= iR ) {
                int temp = arr[iL];
                arr[iL] = arr[iR];
                arr[iR] = temp;
                iL++;
                iR--;
            }
        }
        return iL;
    }
    public void startQuickSort() {
        if(array.length>0) {
            quickSort(array, 0, array.length-1);
        }
    }
}
