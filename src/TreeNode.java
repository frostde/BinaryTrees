/*This class is the actual TreeNode class, that has three member variables:
* . int Data which holds the value of the node
* . TreeNode left which is the left child of the Root node
* . TreeNode right which is the right child of the Root node*/
public class TreeNode {
    private int data;
    private TreeNode left, right;

    /*This is the constructor that just takes one arguments (an int x), which sets the value of data to that int
    * and sets the value of left and right nodes to null*/
    public TreeNode(int x) {
        data = x;
        left = null;
        right = null;
    }
    /*These are accessors that return the right or left node, and one for the data*/
    public TreeNode getLeft() { return left; }
    public TreeNode getRight() { return right; }
    public int getData() { return data; }

    /*Setters that set the left and right nodes, and data values*/
    public void setLeft(TreeNode l) { left = l; }
    public void setRight(TreeNode r) { right = r; }
    public void setData(int x) { data = x; }



}
