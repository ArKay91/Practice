import java.util.*;
import java.util.LinkedList;

public class MergeIntervals{

    // Custom comaprator for 2-d arrays.
    private class IntervalComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] a, int[] b){
            return a[1]-b[1] > 0 ? 1 : a[1]-b[1] < 0 ? -1 : 0;
        } 
    }

    public int[][] merge(int[][] intervals){
        Arrays.sort(intervals, new IntervalComparator());
        LinkedList<int[]> mergedList = new LinkedList<>();
        for(int[] interval : intervals){
            // If previous interval end less than current interval then its a new interval
            if(mergedList.isEmpty() || mergedList.getLast()[1] < interval[0]){
                mergedList.add(interval);
            }else{
                // Situation exist when previous meeting is longer than next meeting or other way around then:- 
                mergedList.getLast()[1] = Math.max(mergedList.getLast()[1], interval[1]);
            }
        }

        return mergedList.toArray(new int[mergedList.size()][]);
    }

    public static void main(String[] args){
        MergeIntervals merge = new MergeIntervals();
        int[][] result = merge.merge(new int[][] { {1, 3}, {2, 6}, {8, 10}, {15, 18}});

        for(int[] res : result){
            System.out.println(" " + res[0] + " " + res[1]);
        }
    }
}