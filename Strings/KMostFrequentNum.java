import java.util.*;

public class KMostFrequentNum{

    public static List<Integer> kMostFreqNum(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());

        List<Integer> list =  new ArrayList<>();
        int i = 0; 
        while(i != k){
            list.add(maxHeap.remove());
            i++;
        }
        return list;
    }

    public static void main(String[] args){
        int[] num = {1,1,1,2,2,3};
        System.out.println("Find K Most frequent characters " + KMostFrequentNum.kMostFreqNum(num , 2).toString());
    }
}