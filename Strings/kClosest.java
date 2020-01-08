import java.util.*;

public class kClosest {
    public int[][] kClosest1(int[][] points, int K) {
        PriorityQueue<Point> minHeap = new PriorityQueue<>(points.length, new PointComparator());
        for(int[] point : points){
            minHeap.add(new Point(point[0], point[1]));
        }
        
        int[][] ret = new int[K][2];
        int i = 0;
        while(i != K){
            Point curr = minHeap.remove();
            ret[i][0] = curr.x;
            ret[i][1] = curr.y;
            i++;
        }
        
        return ret;
    }
    
    public class PointComparator implements Comparator<Point>{
        public int compare(Point p1, Point p2){
            if(Math.abs(p1.x)*Math.abs(p1.x)+Math.abs(p1.y)*Math.abs(p1.y) < Math.abs(p2.x)*Math.abs(p2.x)+Math.abs(p2.y)*Math.abs(p2.y)){
                return -1;
            }else if(Math.abs(p1.x)*Math.abs(p1.x)+Math.abs(p1.y)*Math.abs(p1.y) > Math.abs(p2.x)*Math.abs(p2.x)+Math.abs(p2.y)*Math.abs(p2.y)){
                return 1;
            }else {
                return 0;
            }
        }
    } 
    
    private class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args){
        int[][] points = new int[4][2];
        points[0][0] = 1;
        points[0][1] = 2;

        points[1][0] = 2;
        points[1][1] = 3;

        points[2][0] = 3;
        points[2][1] = 4;

        points[3][0] = 4;
        points[3][1] = 5;

        kClosest test = new kClosest();
        System.out.println("2 Closest points to the origin are : " + test.kClosest1(points, 2).toString());
    }
}