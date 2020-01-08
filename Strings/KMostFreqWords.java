import java.util.*;

public class KMostFreqWords{

    public List<String> topKFreqWords(String[] words, int k){
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> map.get(a).equals(map.get(b)) ? a.compareTo(b)  : map.get(b) - map.get(a));
        for(String s : map.keySet()){
            minHeap.add(s);
        }

        List<String> ret = new ArrayList<>(); 
        int i = 0;
        while(i != k){
            ret.add(minHeap.remove());
            i++;
        }

        return ret;
    }
    public static void main(String[] args){
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        KMostFreqWords kmfw = new KMostFreqWords();
        System.out.println("K most frequent words : " + kmfw.topKFreqWords(words, 2).toString());
    }
}