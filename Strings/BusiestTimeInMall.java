// Question:- 
// Busiest Time in The Mall
// The Westfield Mall management is trying to figure out what the busiest moment at the mall was last year. You’re given data extracted from the mall’s door detectors. Each data point is represented as an integer array whose size is 3. The values at indices 0, 1 and 2 are the timestamp, the count of visitors, and whether the visitors entered or exited the mall (0 for exit and 1 for entrance), respectively. Here’s an example of a data point: [ 1440084737, 4, 0 ].

// Note that time is given in a Unix format called Epoch, which is a nonnegative integer holding the number of seconds that have elapsed since 00:00:00 UTC, Thursday, 1 January 1970.

// Given an array, data, of data points, write a function findBusiestPeriod that returns the time at which the mall reached its busiest moment last year. The return value is the timestamp, e.g. 1480640292. Note that if there is more than one period with the same visitor peak, return the earliest one.

// Assume that the array data is sorted in an ascending order by the timestamp. Explain your solution and analyze its time and space complexities.

// Example:

// input:  data = [ [1487799425, 14, 1], 
//                  [1487799425, 4,  0],
//                  [1487799425, 2,  0],
//                  [1487800378, 10, 1],
//                  [1487801478, 18, 0],
//                  [1487801478, 18, 1],
//                  [1487901013, 1,  0],
//                  [1487901211, 7,  1],
//                  [1487901211, 7,  0] ]

// output: 1487800378 # since the increase in the number of people
//                    # in the mall is the highest at that point
// Constraints:

// [time limit] 5000ms

// [input] array.array.integer data

// 1 ≤ data.length ≤ 100
// [output] integer




import java.io.*;
import java.util.*;

public class BusiestTimeInMall {
	
  static int findBusiestPeriod(int[][] data) {
    // your code goes here
    int timeStamp = 0;
    int maxFlow = Integer.MIN_VALUE;
    int netPeople = 0;
    
    for(int row =0; row< data.length; row++){
      int currentTimeStamp = data[row][0];
      int currNoOfPeople = 0;
      while(row < data.length && data[row][0] == currentTimeStamp){
        if(data[row][2] == 1){
          currNoOfPeople += data[row][1];
        }else{
          currNoOfPeople -= data[row][1]; 
        }
        row++;
      }
      row--;
      if(maxFlow < netPeople + currNoOfPeople){
        timeStamp = currentTimeStamp;
        maxFlow = netPeople + currNoOfPeople;
      }
      netPeople += currNoOfPeople;
    }
    
    return timeStamp;
  }

  public static void main(String[] args) {
    BusiestTimeInMall bm = new BusiestTimeInMall();
    // int [][] data = new int[][]  {  {1487799425, 14, 1}, 
    // {1487799425, 4,  0},
    // {1487799425, 2,  0},
    // {1487800378, 10, 1},
    // {1487801478, 18, 0},
    // {1487801478, 18, 1},
    // {1487901013, 1,  0},
    // {1487901211, 7,  1},
    // {1487901211, 7,  0}     };

    int[][] data = new int[][] {{1487799425,14,1},{1487799425,4,0},{1487799425,2,0},
                                {1487800378,10,1},{1487801478,18,0},{1487801478,19,1},{1487801478,1,0},
                                {1487801478,1,1},{1487901013,1,0},{1487901211,7,1},{1487901211,8,0}}; 

    System.out.println(bm.findBusiestPeriod(data));
  }

}

/*
      
                 [1487799425, 14, 1],   // 14 people are entering
                 [1487799425, 4,  0],   //  4 people out 
                 [1487799425, 2,  0],   // 2 people out    8
                 **[1487800378, 10, 1],   // 10 entered 18
                 [1487801478, 18, 0],   // 18 out  0
                 [1487801478, 18, 1],   // 18
                 [1487901013, 1,  0],   // 1 out 17
                 [1487901211, 7,  1],   // 17
                 [1487901211, 7,  0] ]  // 
                 */