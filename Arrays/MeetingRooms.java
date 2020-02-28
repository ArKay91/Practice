import java.util.*;

public class MeetingRooms{
    private class IntervalComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] a, int[] b){
            return a[0]-b[0] > 0 ? 1 : a[0]-b[0] < 0 ? -1 : 0;
        }
    }    
    public int minMeetingRooms(int[][] intervals){
        Arrays.sort(intervals, new IntervalComparator());
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1]-y[1]);
        pq.add(intervals[0]);
        for(int i=1; i<intervals.length; i++){
            int[] earlist = pq.remove();
            int[] current = intervals[i];
            // Merge meetings when they dont overlap
            if(current[0] > earlist[1]){
                earlist[1] = current[1];
            }else{ // Add to PQ if overlapping
                pq.add(current);
            }
            pq.add(earlist);
        }
        return pq.size();
    }
    public static void main(String[] args){
        MeetingRooms mt = new MeetingRooms();
        System.out.println(String.format("Min of %d meeting rooms required.", mt.minMeetingRooms(new int[][] { {0, 30}, {5, 10}, {15, 20} })));
    }
}