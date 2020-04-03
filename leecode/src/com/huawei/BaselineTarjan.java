package com.huawei;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BaselineTarjan {
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

    private Set<Vertex> visited = new HashSet<>();
    private Deque<Vertex> pointStack = new LinkedList<>();
    private Deque<Vertex> markedStack = new LinkedList<>();
    private Set<Vertex> markedSet = new HashSet<>();

    public List<List<Vertex>> findAllSimpleCycles(Graph graph) {
        List<List<Vertex>> result = new ArrayList<>();
        for (Vertex vertex : graph.getAllVertex()) {
            findAllSimpleCycles(vertex, vertex, result);
            visited.add(vertex);
            while (!markedStack.isEmpty()) {
                markedSet.remove(markedStack.pollFirst());
            }
        }
        return result;
    }

    private boolean findAllSimpleCycles(Vertex start, Vertex current, List<List<Vertex>> result) {
        boolean hasCycle = false;
        pointStack.offerFirst(current);
        markedSet.add(current);
        markedStack.offerFirst(current);

        for (Vertex w : current.getAdjacentVertexes()) {
            if (!visited.contains(w)) {
                if (w.equals(start)) {
                    hasCycle = true;
                    if (pointStack.size() > 2 && pointStack.size() < 8) {
                        List<Vertex> cycle = new ArrayList<>();
                        Iterator<Vertex> itr = pointStack.descendingIterator();
                        while (itr.hasNext()) {
                            cycle.add(itr.next());
                        }
                        result.add(cycle);
                    }
                } else if (!markedSet.contains(w)) {
                    hasCycle = findAllSimpleCycles(start, w, result) || hasCycle;
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
        BaselineTarjan baseline = new BaselineTarjan();
        Graph graph = baseline.generate_data(data_path);

        long startTime = System.currentTimeMillis();
        List<List<Vertex>> result = baseline.findAllSimpleCycles(graph);
        result.forEach(cycle -> {
            cycle.forEach(v -> System.out.print(v.getId() + " "));
            System.out.println();
        });
        System.out.println(result.size());
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "ms");
    }
}



