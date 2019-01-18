public class BinarySearchTree {

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public static Node root;

    public void insert(int value) {
        Node node = new Node(value);

        if (root == null) {
            root = node;
            return;
        }

        insertRec(root, node);

    }

    private void insertRec(Node latestRoot, Node node) {

        if (latestRoot.value > node.value) {

            if (latestRoot.left == null) {
                latestRoot.left = node;
                return;
            } else {
                insertRec(latestRoot.left, node);
            }
        } else {
            if (latestRoot.right == null) {
                latestRoot.right = node;
                return;
            } else {
                insertRec(latestRoot.right, node);
            }
        }
    }

    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

    }

    public static void pntArr(Node root) {
        if (root != null) {
            pntArr(root.left);
            //Visit the node by Printing the node data
            System.out.printf("%d ", root.value);
            pntArr(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree node = new BinarySearchTree(null);
        int[] intArr = {50, 32, 13, 65, 34, 22, 3, 76, 90};
        for (int i = 0; i < intArr.length - 1; i++)        {
            node.insert(intArr[i]);
        }
        pntArr(root);
    }
}