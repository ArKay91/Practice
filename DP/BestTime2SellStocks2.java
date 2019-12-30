import java.util.*;

public class BestTime2SellStocks2{
    
    public static int findProfit(ArrayList<Integer> A){
        long[] profit = new long[A.size()];
        profit[0] = 0;
        //Looping through the stocks
        for(int b=1; b<A.size();b++){
            // Updating Stock profit every increasing day in sequence 
            while(b < A.size() && A.get(b) >= A.get(b-1)){
                profit[b] = profit[b-1] + (long)(A.get(b) - A.get(b-1));
                b++;
            }
            // Before going to next day transaction update the profit with previous profit.
            if(b < A.size()){
                profit[b] = profit[b-1];
            }
        }
        
        return (int)profit[A.size()-1];
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
        System.out.print("Profit can be made :- " + BestTime2SellStocks2.findProfit(stocks));
    }
}