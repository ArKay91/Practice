import java.util.*;

public class FrequencySort{

    public static String sortStringbyFrequency(String s){
        // Have HashMap for character count 
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Build PQ based on the lambda comdition resutlting a max heap 
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());
        
        // Build string from PQ
        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()){
            char curr = maxHeap.remove();
            for(int i=0; i<map.get(curr); i++){
                sb.append(curr);
            }
        }
        return sb.toString();
    } 
    public static void main(String[] args){
        String s = "abacba"; //Output : aaabbc
        System.out.println("After sorting characters by frequency : " + FrequencySort.sortStringbyFrequency(s));
    }
}