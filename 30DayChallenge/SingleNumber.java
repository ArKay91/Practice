import java.util.*;

public class SingleNumber {
    
    public int singleNumberIs(int[] nums){
        int num = 0;
        int sumTotal = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
            sumTotal += nums[i];
        }
        
        int indTotal = 0;
        for(int n : set){
            indTotal += n;
        }

        return 2 * indTotal - sumTotal;
    }

    public static void main(String[] args){

    }
}