package tree;

public class GreaterSumTree {
    static int sum =0;
    public static void greaterTree(Node root){
        if(root == null)
            return;
       greaterTree(root.right);
        int temp = root.data;
       root.data = sum;
        sum += temp;
        greaterTree(root.left);
           }

    public static void inorder(Node root){
        if(root == null)
            return;
        inorder(root.left);
        System.out.println(" ,"+root.data);
        inorder(root.right);
    }


    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.right.left = new Node(12);
        root.right.right = new Node(20	);


        inorder(root);
        System.out.println("");
        greaterTree(root);
        System.out.print("Greater Sum Tree: ");
        inorder(root);
    }
}
