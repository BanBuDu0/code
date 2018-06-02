import java.util.*;

public class Main {
    /*
    def find_lowest_cost_node(costs): 
    lowest_cost = float("inf") 
    lowest_cost_node = None 
    for node in costs: 
        cost = costs[node] 
        if cost < lowest_cost and node not in processed: 
            lowest_cost = cost 
            lowest_cost_node = node
    return lowest_cost_node
*/
    private static int find_lowest_cost_node(int[][] m){
        int min = 999999999;
        for(int i : m){
            if()
        }

    }
    public static void main(String[] args) {
        /* input
        5 6 0 2
        1 2 1 5 3
        0 1 1
        0 2 2
        0 3 1
        1 2 1
        2 4 1
        3 4 1
        */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] map = new int[M][M];
        int INF = 999999999;
        int C1 = sc.nextInt();
        int C2 = sc.nextInt();
        int[] weight = new int[N];
        boolean[] isVisit = new boolean[N];
        for(int i = 0; i < N; i ++){
            weight[i] = sc.nextInt();
            Arrays.fill(map[i],INF);
        }
        for(int i = 0; i < M; i ++){
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();
            int d = sc.nextInt();
            map[c1][c2] = map[c2][c1] = d;
        }
        sc.close();

        Set<Integer> S = new HashSet<>();
        Set<Integer> U = new HashSet<>();
        S.add(C1);
        for(int i = 0;i < N; i ++){
            U.add(i);
        }
        U.remove(C1);
        int min = INF;
        int index = -1;
        while( !U.isEmpty()){
            int min = 0;
            for(int i = 0; i < N; i ++){
                for(int j = 0; j < S.size(); j++){
                    if(map[j][i] < min && isVisit[j] == false){
                        min = map[j][i];
                        index = j;
                    }
                }
                isVisit[j] = true;
                U.remove(j);

            }
        }






    }
}