import java.util.*;

public class SingleNumber {
    
    public int singleNumberIs(int[] nums){
        int singleNumber = 0;
        //int num = 0;
        //int sumTotal = 0;
        // Set<Integer> set = new HashSet<>();
        // for(int i=0; i<nums.length; i++){
        //     set.add(nums[i]);
        //     sumTotal += nums[i];
        // }
        
        // int indTotal = 0;
        // for(int n : set){
        //     indTotal += n;
        // }

        // return 2 * indTotal - sumTotal;
        for(int num : nums){
            singleNumber ^= num;
        }

        return singleNumber;
    }

    public static void main(String[] args){

    }
}