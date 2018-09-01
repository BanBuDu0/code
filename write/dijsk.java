import java.util.*;
//1003
public class temp{    
    static int n = 0;
    static int m = 0;
    static int c1 = 0;
    static int c2 = 0;
    static int[][] map = new int[505][505];
    static int[] weight = new int[505];
    static int[] dist = new int[505];
    static boolean[] visit = new boolean[505];
    static int[] num = new int[505];
    static int[] w = new int[505];
    static final int inf = 9999999;
    public static void main(String[] args){  
        Arrays.fill(dist, inf);
        int i = 0, j = 0, k = 0;
        for(i=0;i<505;i++) {
            Arrays.fill(map[i], inf);
        }
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt(); //city nums  5
        m = cin.nextInt(); //rode nums   6
        c1 = cin.nextInt(); //c1 -> c2    0
        c2 = cin.nextInt(); //             2
        for(i=0;i<n;i++) {
            weight[i] = cin.nextInt();  //cityi's weigtht  1 2 1 5 3
        }
        for(i=0;i<m;i++) {
            int x = cin.nextInt();int y = cin.nextInt();int z = cin.nextInt();map[x][y] = map[y][x] = z;
        }
        dist[c1] = 0;
        w[c1] = weight[c1];
        num[c1] = 1;
        for(i=0; i < n ;i++) {
            int index = -1, min = inf;
            for(j=0;j<n;j++) {
                if(visit[j] == false && dist[j] < min) {
                    min = dist[j];
                    index = j;
                }
            }
            if(index == -1) break;
            visit[index] = true;
            for(k=0;k<n;k++) {
                if(visit[k] == false && map[index][k] != inf) {
                    if(dist[index] + map[index][k] < dist[k]) {
                        dist[k] = dist[index] + map[index][k];
                        num[k] = num[index];
                        w[k] = w[index] + weight[k];
                    }
                    else if(dist[index] + map[index][k] == dist[k]) {
                        num[k] = num[k] + num[index];
                        if(w[index] + weight[k] > w[k]) {
                            w[k] = w[index] + weight[k];
                        }
                    }
                }
            }
        }
        System.out.printf("%d %d",num[c2], w[c2]);
    }  
}