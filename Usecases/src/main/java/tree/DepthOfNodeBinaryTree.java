package tree;

public class DepthOfNodeBinaryTree {
    public static void main(String[] args) {
        BNode root = getTree();
        int key = 55;
        int depth = findDepthOfNode(root, key, 0);
        System.out.println(depth);
    }

    private static int findDepthOfNode(BNode root, int key, int depth) {
        if (root == null) {
            return 0;
        }
        if (root.info == key) {
            return depth;
        }
        int depth1 = findDepthOfNode(root.left, key, depth + 1);
        int depth2 = findDepthOfNode(root.right, key, depth + 1);
        if (depth1 == 0)
            return depth2;
        else
            return depth1;
    }

    private static BNode getTree() {

        BNode root = new BNode(1);
        root.left = new BNode(2);
        root.left.left = new BNode(3);
        root.left.left.left = new BNode(4);
        root.left.left.left.left = new BNode(5);
        root.left.left.left.left.left = new BNode(6);
        root.left.left.left.left.left.left = new BNode(7);
        root.left.left.left.left.left.left.left = new BNode(8);
        root.left.left.left.left.left.left.left.left = new BNode(9);
        root.left.left.left.left.left.left.left.left.left = new BNode(10);

        root.left.left.left.right = new BNode(11);
        root.left.left.left.right.right = new BNode(12);
        root.left.left.left.right.right.right = new BNode(13);
        root.left.left.left.right.right.right.right = new BNode(14);
        root.left.left.left.right.right.right.right.right = new BNode(15);

        return root;
    }
}
class BNode {
    int info;
    BNode left;
    BNode right;
    BNode (int _info){
        this.info = _info;
        left = null;
        right = null;
    }

}

