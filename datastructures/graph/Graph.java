package datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Graph {

    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public boolean addVertex(String label) {
        if(label == null) return false;
        if(adjList.get(label)==null){
            adjList.put(label, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vert1, String vert2){
        if(adjList.get(vert1)!= null && adjList.get(vert2)!=null){
            adjList.get(vert1).add(vert2);
            adjList.get(vert2).add(vert1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vert1, String vert2){
        if(adjList.get(vert1) != null && adjList.get(vert2) != null){
            adjList.get(vert1).remove(vert2);
            adjList.get(vert2).remove(vert1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vert){
        ArrayList<String> strings = adjList.get(vert);
        if(strings == null) return false;
        for(String s : strings){
            adjList.get(s).remove(vert);
        }
        adjList.remove(vert);
        return true;
    }

    public void printGraph() {
        System.out.println(adjList);
//        for(Map.Entry<Vertex, ArrayList<Vertex>>  entry : adjList.entrySet()){
//            System.out.println(entry.getKey().label + "=" + entry.getValue());
//        }
    }


    class Vertex {
        String label;
        Vertex(String label){
            this.label = label;
        }
    }
}
