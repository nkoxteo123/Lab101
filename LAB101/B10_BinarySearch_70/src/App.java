import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String keys;
        String nums;
        while(true) {
            System.out.println("Enter number of array: ");
            nums = input.nextLine();
            if(nums.matches("\\d+")) {
                if(Integer.parseInt(nums) > 0) {
                    break;
                }
            } else {
                System.out.println("Vui long nhap so nguyen duong");
            }
        }
        MergeSort newArray = new MergeSort(Integer.parseInt(nums));

        while (true) {
            System.out.println("Enter search value:");
            keys = input.nextLine();
            if(keys.matches("\\d+")) {
                if(Integer.parseInt(keys) > 0) {
                    break;
                }
            } else {
                System.out.println("Vui long nhap so nguyen duong");
            }
        }
        int key = Integer.parseInt(keys);
        
        newArray.startMergeSort();
        System.out.println("Sorted array: " + newArray.toStringArray());
        BinarySearch ob = new BinarySearch();
        int result = ob.binarySearch(newArray.array, 0, newArray.array.length-1, key);
        if(result == -1) {
            System.out.println("No value in array");
        } else {
            System.out.println("Found " + key + " at index " + result);
        }
    }
}
