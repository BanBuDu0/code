import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, min_grade, max_grade;
        n = sc.nextInt();
        Map<Integer, String> records = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String name, id;
            name = sc.next();
            id = sc.next();
            records.put(sc.nextInt(), name + " " + id);
        }
        min_grade = sc.nextInt();
        max_grade = sc.nextInt();

        int index = 0;
        for (int i : ((TreeMap<Integer, String>) records).descendingKeySet()) {
            if (i >= min_grade && i <= max_grade) {
                System.out.println(records.get(i));
                index++;
            }
        }
        if (index == 0) {
            System.out.println("NONE");
        }
    }

}
