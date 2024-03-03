package datastructures.graph;

public class Main {

    public static void main(String[] args) {
        Graph myGraph = new Graph();

        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");


        myGraph.addEdge("A", "B");
        myGraph.addEdge("A", "C");
        myGraph.addEdge("B", "C");


        System.out.println("\nGraph:");
        myGraph.printGraph();
        myGraph.removeVertex("C");

        System.out.println("\nGraph:");
        myGraph.printGraph();

        /*
            EXPECTED OUTPUT:
            ----------------
            Graph:
            {A=[], B=[]}

        */
    }
}
