import java.util.*;

public class CombinationSum{
    
    List<List<Integer>> result; 
    public List<List<Integer>> combinationSumI(int[] candidates, int target){
        result = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        combinationSumHelper(candidates, temp, target, 0);

        return result;
    }

    private void combinationSumHelper(int[] candidates, List<Integer> temp, int target, int start){
        if(target < 0){
            return;
        }
        if(target == 0){
            if(!result.contains(temp)){
                result.add(new ArrayList<>(temp));
            }
        }

        for(int i = start; i<candidates.length; i++){
            // We try to add same indexed number and check if the target is reached.
            // Once target is out of bound we try with other combinations from the specific i index
            temp.add(candidates[i]);
            combinationSumHelper(candidates, temp, target-candidates[i], i);
            temp.remove(temp.size()-1);
        }
    }


    public static void main(String[] args){
        // Duplicates are not allowed but same number can be repeated
        CombinationSum cs = new CombinationSum();
        List<List<Integer>> res = cs.combinationSumI(new int[] {2, 3, 6, 7}, 7);

        for(List<Integer> r : res){
            for(int a : r){
                System.out.print(a + " ");
            }
            System.out.println("");
        }
    }
}