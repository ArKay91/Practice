// TODO : Under working.
import java.util.*;

public class KnightSolution{

    //Movement representations. Total 8 ways
    private static int[] xSet = {1, 1, -1, -1, 2, 2, -2, -2};
    private static int[] ySet = {2, -2, -2, 2, 1, -1, -1, 1};

    public class Point{
        int x;
        int y;
        int dist;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        Point(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    

    private int minNumberOfStepsBFS(Point start, Point dest, int boardSizeWidth, int boardSizeHeight){
        //Set to tarck all visited Nodes
        Set<Point> visited = new HashSet<>();
        //Queue for processing all next possible Points 
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            Point point = queue.poll();

            int x = point.x;
            int y = point.y;
            int dist  = point.dist;
            // Match with destination if found
            if(dest.x == x && dest.y  == y){
                return dist;
            }

            // If visited we dont want to process again.
            if(!visited.contains(point)){
                //Add mark in visited
                visited.add(point);

                // Find all next available points
                for(int i=0; i<8; i++){
                int newX = x + xSet[i];
                int newY = y + ySet[i];

                //If valid point add to queue.
                if(isValidPoint(newX, newY, boardSizeWidth, boardSizeHeight)){
                        queue.add(new Point(newX, newY, dist + 1));
                    }
                }
            }
        }

        return Integer.MAX_VALUE;
    }


    private boolean isValidPoint(int x, int y, int boardSizeWidth, int boardSizeHeight){
        if(x < 0 || x >= boardSizeWidth || y < 0 || y >= boardSizeHeight){
            return false;
        }

        // if(Math.abs(x-y) > 2){
        //     return false;
        // }

        return true;
    }

    public int knight(int A, int B, int C, int D, int E, int F) {
        // Starting Point
        Point src = new Point(C, D, 0);

        // End Point
        Point dest = new Point(E, F, 0);
        
        return minNumberOfStepsBFS(src, dest, A, B);
    }

    public static void main(String[] args){
        KnightSolution ks =new KnightSolution();
        int minSteps = ks.knight(4,4,1,1,4,4);
        System.out.println(minSteps);
    }
}