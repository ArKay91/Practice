import java.util.*;

//Definition for a binary tree node.
// not about how I add into queue
// Its about how I print
// two queues not required.
 
public class ZigZagLevel {
    static List<List<Integer>> list;
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode temp = new TreeNode(-1);
        temp.left = root;
        // root.left = new TreeNode(9);
        // root.right = new TreeNode(20);

        // root = root.right;
        // root.left = new TreeNode(15);
        // root.right = new TreeNode(7);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode temp2 = root.left;
        TreeNode temp3 = root.right;
        temp2.left = new TreeNode(4);
        temp2.right = new TreeNode(6);
        temp3.right = new TreeNode(5);
        temp3.left = new TreeNode(7);

        System.out.println(zigzagLevelOrder(temp.left));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        List<Integer> curr ;
        boolean flip = false;
        
        while(!q.isEmpty()){
            int size = q.size();
            curr = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode cNode = q.remove();
                if(flip){
                  curr.add(0, cNode.val);  
                } else{
                    curr.add(cNode.val);
                }
                if(cNode.left != null){
                    q.add(cNode.left);
                }
                if(cNode.right != null){
                    q.add(cNode.right);
                }    
            }
            if(flip){
                flip = false;
            }else{
                flip = true;
            }
            list.add(curr);
        }
        return list;
    }
}