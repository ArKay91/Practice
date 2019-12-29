import java.util.*;

public class LISD {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static int longestSubsequenceLength(final List<Integer> A) {
        if (A.isEmpty()) {
           return 0;
       }

        if (A.size() == 1) {
            return 1;
        }
        // Finding indexed max increasing subsequence results for normal array and its reverse. 
        int[] lis = lisArray(A);
        int[] lds = ldsArray(A);

        int max = 0;

        int sum;

        for (int i = 0; i < A.size(); i++) {
            // Removing one element because there will be one overlap element from both sets.
            sum = lis[i] + lds[A.size() - i - 1] - 1;
            max = max > sum ? max : sum;
        }
        return max;
    }
    
     public static int binarySearch(int[] searchArray, int low, int high, int x) {
        while (low < high) {
            int mid = (low+high)/2;
            if (x < searchArray[mid]) {
                high = mid;
            } else if (x > searchArray[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
    
    public static int[] lisArray(List<Integer> input) {
        int[] searchArray = new int[input.size()];
        searchArray[0] = input.get(0);
        int length = 0;

        int[] lis = new int[input.size()];
        lis[0] = 1;

        for (int i = 1; i < input.size(); i++) {
            int x = input.get(i);
            if (x <= searchArray[length]) {
                int index = binarySearch(searchArray, 0, length, x);
                searchArray[index] = x;
                lis[i] = index + 1;
            } else {
                searchArray[++length] = x;
                lis[i] = length + 1;
            }
        }
        return lis;
    }
    
    public static int[] ldsArray(List<Integer> input) {
        ArrayList<Integer> reverse = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            reverse.add(input.get(input.size() - i - 1));
        }
        return lisArray(reverse);
    }

    public static void main(String[] args){
        List<Integer> nums = new ArrayList<Integer>(); 
        nums.add(-1);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(2);
        nums.add(6);
        nums.add(2);
        nums.add(5);
        System.out.print("LIS of nums :-"+ LISD.longestSubsequenceLength(nums));
    }
}