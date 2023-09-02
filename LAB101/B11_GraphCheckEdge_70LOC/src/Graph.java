import java.util.Scanner;

public class Graph {
    int[][] matrix;
    Graph(int n) {
        matrix = new int[n][n];
    }

    void addEdge() {
        Scanner input = new Scanner(System.in);
        for(int i = 0; i< matrix.length;i++){
            String tempString;
            tempString = input.nextLine();
            String[] tempArrayString  = new String[matrix.length];
            tempArrayString = tempString.split(" ");
            for(int j = 0; j< matrix.length;j++) {
                matrix[i][j] = Integer.parseInt(tempArrayString[j]);
            }
        }
    }
    public void print() {
        if(matrix.length > 0) {
            for (int i =0; i<matrix.length;i++) {
                for(int j = 0; j < matrix.length;j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
    public boolean checkEdge(int src, int destination) {
        if (matrix[src][destination] == 1) {
            return true;
        } else {
            return false;
        }
    }
}
