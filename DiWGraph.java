import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiWGraph{
    static class Edge{
        int src, dest, weight;

        Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    };
    // Data Srtucture for adjacency list node
    static class Node{
        int value, weight;
        Node(int value, int weight){
            this.value = value;
            this.weight = weight;
        }
    };
    // A list of lists to represent adjacency list
    List<List<Node>> adj = new ArrayList<>();

    // Constructor to construct graph
    public DiWGraph(List<Edge> edges){
        //allocate memory for adjacency lists
        for(int i=0; i<edges.size(); i++){
            adj.add(i, new ArrayList<>());
        }
        //add edges to graph
        for(Edge edge : edges){
            // allocate new node in adjacency list from src to dest
            adj.get(edge.src).add(new Node(edge.dest, edge.weight));

            // uncomment for undirected graph
            //adj.get(edge.dest).add(new Node(edge.src, edge.weight));
        }
    }
    // Print adjacency list representation of graph
    private static void printGraph(DiWGraph graph){
        int src = 0;
        int n = graph.adj.size();
        while(src < n){
            // print current vertex and all its neighboring vertices
            for(Node edge : graph.adj.get(src)){
                System.out.print(src + "--->" + edge.value + "(" + edge.weight + ")\t");
            }
            System.out.println("");
            src++;
        }
    } 
    //Weighted directed graph implementation in Java
    public static void main(String[] args){
        //Input : list of edges in a weighted directed graph 
        //tuple (x, y, w) represents an edge from x to y having weight w
        List<Edge> edges = Arrays.asList(new Edge(0, 1, 6), new Edge(1, 2, 7),
										new Edge(2, 0, 5), new Edge(2, 1, 4),
										new Edge(3, 2, 10), new Edge(4, 5, 1),
										new Edge(5, 4, 3));
        
        //Construct graph from given list of edges
        DiWGraph graph = new DiWGraph(edges);

        //Print adjacency list representation of the graph
        printGraph(graph);                                         
    } 

}