import java.util.*;

public class MinPathSum{

    public static int minPathSum(ArrayList<ArrayList<Integer>> A){
        if(A == null || A.size() == 0){
            return 0;
        }
        int[][] cache = new int[A.size()][A.get(0).size()];
        for(int i=0; i<A.size(); i++){
            for(int j=0; j<A.get(0).size(); j++){
                cache[i][j] = -1;
            }
        }

        return minPath(A, A.size()-1, A.get(0).size()-1, cache);
    }

    private static int minPath(ArrayList<ArrayList<Integer>> A, int r, int c, int[][] cache){
        if(r == 0 && c == 0){
            return A.get(r).get(c);
        }else if(r < 0 || c < 0){
            return Integer.MAX_VALUE;
        }else if(cache[r][c] != -1){
            return cache[r][c];
        }
        
        return cache[r][c] = Math.min(minPath(A, r-1,c, cache) , minPath(A, r, c-1, cache)) + A.get(r).get(c);
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        ArrayList<Integer> al1 = new ArrayList<>();
        al1.add(1);al1.add(3);al1.add(2);
        al.add(al1);
        ArrayList<Integer> al2 = new ArrayList<>();
        al2.add(4); al2.add(3); al2.add(1);
        al.add(al2);
        ArrayList<Integer> al3 = new ArrayList<>();
        al3.add(5); al3.add(6); al3.add(1);
        al.add(al3);

        System.out.print("The min Path sum is : " + MinPathSum.minPathSum(al));
    }
}