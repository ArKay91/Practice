public class SortColors{

    public void sortColors(int[] nums){
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int num : nums){
            switch(num){
                case 0:
                    count0++;
                    continue;
                case 1:
                    count1++;
                    continue;
                case 2:
                    count2++;
                    continue;
            }
        }
        
        int index = 0;
        while(count0-- != 0){
            nums[index++] = 0;
        }
        while(count1-- != 0){
            nums[index++] = 1;
        }
        while(count2-- != 0){
            nums[index++] = 2;
        }
    }

    public static void main(String[] args){
        SortColors sc = new SortColors();
        int[] nums = new int[] {2, 0, 2, 1, 1, 0}; 
        sc.sortColors(nums);
        for(int n : nums)
            System.out.print(n + " ");
    }
}