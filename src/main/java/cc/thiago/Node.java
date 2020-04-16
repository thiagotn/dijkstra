package cc.thiago;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * A node can be described with a name, 
 * a LinkedList in reference to the shortestPath, 
 * a distance from the source, 
 * and an adjacency list named adjacentNodes:
 */
public class Node {

    private String name;

    /**
     * As for the shortestPath attribute, it is a list 
     * of nodes that describes the shortest path 
     * calculated from the starting node.
     */
    private List<Node> shortestPath = new LinkedList<>();

    /** 
     * By default, all node distances are initialized 
     * with Integer.MAX_VALUE to simulate an infinite 
     * distance as described in the initialization step.
    */
    private Integer distance = Integer.MAX_VALUE;

    /**
     * The adjacentNodes attribute is used to associate immediate 
     * neighbors with edge length. This is a simplified implementation 
     * of an adjacency list, which is more suitable for the 
     * Dijkstra algorithm than the adjacency matrix.
     */
    Map<Node, Integer> adjacentNodes = new HashMap<>();

    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public Node(String name) {
        this.name = name;
    }    

    // getters and setters

    public String getName() {
        return this.name;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return this.adjacentNodes;
    }

    public Integer getDistance() {
        return this.distance;
    }

    public List<Node> getShortestPath() {
        return this.shortestPath;
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }
}