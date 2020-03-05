public class InOrderSuccessor{

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }

    public TreeNode inOderSuccessor(TreeNode root, TreeNode p){

        // InOrder traversal follows left -> root -> right
        // If we find a right occurs after P then we can expect the successor could be somewhere on right left.
        if(p.right != null){
            p = p.right;
            while(p.left != null) p = p.left;
            return p;
        }
        // Now that we know successor is not from right side of P
        // Traversing through BST until point P and we expect successor to be present somewhere on its parent
        // So we use stack to tract parents.
        // Once we reach P we pop up values from stack until we find a greater value than P
        // Which in case with P existing on root right left => root right (head of left) will be successor
        // In case of P on root right right => since we dont have right then null.
        // If P on root left right || root left left (with no rights) => then successor exist on parent or parents parent 
        // --which we can find from stack pop
        
        Stack<TreeNode> stack = new Stack<>();
        while(root != null && root.val != p.val){
            System.out.println(root.val);
            stack.push(root);
            if(root.val > p.val){
                root = root.left;
            }else if(root.val < p.val){
                root = root.right;
            }
        }
        while(!stack.isEmpty() && stack.peek().val < p.val){
            stack.pop();
        }
        return stack.isEmpty() ? null : stack.pop();        
    }

    public static void main(String[] args){
        // Tested on leetcode.
    }
}