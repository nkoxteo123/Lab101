import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
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
        BubbleSort newArray = new BubbleSort(Integer.parseInt(nums));
        System.out.println("Unsorted array " + newArray.toStringArray());
        newArray.bubblesort();
        System.out.println("Sorted array: " + newArray.toStringArray());

    }
}
