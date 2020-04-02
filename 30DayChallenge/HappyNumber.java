import java.util.*;

public class HappyNumber{
    public boolean isHappy(int n){
        Set<Integer> set = new HashSet<>();

        // there will be a loop if the sum doesn't end with 1.
        while(!set.contains(n)){
            set.add(n);
            n = cumulativeSum(n);
            if(n == 1){
                return true;
            }
        }

        return false;
    }

    private int cumulativeSum(int n){
        int sum = 0;
        while(n != 0){
            sum += n%10 * n%10;
            n = n/10;
        }
        return sum;
    }

    public static void main(String[] args){
        HappyNumber hn = new HappyNumber();
        Random random = new Random();
        for(int i=0; i<10; i++){
            int temp = random.nextInt(Integer.MAX_VALUE);
            if(hn.isHappy(temp)){
                System.out.println(temp + " is a happy number.. Happy Happy");
            }
        }
    }
}