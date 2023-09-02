public class App {
    public static void BubbleSort(int[] arr) {
        for(int i = 0;i<arr.length;i++) {
            for (int j = i; j<arr.length;j++) {
                if(arr[j] < arr[i]) {
                    int temp = arr[j] ;
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
            for(int z=0;z<arr.length;z++) {
                System.out.print(arr[z] + " ");
            }
            System.out.println();
        }
        
        
    }
    public static void selectionsort(int[] arr) {
            for(int i = arr.length-1; i >0;i-- ){
                int max = 0;
                for(int j = 0 ; j<=i ;j++){
                    if(arr[j] > arr[max]) {
                        max = j;

                    }
                }
                System.out.println(arr[max]);
                
                int temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;


                for(int z=0;z<arr.length;z++) {
                    System.out.print(arr[z] + " ");
                }
                System.out.println();
            }
        }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        int[] arr = {5,4,3,2,1};

        selectionsort(arr);


    }
}
