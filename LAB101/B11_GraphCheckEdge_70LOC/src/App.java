import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String numberVertexString;

        while (true) {
            System.out.println("Enter the number of nodes on the graph:");
            numberVertexString = input.nextLine();

            if(numberVertexString.matches("\\d+")) {
                if(Integer.parseInt(numberVertexString) > 0) {
                    System.out.println();
                    System.out.println("Enter the edge matrix:");
                    break;
                }
            } else {
                System.out.println("Vui long nhap so nguyen duong");
            }

        }
        int numberofnodes = Integer.parseInt(numberVertexString);
        System.out.println();
        Graph gr = new Graph(numberofnodes);
        gr.addEdge();

        System.out.println();

        int src;
        int destination;
        System.out.println("Enter the start point:");
        src = input.nextInt();
        System.out.println();
        System.out.println("Enter the end point:");
        destination = input.nextInt();
        System.out.println();
        if(gr.checkEdge(src-1, destination-1)==true){
            System.out.println("This is an edge.");
        } else {
            System.out.println("This is not an edge.");
        }

    }
}
