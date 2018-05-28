import java.util.*;

public class Main {

    public static void main(String[] arg){
        Scanner sc =new Scanner(System.in);
        String[] line1 =sc.nextLine().trim().split(" ");
        String[] line2 =sc.nextLine().trim().split(" ");

        int k1 =Integer.parseInt(line1[0]);
        int k2 =Integer.parseInt(line2[0]);

        Map<Integer,Double> map =new TreeMap<>();

        for(int i = 1; i < k1*2+1; i += 2){
            int key  =Integer.valueOf(line1[i]);
            double value=Double.valueOf(line1[i+1]);
            map.put(key, value);
        }

        for(int i = 1; i < k2*2+1; i += 2){
            int    key   = Integer.valueOf(line2[i]);
            double value = Double.valueOf(line2[i+1]);

            if(map.containsKey(key)){
                value += map.get(key);
                if(Math.abs(value)<=0.00001){
                    map.remove(key);
                }
                else{
                    value= Math.round(value*10)/10.0;
                    map.put(key, value);
                }
            }
            else{
                value= Math.round(value*10)/10.0;
                map.put(key, value);
            }
        }
        System.out.print(map.size());
        map = ((TreeMap<Integer, Double>) map).descendingMap();
        for(int keyTemp : map.keySet()){
            System.out.print(" "+keyTemp + " " + map.get(keyTemp));
        }
    }
}