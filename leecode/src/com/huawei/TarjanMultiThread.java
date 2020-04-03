package com.huawei;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Find all simple cycles in a directed graph using Tarjan's algorithm.
 * <p>
 * Space complexity - O(E + V + S) where S is length of all cycles
 * Time complexity - O(E*V(C+1) where C is total number of cycles
 * <p>
 * Reference - https://ecommons.cornell.edu/handle/1813/5941
 * https://github.com/jgrapht/jgrapht/tree/master/jgrapht-core/src/main/java/org/jgrapht/alg/cycle
 */
public class TarjanMultiThread {
    static class Edge {
        private Vertex vertex1;
        private Vertex vertex2;
        private int weight;

        Edge(Vertex vertex1, Vertex vertex2, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }

        Vertex getVertex1() {
            return vertex1;
        }

        Vertex getVertex2() {
            return vertex2;
        }

        int getWeight() {
            return weight;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((vertex1 == null) ? 0 : vertex1.hashCode());
            result = prime * result + ((vertex2 == null) ? 0 : vertex2.hashCode());
            return result;
        }

        @Override
        public String toString() {
            return "vertex1=" + vertex1
                    + ", vertex2=" + vertex2 + ", weight=" + weight + "]";
        }
    }

    static class Vertex {
        long id;
        private List<Vertex> adjacentVertex = new ArrayList<>();

        Vertex(long id) {
            this.id = id;
        }

        public long getId() {
            return id;
        }

        public void addAdjacentVertex(Vertex v) {
            adjacentVertex.add(v);
        }

        public String toString() {
            return String.valueOf(id);
        }

        public List<Vertex> getAdjacentVertexes() {
            return adjacentVertex;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + (int) (id ^ (id >>> 32));
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Vertex other = (Vertex) obj;
            return id == other.id;
        }
    }

    static class Graph {
        private List<Edge> allEdges;
        private Map<Long, Vertex> allVertex;

        public Graph() {
            allEdges = new ArrayList<>();
            allVertex = new HashMap<>();
        }

        public void addEdge(long id1, long id2) {
            addEdge(id1, id2, 0);
        }

        public void addEdge(long id1, long id2, int weight) {
            Vertex vertex1;
            if (allVertex.containsKey(id1)) {
                vertex1 = allVertex.get(id1);
            } else {
                vertex1 = new Vertex(id1);
                allVertex.put(id1, vertex1);
            }
            Vertex vertex2;
            if (allVertex.containsKey(id2)) {
                vertex2 = allVertex.get(id2);
            } else {
                vertex2 = new Vertex(id2);
                allVertex.put(id2, vertex2);
            }

            Edge edge = new Edge(vertex1, vertex2, weight);
            allEdges.add(edge);
            vertex1.addAdjacentVertex(vertex2);

        }

        public List<Edge> getAllEdges() {
            return allEdges;
        }

        public List<Vertex> getAllVertex() {
            return new ArrayList<>(allVertex.values());
        }


        @Override
        public String toString() {
            StringBuilder buffer = new StringBuilder();
            for (Edge edge : getAllEdges()) {
                buffer.append(edge.getVertex1()).append(" ").append(edge.getVertex2()).append(" ").append(edge.getWeight());
                buffer.append("\n");
            }
            return buffer.toString();
        }
    }


    private List<Set<Vertex>> visiteds;
    private List<Deque<Vertex>> pointStacks;
    private List<Deque<Vertex>> markedStacks;
    private List<Set<Vertex>> markedSets;
    private List<List<List<Vertex>>> results;

    private void reset(int num) {
        visiteds = new ArrayList<>();
        pointStacks = new ArrayList<>();
        markedStacks = new ArrayList<>();
        markedSets = new ArrayList<>();
        results = new ArrayList<>();
        for (int i = 0; i < num; ++i) {
            visiteds.add(new HashSet<>());
            pointStacks.add(new LinkedList<>());
            markedStacks.add(new LinkedList<>());
            markedSets.add(new HashSet<>());
            results.add(new ArrayList<>());
        }
//        visited = new HashSet<>();
//        pointStack = new LinkedList<>();
//        markedStack = new LinkedList<>();
//        markedSet = new HashSet<>();
    }

    public List<List<Vertex>> findAllSimpleCycles(Graph graph) {
        reset(graph.getAllVertex().size());
        ExecutorService executor = Executors.newFixedThreadPool(graph.getAllVertex().size());
        List<Vertex> vertices = graph.getAllVertex();
        for (int i = 0; i < vertices.size(); ++i) {
            Vertex vertex = vertices.get(i);
            Set<Vertex> visited = visiteds.get(i);
            Deque<Vertex> pointStack = pointStacks.get(i);
            Deque<Vertex> markedStack = markedStacks.get(i);
            Set<Vertex> markedSet = markedSets.get(i);
            List<List<Vertex>> result = results.get(i);
            executor.submit(() -> {
//                    System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName());
                findAllSimpleCycles(vertex, vertex, result, visited, pointStack, markedStack, markedSet);
                visited.add(vertex);
                while (!markedStack.isEmpty()) {
                    markedSet.remove(markedStack.pollFirst());
                }
            });
        }

//        for (Vertex vertex : graph.getAllVertex()) {
//            //113ms
////            System.out.println(1);
//            findAllSimpleCycles(vertex, vertex, result);
//            visited.add(vertex);
//            while (!markedStack.isEmpty()) {
//                markedSet.remove(markedStack.pollFirst());
//            }
//        }
        executor.shutdown();
        List<List<Vertex>> res = new ArrayList<>();
        for (List<List<Vertex>> i : results) {
            res.addAll(i);
        }
        return res;
    }

    private int count = 0;

    private boolean findAllSimpleCycles(Vertex start, Vertex current, List<List<Vertex>> result,
                                        Set<Vertex> visited, Deque<Vertex> pointStack,
                                        Deque<Vertex> markedStack, Set<Vertex> markedSet) {
        ++count;
//        System.out.println("in loop: " + count);
        boolean hasCycle = false;
        pointStack.offerFirst(current);
        markedSet.add(current);
        markedStack.offerFirst(current);

        for (Vertex w : current.getAdjacentVertexes()) {

            if (!visited.contains(w)) {
                if (w.equals(start)) {
                    //如果深搜又搜到了初始点，即存在环
                    hasCycle = true;
//                pointStack.offerFirst(w);
                    if (pointStack.size() > 2 && pointStack.size() < 8) {
                        List<Vertex> cycle = new ArrayList<>();
                        //头 43210 尾
                        Iterator<Vertex> itr = pointStack.descendingIterator();
                        while (itr.hasNext()) {
                            cycle.add(itr.next());
                        }
//                pointStack.pollFirst();
                        result.add(cycle);
                    }
                } else if (!markedSet.contains(w)) {
                    hasCycle = findAllSimpleCycles(start, w, result, visited, pointStack, markedStack, markedSet) || hasCycle;
                }
            }
        }

        if (hasCycle) {
            while (!Objects.requireNonNull(markedStack.peekFirst()).equals(current)) {
                markedSet.remove(markedStack.pollFirst());
            }
            markedSet.remove(markedStack.pollFirst());
        }

        pointStack.pollFirst();
        --count;
        System.out.println("exit loop: " + count);
        return hasCycle;
    }


    private Graph generate_data(String path) {
        Graph graph = new Graph();
        File file = new File(path);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String temp;
            while ((temp = br.readLine()) != null) {
                String[] t = temp.split(",");
                graph.addEdge(Long.parseLong(t[0]), Long.parseLong(t[1]));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return graph;
    }

    public static void main(String[] args) {
        String data_path = "D:\\code\\leecode\\src\\com\\huawei\\data\\test_data.txt";
        TarjanMultiThread tarjan = new TarjanMultiThread();
        Graph graph = tarjan.generate_data(data_path);
//        System.out.println(graph.toString());

//        graph.addEdge(1, 2);
//        graph.addEdge(1, 8);
//        graph.addEdge(2, 3);
//        graph.addEdge(2, 7);
//        graph.addEdge(3, 1);
//        graph.addEdge(3, 2);
//        graph.addEdge(3, 4);
//        graph.addEdge(3, 6);
//        graph.addEdge(4, 5);
//        graph.addEdge(5, 2);
//        graph.addEdge(6, 4);
//        graph.addEdge(8, 9);
//        graph.addEdge(9, 8);

//        int vertex_num = graph.getAllVertex().size();


        long startTime = System.currentTimeMillis();
        List<List<Vertex>> result = tarjan.findAllSimpleCycles(graph);
//        int count = 0;
//        for (List<Vertex> cycle : result) {
//            if (cycle.size() > 2 && cycle.size() < 8) {
//                ++count;
//                cycle.forEach(v -> System.out.print(v.getId() + " "));
//                System.out.println();
//            }
//        }
        result.forEach(cycle -> {
            cycle.forEach(v -> System.out.print(v.getId() + " "));
            System.out.println();
        });
        System.out.println(result.size());
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "ms");
    }
}