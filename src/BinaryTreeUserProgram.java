import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/*Daniel Frost
 * CSC501
 * Data Structures and Computer Systems
 * March, 2017
 *
 * This assignment was developed in order to demonstrate the use of Rad Binary Search Trees, the implementation of the class
 * and the various methods that are associated with it.  In order to test this, we have three different file inputs with various
 * integers.  To carry out the implementation, we will open the file stream of the corresponding file, read the integers into
 * a temporary array, and add the items in the array to the Binary Tree static class.  Using this static class, we will use
 * our insert methods, as well as deleted, searches, and three methods that demonstrate PreOrder, InOrder, and PostOrder
 * traversal.
 *
 * In order to change the file being input, we change the static path variable.  Using two bufferedReaders, one will count the number
 * of inputs in order to create the array of the proper size, and the other will actually read the values into that
 * instantiated array.*/

public class BinaryTreeUserProgram {
    private static FileInputStream in;
    private static String path = "C:\\Users\\Daniel\\IdeaProjects\\FrostProgram4\\src\\input1.txt"; //change file here to change input
    private static BufferedReader readerSize; //two bufferedReaders, where readerSize just reads the amount of items in the file
    private static BufferedReader reader; //this bufferedReader actually reads the ints, much like previous projects
    private static BinaryTreeClass btc = new BinaryTreeClass(); //here is our actual constructor and instantiation

    public static void main(String[] args) {
        try {
            in = new FileInputStream(path); //we create this FileInputStream and pass in the string for the path variable, which get changed to the local machine
            readerSize = new BufferedReader(new InputStreamReader(in));
            String x; int i = 0; int amount = 0; //various variables used for reading in and populating the array
            while (readerSize.readLine() != null) {
                amount++; //amount will be incremented here whenever the readerSize bufferedReader count a new integer
            }
            in = new FileInputStream(path); //and we reinstantiate the FileInputStream and the new bufferedReader so start at the beginning of the file
            reader = new BufferedReader(new InputStreamReader(in));
            int[] tempArray = new int[amount]; //and instantiate the array to the amount we counted in the previous while loop
            while ((x = reader.readLine()) != null) { //here we read until the BufferedReader reads in null
                tempArray[i] = Integer.parseInt(x); //and convert the string read in into an int, and add it to the array
                i++; //and increment the value of i, so that the next value we add to the array is at the next index
            }
            for (int s : tempArray) {
                btc.startInsert(s); //we traverse the array, and for each int, we insert it into the binary tree
            }
            System.out.println("Size:  " + btc.getSize() + "  Height: " + btc.startHeight());
            System.out.println("Pre:");   /*These various methods print out the binary tree in the corresponding order
                                            of traversal.*/
            btc.startPreOrder();
            System.out.println("\n\n");
            System.out.println("In:");
            btc.startInOrder();
            System.out.println("\n\n");
            System.out.println("Post:");
            btc.startPostOrder();
            System.out.println("\n\n");
            for (int s = 0; s != tempArray.length; s++) {
                if ((s % 4 == 0)) { //if the increment is a multiple of four, we will delete it (every fourth item)
                    btc.startDelete(tempArray[s]);
                    System.out.println("Deleting: " + tempArray[s] + "  Size: " + btc.getSize() + "  Height: " + btc.startHeight()); //and print out the new size/height
                }
            }
            for (int g = 0; g < tempArray.length; g++) {
                if ((g % 5) == 0) { //if the increment is a multiple of 5, we search for it in the binary tree
                    btc.search(tempArray[g]);
                }
            }

            System.out.println("Pre:");
            btc.startPreOrder();
            System.out.println("\n\n");
            System.out.println("In:");
            btc.startInOrder();
            System.out.println("\n\n");
            System.out.println("Post:");
            btc.startPostOrder();
            System.out.println("\n\n");
            System.out.println("Size:  " + btc.getSize() + "  Height: " + btc.startHeight());

        } catch (Exception ex) {}

    }
}
