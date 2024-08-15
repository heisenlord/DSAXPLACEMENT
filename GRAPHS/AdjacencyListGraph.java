import java.util.*;

public class AdjacencyListGraph {
    //// for weighted graph create a class pair just like tuple in vertical order
    //// traversal
    /*
     * public List<List<Pair>> printGraph(int V, int edges[][]) {
     * List<List<Pair>> list = new LinkedList<>();
     * 
     * for (int i = 0; i < V; i++) {
     * list.add(new LinkedList<>());
     * }
     * 
     * for (int i = 0; i < edges.length; i++) {
     * int x = edges[i][0];
     * int y = edges[i][1];
     * int weight = edges[i][2];
     * 
     * list.get(x).add(new Pair(y, weight));
     * list.get(y).add(new Pair(x, weight));
     * }
     * 
     * return list;
     * }
     * 
     * class Pair {
     * int vertex;
     * int weight;
     * 
     * Pair(int vertex, int weight) {
     * this.vertex = vertex;
     * this.weight = weight;
     * }
     * }
     */

    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> list = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            list.add(new LinkedList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            list.get(x).add(y);
            list.get(y).add(x);

        }
        return list;

    }

    public static void main(String[] args) {

    }

}
