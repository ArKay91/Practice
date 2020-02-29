import java.util.*;

public class CombinationSum2 {

    List<List<Integer>> result;
    public List<List<Integer>> combinationSumII(int[] candidates, int target){
        result = new ArrayList<>();
        if(candidates == null){
            return result;
        }
        // Sorting helps in finding already formed list.
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        combinationSum2Helper(candidates, temp, target, 0);
        
        return result;
    }

    private void combinationSum2Helper(int[] candidates, List<Integer> temp, int target, int start){
        if(target < 0){
            return;
        }
        if(target == 0){
            if(!result.contains(temp)){
                result.add(new ArrayList<>(temp));
            }
        }
        // Each index contains values of its own from candidates or next candidates.
        for(int i=start; i<candidates.length; i++){
            temp.add(candidates[i]);
            
            combinationSum2Helper(candidates, temp, target-candidates[i], i+1);
            
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args){
        // Number can only be used only once
        // Duplicate combinations are not allowed
        CombinationSum2 cs2 = new CombinationSum2();
        List<List<Integer>> result = cs2.combinationSumII(new int[] {10,1,2,7,6,1,5}, 8);
        //System.out.println(result.size() + " count");
        for(List<Integer> res : result){
            //System.out.println(res.size() + " count");
            for(int a : res){
                System.out.print(a+ " ");
            }
            System.out.println("");
        }
    }
}