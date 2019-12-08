import java.util.*;
// Number of Islands

public class Region{
    
    // Finding size of Island using DFS
    public int getSizeofIslandDFS(ArrayList<ArrayList<Integer>> map, int row, int col){

        if(row < 0 || row >= map.size() || col < 0 || col >= map.get(row).size()){
            return 0;
        }
        if(map.get(row).get(col) == 0){
            return 0;
        }

        int size = 1;
        
        //Set this Island place to be measured and visited.
        map.get(row).set(col, 0);

        // Places neighbour to the current, including diagonal located places.
        for(int r = row-1; r <= row+1; r++){
            for(int c = col-1; c <= col+1; c++){
                if(r != row || c != col){   // Makign sure current place is not visited again
                    size += getSizeofIslandDFS(map, r, c); 
                }
            }
        }

        return size;
    }

    public int numberOfIslands(ArrayList<ArrayList<Integer>> map){
        //Intialize
        int maxSize = 0;

        //Loop through map to find where islands exists
        for(int r=0; r < map.size(); r++){
            for(int c=0; c < map.get(r).size(); c++){
                if(map.get(r).get(c) == 1){
                    // If found DFS to find its size
                    int size = getSizeofIslandDFS(map, r, c);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        return maxSize;
    }

    public static void main(String[] args ){
        Region region = new Region();

        ArrayList<ArrayList<Integer>> map = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);al.add(0);al.add(1);al.add(0);al.add(1);
        map.add(al);
        ArrayList<Integer> al1 = new ArrayList<>();
        al1.add(1);al1.add(0);al1.add(0);al1.add(0);al1.add(1);
        map.add(al);
        ArrayList<Integer> al2 = new ArrayList<>();
        al2.add(1);al2.add(0);al2.add(0);al2.add(0);al2.add(0);
        map.add(al2);
        ArrayList<Integer> al3 = new ArrayList<>();
        al3.add(0);al3.add(0);al3.add(0);al3.add(0);al3.add(1);
        map.add(al3);
        ArrayList<Integer> al4 = new ArrayList<>();
        al4.add(0);al4.add(0);al4.add(0);al4.add(1);al4.add(1);
        map.add(al4);
        int size = region.numberOfIslands(map);


        System.out.print("Maximum size of an individual Island : " + size);
    }
}