import java.util.*;

public class BestTime2SellStocks1{
    
    public static int findProfit(ArrayList<Integer> A){
        int max = 0;
        if(A.size() == 0){
           return max; 
        }
        int minStock = A.get(0);
        int[] cache = new int[A.size()];
        cache[0] = 0;
        for(int b=1; b<A.size(); b++){
            // stock price increase wrt min stock
            //if(A.get(b) > A.get(b-1)){
                // Update the profit in the cache
                if(A.get(b)-minStock > cache[b-1]){
                    cache[b] = A.get(b)-minStock;
                    continue;
                }
            //}
            // If we encounter any price down value which is less than the minimum bought stock
            if(A.get(b) < minStock){
                minStock = A.get(b);
            }

            // Carying profits 
            cache[b] = cache[b-1];
        }
        
        return cache[A.size()-1];
    }

    public static void main(String[] args){
        ArrayList<Integer> stocks = new ArrayList<>();
        stocks.add(1); 
        stocks.add(4);
        stocks.add(5);
        stocks.add(2);
        stocks.add(4);
        //stocks.add(1);
        //stocks.add(2);
        System.out.print("Profit can be made :- " + BestTime2SellStocks1.findProfit(stocks));
    }
}