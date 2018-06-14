import java.util.*;

/*1009 Product of Polynomials
in
2 1 2.4 0 3.2
2 2 1.5 1 0.5
out
3 3 3.6 2 6.0 1 1.6
*/
public class p_1009{
    public static void main(String[] args){
        int k1, k2;
        Scanner sc = new Scanner(System.in);
        k1 = sc.nextInt();
        double[] term = new double[1001];
        double[] fin = new double[2001];

        for (int i = 0; i < k1; i++) {
            term[sc.nextInt()] = sc.nextDouble();
        }
        k2 = sc.nextInt();
        int count = 0;
        for (int i = 0; i < k2; i++) {
            int ex;
            double co;
            ex = sc.nextInt();
            co = sc.nextDouble();
            for(int j = 0 ; j < 1001; j ++){
                if(term[j] != 0){
                    fin[j + ex] += co * term[j];

                }
            }
        }
        for (int i = 0; i < 2001; i++) {
            if (fin[i] != 0)
                count++;
        }
        System.out.print(count);
        for (int i = 2000; i >= 0; i--) {
            if (fin[i] != 0)
                System.out.printf(" %d %.1f", i, fin[i]);
        }
        sc.close();
    }

}

