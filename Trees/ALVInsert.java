public class ALVInsert{
    public class Node{
        Node left;
        Node right;
        int data;
        int height;
        public Node(int data){
            this.data = data;
        }
    }
    public Node insert(Node root, int data){
        if(root == null) return new Node(data);
        if(data <= root.data){
            root.left = insert(root.left, data);
        }else{
            root.right = insert(root.right, data);
        }
        int balance = height(root.left) - height(root.right);
        if(balance > 1){
            if(height(root.left.left) >= height(root.left.right)){
                return rightRotate(root);  // LL
            }else{
                root.left = leftRotate(root.left);   // LR
                return rightRotate(root);
            }
        }
        if(balance < -1){
            if(height(root.right.right) >= height(root.right.left)){
                return leftRotate(root);    // RR
            }else{
                root.right = rightRotate(root.right);
                return leftRotate(root);       // RL
            }
        }
        root.height = 1 + heightMax(root.left, root.right);
        return root;
    }

    private Node rightRotate(Node root){
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        root.height = heightMax(root.left, root.right) + 1;
        newRoot.height = heightMax(newRoot.left, newRoot.right) + 1;
        return newRoot;
    }

    private Node leftRotate(Node root){
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        root.height = heightMax(root.left, root.right) + 1;
        newRoot.height = heightMax(newRoot.left, newRoot.right) + 1;
        return newRoot; 
    }

    private int heightMax(Node left, Node right){
        return Math.max(height(left), height(right));
    }

    private int height(Node root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args){
        
    }
}
