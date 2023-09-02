public class MergeSort {
    int[] array;

    MergeSort(int numberofarray) {
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

    // merge sort
    // merge
    int[] merge(int[] n1, int[] n2) {
        int i = 0, i1 = 0, i2 = 0;
        int n = n1.length + n2.length;
        int[] result = new int[n];

        while (i < n) {
            if (i1 < n1.length && i2 < n2.length) {// ca 2 list n1 va n2 van con phan tu
                if (n1[i1] < n2[i2]) {
                    result[i] = n1[i1];
                    i1++;
                    i++;
                } else {
                    result[i] = n2[i2];
                    i2++;
                    i++;
                }
            } else {// 1 trong 2 list rong
                if (i1 < n1.length) {
                    result[i] = n1[i1];
                    i++;
                    i1++;
                } else {
                    result[i] = n2[i2];
                    i++;
                    i2++;
                }

            }

        }

        return result;
    }

    // merge sort
    public int[] mergeSort(int[] ar, int L, int R) {

        if (L > R)
            return new int[0];

        if (L == R) {
            int[] singleElement = { ar[L] };
            return singleElement;
        }

        int k = (L + R) / 2;
        int[] a1 = mergeSort(ar, L, k);
        int[] a2 = mergeSort(ar, k + 1, R);
        int[] result = merge(a1, a2);
        return result;
    }

    public void startMergeSort() {
        if (array.length > 0) {
            array = mergeSort(array, 0, array.length - 1);
        }
    }
}
