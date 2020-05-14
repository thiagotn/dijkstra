package cc.thiago.dijsktra;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Dijkstra {

    /**
     * 
     * @param graph
     * @param source
     * @return
     */
    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();
        
        unsettledNodes.add(source);

        while(unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Entry <Node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }

        printGraph(graph, source);
        return graph;
    }

    /**
     * The getLowestDistanceNode() method, returns the node with the 
     * lowest distance from the unsettled nodes set, while the 
     * calculateMinimumDistance() method compares the actual 
     * distance with the newly calculated one while following 
     * the newly explored path:
     * @param unsettledNodes
     * @return
     */
    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node: unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    /**
     * while the calculateMinimumDistance() method compares the 
     * actual distance with the newly calculated one while 
     * following the newly explored path
     * @param evalutionNode
     * @param edgeWeigh
     * @param sourceNode
     */
    private static void calculateMinimumDistance(Node evalutionNode, Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evalutionNode.getDistance()) {
            evalutionNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evalutionNode.setShortestPath(shortestPath);
        }
    }

    /**
     * Finally, we can calculate the shortest paths from node A are as follows:
     * Node B : A –> B (total distance = 10)
     * Node C : A –> C (total distance = 15)
     * Node D : A –> B –> D (total distance = 22)
     * Node E : A –> B –> D –> E (total distance = 24)
     * Node F : A –> B –> D –> F (total distance = 23)
     */
    public static void printGraph(Graph graph, Node source) {
        System.out.println("The shortest paths from Node " + source.getName() + " are as follows:");
        Map<String, Integer> resultMap = new HashMap<>();

        for (Node node : graph.getNodes()) {
            String shortestPathString = "";
            for (Node shortestNode : node.getShortestPath()) {
                shortestPathString +=  shortestNode.getName() + " -> ";
            }
            shortestPathString += node.getName();
            String outputFormat = "from Node " + source.getName() + " to Node " + node.getName() + 
                ": " + shortestPathString + 
                " (total distance = " + node.getDistance() + ") ";
            
            if (node.getDistance() > 0)
                resultMap.put(outputFormat, node.getDistance());
        }

        Map<String, Integer> result = App.sortByValue(resultMap);
        for (String printableResult : result.keySet()) {
            System.out.println(printableResult);
        }
    }
}