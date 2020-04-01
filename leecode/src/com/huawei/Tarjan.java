package com.huawei;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Find all simple cycles in a directed graph using Tarjan's algorithm.
 * <p>
 * Space complexity - O(E + V + S) where S is length of all cycles
 * Time complexity - O(E*V(C+1) where C is total number of cycles
 * <p>
 * Reference - https://ecommons.cornell.edu/handle/1813/5941
 * https://github.com/jgrapht/jgrapht/tree/master/jgrapht-core/src/main/java/org/jgrapht/alg/cycle
 */
public class Tarjan {
    private Set<Vertex<Integer>> visited;
    private Deque<Vertex<Integer>> pointStack;
    private Deque<Vertex<Integer>> markedStack;
    private Set<Vertex<Integer>> markedSet;

    private void reset() {
        visited = new HashSet<>();
        pointStack = new LinkedList<>();
        markedStack = new LinkedList<>();
        markedSet = new HashSet<>();
    }

    public List<List<Vertex<Integer>>> findAllSimpleCycles(Graph<Integer> graph) {
        reset();
        List<List<Vertex<Integer>>> result = new ArrayList<>();
        for (Vertex<Integer> vertex : graph.getAllVertex()) {
            findAllSimpleCycles(vertex, vertex, result);
            visited.add(vertex);
            while (!markedStack.isEmpty()) {
                markedSet.remove(markedStack.pollFirst());
            }
        }
        return result;
    }

    private boolean findAllSimpleCycles(Vertex<Integer> start, Vertex<Integer> current, List<List<Vertex<Integer>>> result) {
        boolean hasCycle = false;
        pointStack.offerFirst(current);
        markedSet.add(current);
        markedStack.offerFirst(current);

        for (Vertex<Integer> w : current.getAdjacentVertexes()) {
            if (visited.contains(w)) {
                continue;
            } else if (w.equals(start)) {
                hasCycle = true;
                pointStack.offerFirst(w);
                List<Vertex<Integer>> cycle = new ArrayList<>();
                Iterator<Vertex<Integer>> itr = pointStack.descendingIterator();
                while (itr.hasNext()) {
                    cycle.add(itr.next());
                }
                pointStack.pollFirst();
                result.add(cycle);
            } else if (!markedSet.contains(w)) {
                hasCycle = findAllSimpleCycles(start, w, result) || hasCycle;
            }
        }

        if (hasCycle) {
            while (!markedStack.peekFirst().equals(current)) {
                markedSet.remove(markedStack.pollFirst());
            }
            markedSet.remove(markedStack.pollFirst());
        }

        pointStack.pollFirst();
        return hasCycle;
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(true);
        String data_path = "D:\\python\\huawei\\data\\test_data.txt";
        File file = new File(data_path);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String temp;
            while ((temp = br.readLine()) != null) {//使用readLine方法，一次读一行
                String[] t = temp.split(",");
                graph.addEdge(Long.parseLong(t[0]), Long.parseLong(t[1]));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Tarjan tarjan = new Tarjan();
        long startTime = System.currentTimeMillis();
        List<List<Vertex<Integer>>> result = tarjan.findAllSimpleCycles(graph);
        int count = 0;
        for (List<Vertex<Integer>> cycle : result) {
            if (cycle.size() > 3 && cycle.size() < 9) {
                ++count;
                cycle.forEach(v -> System.out.print(v.getId() + " "));
                System.out.println();
            }
        }
        System.out.println(count);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "ms");
    }
}


class Edge<T> {
    private boolean isDirected = false;
    private Vertex<T> vertex1;
    private Vertex<T> vertex2;
    private int weight;

    Edge(Vertex<T> vertex1, Vertex<T> vertex2) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    Edge(Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected, int weight) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
        this.isDirected = isDirected;
    }

    Edge(Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.isDirected = isDirected;
    }

    Vertex<T> getVertex1() {
        return vertex1;
    }

    Vertex<T> getVertex2() {
        return vertex2;
    }

    int getWeight() {
        return weight;
    }

    public boolean isDirected() {
        return isDirected;
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
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Edge other = (Edge) obj;
        if (vertex1 == null) {
            if (other.vertex1 != null)
                return false;
        } else if (!vertex1.equals(other.vertex1))
            return false;
        if (vertex2 == null) {
            if (other.vertex2 != null)
                return false;
        } else if (!vertex2.equals(other.vertex2))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Edge [isDirected=" + isDirected + ", vertex1=" + vertex1
                + ", vertex2=" + vertex2 + ", weight=" + weight + "]";
    }
}

class Vertex<T> {
    long id;
    private T data;
    private List<Edge<T>> edges = new ArrayList<>();
    private List<Vertex<T>> adjacentVertex = new ArrayList<>();

    Vertex(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void addAdjacentVertex(Edge<T> e, Vertex<T> v) {
        edges.add(e);
        adjacentVertex.add(v);
    }

    public String toString() {
        return String.valueOf(id);
    }

    public List<Vertex<T>> getAdjacentVertexes() {
        return adjacentVertex;
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

    public int getDegree() {
        return edges.size();
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
        if (id != other.id)
            return false;
        return true;
    }
}

class Graph<T> {

    private List<Edge<T>> allEdges;
    private Map<Long, Vertex<T>> allVertex;
    boolean isDirected = false;

    public Graph(boolean isDirected) {
        allEdges = new ArrayList<Edge<T>>();
        allVertex = new HashMap<Long, Vertex<T>>();
        this.isDirected = isDirected;
    }

    public void addEdge(long id1, long id2) {
        addEdge(id1, id2, 0);
    }

    //This works only for directed graph because for undirected graph we can end up
    //adding edges two times to allEdges
    public void addVertex(Vertex<T> vertex) {
        if (allVertex.containsKey(vertex.getId())) {
            return;
        }
        allVertex.put(vertex.getId(), vertex);
        for (Edge<T> edge : vertex.getEdges()) {
            allEdges.add(edge);
        }
    }

    public Vertex<T> addSingleVertex(long id) {
        if (allVertex.containsKey(id)) {
            return allVertex.get(id);
        }
        Vertex<T> v = new Vertex<T>(id);
        allVertex.put(id, v);
        return v;
    }

    public Vertex<T> getVertex(long id) {
        return allVertex.get(id);
    }

    public void addEdge(long id1, long id2, int weight) {
        Vertex<T> vertex1 = null;
        if (allVertex.containsKey(id1)) {
            vertex1 = allVertex.get(id1);
        } else {
            vertex1 = new Vertex<T>(id1);
            allVertex.put(id1, vertex1);
        }
        Vertex<T> vertex2 = null;
        if (allVertex.containsKey(id2)) {
            vertex2 = allVertex.get(id2);
        } else {
            vertex2 = new Vertex<T>(id2);
            allVertex.put(id2, vertex2);
        }

        Edge<T> edge = new Edge<T>(vertex1, vertex2, isDirected, weight);
        allEdges.add(edge);
        vertex1.addAdjacentVertex(edge, vertex2);
        if (!isDirected) {
            vertex2.addAdjacentVertex(edge, vertex1);
        }

    }

    public List<Edge<T>> getAllEdges() {
        return allEdges;
    }

    public Collection<Vertex<T>> getAllVertex() {
        return allVertex.values();
    }

    public void setDataForVertex(long id, T data) {
        if (allVertex.containsKey(id)) {
            Vertex<T> vertex = allVertex.get(id);
            vertex.setData(data);
        }
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (Edge<T> edge : getAllEdges()) {
            buffer.append(edge.getVertex1() + " " + edge.getVertex2() + " " + edge.getWeight());
            buffer.append("\n");
        }
        return buffer.toString();
    }
}

