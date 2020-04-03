//package com.huawei;
//
//import com.huawei.common.Graph;
//import com.huawei.common.Vertex;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.*;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
///**
// * Find all simple cycles in a directed graph using Tarjan's algorithm.
// * <p>
// * Space complexity - O(E + V + S) where S is length of all cycles
// * Time complexity - O(E*V(C+1) where C is total number of cycles
// * <p>
// * Reference - https://ecommons.cornell.edu/handle/1813/5941
// * https://github.com/jgrapht/jgrapht/tree/master/jgrapht-core/src/main/java/org/jgrapht/alg/cycle
// */
//public class Tarjan {
//    private List<Set<Vertex<Integer>>> visiteds;
//    private List<Deque<Vertex<Integer>>> pointStacks;
//    private List<Deque<Vertex<Integer>>> markedStacks;
//    private List<Set<Vertex<Integer>>> markedSets;
//    private List<List<List<Vertex<Integer>>>> results;
//
//    private void reset(int num) {
//        visiteds = new ArrayList<>();
//        pointStacks = new ArrayList<>();
//        markedStacks = new ArrayList<>();
//        markedSets = new ArrayList<>();
//        results = new ArrayList<>();
//        for (int i = 0; i < num; ++i) {
//            visiteds.add(new HashSet<>());
//            pointStacks.add(new LinkedList<>());
//            markedStacks.add(new LinkedList<>());
//            markedSets.add(new HashSet<>());
//            results.add(new ArrayList<>());
//        }
////        visited = new HashSet<>();
////        pointStack = new LinkedList<>();
////        markedStack = new LinkedList<>();
////        markedSet = new HashSet<>();
//    }
//
//    public List<List<Vertex<Integer>>> findAllSimpleCycles(Graph<Integer> graph) {
//        reset(graph.getAllVertex().size());
//        ExecutorService executor = Executors.newFixedThreadPool(graph.getAllVertex().size());
//        List<Vertex<Integer>> vertices = graph.getAllVertex();
//        for (int i = 0; i < vertices.size(); ++i) {
//            Vertex<Integer> vertex = vertices.get(i);
//            Set<Vertex<Integer>> visited = visiteds.get(i);
//            Deque<Vertex<Integer>> pointStack = pointStacks.get(i);
//            Deque<Vertex<Integer>> markedStack = markedStacks.get(i);
//            Set<Vertex<Integer>> markedSet = markedSets.get(i);
//            List<List<Vertex<Integer>>> result = results.get(i);
//            executor.submit(new Runnable() {
//                @Override
//                public void run() {
////                    System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName());
//                    findAllSimpleCycles(vertex, vertex, result, visited, pointStack, markedStack, markedSet);
//                    visited.add(vertex);
//                    while (!markedStack.isEmpty()) {
//                        markedSet.remove(markedStack.pollFirst());
//                    }
//                }
//            });
//        }
//
////        for (Vertex<Integer> vertex : graph.getAllVertex()) {
////            //113ms
//////            System.out.println(1);
////            findAllSimpleCycles(vertex, vertex, result);
////            visited.add(vertex);
////            while (!markedStack.isEmpty()) {
////                markedSet.remove(markedStack.pollFirst());
////            }
////        }
//        executor.shutdown();
//        List<List<Vertex<Integer>>> res = new ArrayList<>();
//        for (List<List<Vertex<Integer>>> i : results) {
//            res.addAll(i);
//        }
//        return res;
//    }
//
//    private int count = 0;
//
//    private boolean findAllSimpleCycles(Vertex<Integer> start, Vertex<Integer> current, List<List<Vertex<Integer>>> result,
//                                        Set<Vertex<Integer>> visited, Deque<Vertex<Integer>> pointStack,
//                                        Deque<Vertex<Integer>> markedStack, Set<Vertex<Integer>> markedSet) {
//        ++count;
////        System.out.println("in loop: " + count);
//        boolean hasCycle = false;
//        pointStack.offerFirst(current);
//        markedSet.add(current);
//        markedStack.offerFirst(current);
//
//        for (Vertex<Integer> w : current.getAdjacentVertexes()) {
//            if (visited.contains(w)) {
//                continue;
//            } else if (w.equals(start)) {
//                //如果深搜又搜到了初始点，即存在环
//                hasCycle = true;
////                pointStack.offerFirst(w);
//                if (pointStack.size() > 2 && pointStack.size() < 8) {
//                    List<Vertex<Integer>> cycle = new ArrayList<>();
//                    //头 43210 尾
//                    Iterator<Vertex<Integer>> itr = pointStack.descendingIterator();
//                    while (itr.hasNext()) {
//                        cycle.add(itr.next());
//                    }
////                pointStack.pollFirst();
//                    result.add(cycle);
//                }
//            } else if (!markedSet.contains(w)) {
//                hasCycle = findAllSimpleCycles(start, w, result, visited, pointStack, markedStack, markedSet) || hasCycle;
//            }
//        }
//
//        if (hasCycle) {
//            while (!markedStack.peekFirst().equals(current)) {
//                markedSet.remove(markedStack.pollFirst());
//            }
//            markedSet.remove(markedStack.pollFirst());
//        }
//
//        pointStack.pollFirst();
//        --count;
//        System.out.println("exit loop: " + count);
//        return hasCycle;
//    }
//
//
//    private Graph<Integer> generate_data(String path) {
//        Graph<Integer> graph = new Graph<>(true);
//        File file = new File(path);
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(file));
//            String temp;
//            while ((temp = br.readLine()) != null) {
//                String[] t = temp.split(",");
//                graph.addEdge(Long.parseLong(t[0]), Long.parseLong(t[1]));
//            }
//            br.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return graph;
//    }
//
//    public static void main(String[] args) {
//        String data_path = "D:\\code\\leecode\\src\\com\\huawei\\data\\test_data1.txt";
//        Tarjan tarjan = new Tarjan();
//        Graph<Integer> graph = tarjan.generate_data(data_path);
////        System.out.println(graph.toString());
//
////        graph.addEdge(1, 2);
////        graph.addEdge(1, 8);
////        graph.addEdge(2, 3);
////        graph.addEdge(2, 7);
////        graph.addEdge(3, 1);
////        graph.addEdge(3, 2);
////        graph.addEdge(3, 4);
////        graph.addEdge(3, 6);
////        graph.addEdge(4, 5);
////        graph.addEdge(5, 2);
////        graph.addEdge(6, 4);
////        graph.addEdge(8, 9);
////        graph.addEdge(9, 8);
//
////        int vertex_num = graph.getAllVertex().size();
//
//
//        long startTime = System.currentTimeMillis();
//        List<List<Vertex<Integer>>> result = tarjan.findAllSimpleCycles(graph);
////        int count = 0;
////        for (List<Vertex<Integer>> cycle : result) {
////            if (cycle.size() > 2 && cycle.size() < 8) {
////                ++count;
////                cycle.forEach(v -> System.out.print(v.getId() + " "));
////                System.out.println();
////            }
////        }
//        result.forEach(cycle -> {
//            cycle.forEach(v -> System.out.print(v.getId() + " "));
//            System.out.println();
//        });
//        System.out.println(result.size());
//        long endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime + "ms");
//    }
//}