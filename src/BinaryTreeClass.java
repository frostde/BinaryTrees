/*This class is called BinaryTree Class and demonstrates the actual implementation of the Binary Tree class.
* The member variables included are a TreeNode that points to the root of the tree, and an int that indicates the size
* of the tree.  The size variable is private and requires an accessor to view.
* Methods that are included are:
* . A Constructor
* . An accessor for size, getSize()
* . 3 methods for starting the various traversals
* . 3 methods that actually carry out the traversals, recursively
* . An iterative search function that accepts an int parameters, to search for it in the tree and returns void
* . 3 methods that start: delete, insert, and the getHeight accessor
* . A remove function that returns a Node and search the Tree for the parameter int value, and deletes when it finds it ( this is recursive )
* . An insert function that returns a Node and searches the Tree for an appropriate spot to insert in the parameter int values ( this is recursive )
* . A getHeight method that recursively looks to find the size of each tree to the bottom
* . A destroy method that deletes the tree by setting root to null, and letting the tree get garbage collected*/
public class BinaryTreeClass {
    public TreeNode root;
    private int size;

    /*Constructor that takes no arguments, and instantiates the tree by setting size to
    * 0 and the root to null.*/
    public BinaryTreeClass() {
        root = null;
        size = 0;
    }

    /*Simple accessor that is used to see how big the tree is.*/
    public int getSize() {
        return size;
    }

    /*In Order print traversal goes through and prints the values of the tree
    * in the actual numeric order.  This is recursive.  The treeNode passed in represents
    * the root.*/
    private void inOrder(TreeNode r) {
        if (r != null) { //we will only print if the root being passed in exists
            inOrder(r.getLeft()); //and recursively we will check left to print
            System.out.println(r.getData()); //and print the value of root
            inOrder(r.getRight()); //and recursively check right
        }
    }

    /*Pre Order prints the value of the root and recursively looks all the way left, and
    * then all the way right.*/
    private void preOrder(TreeNode r) {
        if (r != null) { /*The logic here is similar to inOrder*/
            System.out.println(r.getData());
            preOrder(r.getLeft());
            preOrder(r.getRight());
        }
    }

    /*Post order searches and prints to the right, the left, and then the root,
    * and does this recursively*/
    private void postOrder(TreeNode r) {
        if (r != null) {
            postOrder(r.getLeft());
            postOrder(r.getRight());
            System.out.println(r.getData());
        }
    }

    /*Start the recursive traversal*/
    public void startInOrder() {
        inOrder(root);
    }

    /*Start the recursive traversal*/
    public void startPreOrder() {
        preOrder(root);
    }

    /*Start the recursive traversal*/
    public void startPostOrder() {
        postOrder(root);
    }


    /*This iterative search takes in the parameter of x, and returns void (since we will
    * be printing whether or not we found the value*/
    public void search(int x) {
        TreeNode t = root;
        while ((t != null) && (x != t.getData())) {
            if (x < t.getData()) {
                t = t.getLeft();
            } else {
                t = t.getRight();
            }
        }
        if (t == null) {
            System.out.println(x + " not found");
        } else {
            System.out.println(x + " found");
        }
    }

    /*Recursively find the height of the tree, meaning how many levels the tree has*/
    public int getHeight(TreeNode node) {
        if (node == null) return 0;
        else {
            int heighLeft = getHeight(node.getLeft()); //recursively searches left and goes all the way to the left, calling the function and calling it on the node
            int heightRight = getHeight(node.getRight()); ////does the same but on the right
            return Math.max(heighLeft, heightRight) + 1; //and return the height of both sides, plus one for the root
        }
    }

    /*Starts the recursive getHeight function*/
    public int startHeight() {
        return getHeight(root);
    }

    /*Recursive insert function that takes a node and an int value as a parameter
    * and returns a Node*/
    private TreeNode insert(TreeNode node, int value) {
        if (node == null) { //if the node is null, we create a new node for this value, and return it
            node = new TreeNode(value);
            return node;
        }
        else if (value < node.getData()) { //if our value is lower than the node being passed in, we will traverse left
            node.setLeft(insert(node.getLeft(), value));
            return node; //and we return the node when we find the spot for it
        } else {
            node.setRight(insert(node.getRight(), value)); //and here we traverse right if the value is greater than the value at node
            return node; //and return it
        }
    }

    /*This starts the insert method by passing in the int we want to submit to the tree*/
    public void startInsert(int x) {
        root = insert(root, x); //and it starts at the root, and starts the recursion
        size++; //and increments the size to show we added something to the tree
    }


    /*This method is a recursive method that takes in a Node and a Value, and
    * returns a node.  It searches the tree for the value, and if it finds it, deletes
    * it, and finds the best way to switch the values*/
    private TreeNode remove(TreeNode node, int value) {
       if (node == null) {
           System.out.println("Error: " + value + " not found.");
           return null; //if we can't find the node, we let the console know
       } else if (node.getData() == value) { //if the node being passed in is the one we want to delete
           if (node.getLeft() == null) { //if there is only one child node, and its to the right
               return node.getRight(); //we return the node on the right
           } else if (node.getRight() == null) { //and if there is only one child and its on the left
               return node.getLeft(); //we return the node on the left
           } else { //and we get here if there are two chid nodes
               TreeNode temp = node.getLeft(); //and we save the left node in a temporary variable
               while (temp.getRight() != null) temp = temp.getRight(); //and keep searching right until we find a null getRight()
               node.setData(temp.getData()); //we set the data of the corresponding node that we're deleting to the value of the one on the left that has no right node
               node.setLeft(remove(node.getLeft(), node.getData())); //and recursively call remove to delete the node
               return node;
           }
       } else { //and we reach here if node isn't null, and the values of node and value aren't  equal
           if (value < node.getData()) { //if the value is less than that of the node being passed in
               node.setLeft(remove(node.getLeft(), value)); //and recursively call a remove on the value and going left
           } else {
               node.setRight(remove(node.getRight(), value)); //same but right
           }
           return node;
       }
    }


    /*This method starts the delete, which starts the recursion*/
    public void startDelete(int x) {
        if ((x == root.getData()) && (root.getLeft() == null)) root = root.getRight();
        root = remove(root, x);
        size--;
    }

    //DESTROY TREE
    public void destroy() {
        root = null;
    }


}

