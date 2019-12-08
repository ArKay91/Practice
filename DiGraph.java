// Directed Graph Data Structure using adjacency lists
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DiGraph{
    //Structure to store Graph edges
    static class Edge{
        int src;
        int dest;

        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    };

    // List of Lists to represent adjacency list
    List<List<Integer>> adj = new ArrayList<>();
    
    //Constructor to construct Graph
    public DiGraph(List<Edge> edges){

        // allocate memory to adjacency lists
        for(int i=0; i < edges.size(); i++){
            adj.add(i, new ArrayList<>());
        }
        
        // add edges to the undirected graph
        for(Edge current : edges){
            //allocate new node in adjacency list from source to destination
            adj.get(current.src).add(current.dest);

            // uncomment for undirected graph

            //allocate new node in adjacency list from dest to src
            //adj.get(current.dest).add(current.src);
        }
    }

    //Print adjacency lists representation of graph
    private static void printGraph(DiGraph graph){
        int src = 0;
        int n = graph.adj.size();
        while(src < n){
            // print current vertex and all its neigboring vertices
            for(int dest : graph.adj.get(src)){
                System.out.print("(" + src + " --> " + dest + ")\t");
            }
            System.out.println("");
            src++;
        }
    } 

    // Directed graph implemention in Java
    public static void main(String[] args){
        // Input: List of all edges in a directed graph
        List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2), new Edge(2, 0), new Edge(2, 1), new Edge(3, 2), new Edge(4, 5), new Edge(5,4));

        // Construct graph from given lists of edges
        DiGraph graph = new DiGraph(edges);

        // Print adjacency lists represenation of the graph
        printGraph(graph);
    } 
}