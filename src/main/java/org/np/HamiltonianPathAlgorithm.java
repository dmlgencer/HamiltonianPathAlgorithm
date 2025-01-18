package org.np;
import java.util.Arrays;

public class HamiltonianPathAlgorithm {

    /*
        Summary : This code solves the Hamiltonian Path problem on a given graph by creating an approximate solution.
                  The goal is to find a path that visits all nodes exactly once. We can use just 5 steps for this
                   story.

        Damla Naz Gençer | 91240000338
     */


    //Step 1.: We found the close closest node to the current node (currentNode).
    //It checks all unvisited nodes.
    private static int findNearestNeighbor(int[][] graph, int currentNode, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int nearestNeighbor = -1;

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i] && graph[currentNode][i] != 0 && graph[currentNode][i] < minDistance) {
                minDistance = graph[currentNode][i];
                nearestNeighbor = i;
            }
        }
        return nearestNeighbor;
    }

    //Step 2.:  findHamiltonianPath (Finding the Hamiltonian Path)
    //visited array: Keeps track of the visited nodes.
    //path array: Stores the Hamiltonian path.
    //Start: The first node (0) is marked as visited and added to the path.
    public static void findHamiltonianPath(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] path = new int[n];
        int currentNode = 0;

        visited[currentNode] = true;
        path[0] = currentNode;

        //Step 4: The closest neighbor at each step is found using the findNearestNeighbor function.
        for (int i = 1; i < n; i++) {
            int nextNode = findNearestNeighbor(graph, currentNode, visited);
            if (nextNode == -1) {
                System.out.println("No Hamiltonian Path Found!");
                return;
            }
            visited[nextNode] = true;
            path[i] = nextNode;
            currentNode = nextNode;
        }


    //Step 5: We printed the approximate Hamiltonian path.
        System.out.println("Hamiltonian Path (Approximate): " + Arrays.toString(path));
    }


    public static void main(String[] args) {
        // we can change this numbers. At the same time, we can get this numbers from user for more dynamic code.
        int[][] graph = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        findHamiltonianPath(graph);
    }
}
