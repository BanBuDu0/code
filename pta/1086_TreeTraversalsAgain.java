import java.util.*;

/*
6
Push 1
Push 2
Push 3
Pop
Pop
Push 4
Pop
Pop
Push 5
Push 6
Pop
Pop
123456
324165
*/
// pat correct niuke weizhicuowu
public class Main {
    private static void solve(int[] preOrder, int[] inOrder, int[] postOrder, int preLeft, int inLeft, int postLeft,
               int num) {
        if (num == 1)
            postOrder[postLeft] = preOrder[preLeft];
        if (num > 1) {
            int findNum = 0; // 存储中间节点的下标
            for (int i = inLeft; i < inLeft + num; i++) {
                if (preOrder[preLeft] == inOrder[i]) {
                    findNum = i;
                    break;
                }
            }
            postOrder[postLeft + num - 1] = preOrder[preLeft];
            int leftNum = findNum - inLeft;
            int rightNum = num - leftNum - 1;
            solve(preOrder, inOrder, postOrder, preLeft + 1, inLeft, postLeft, leftNum);
            solve(preOrder, inOrder, postOrder, preLeft + leftNum + 1, inLeft + leftNum + 1, postLeft + leftNum,
                    rightNum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        if (n == 0) {
            System.exit(0);
        }
        String[] op = new String[2 * n];
        List<Integer> first = new ArrayList<>();
        Stack<Integer> mi = new Stack<>();
        List<Integer> middle = new ArrayList<>();
        for (int i = 0; i < 2 * n; i++) {
            op[i] = sc.nextLine();
            if (op[i].charAt(1) == 'u') {
                first.add(Integer.parseInt(op[i].substring(5)));
                mi.push(Integer.parseInt(op[i].substring(5)));
            }
            if (op[i].charAt(1) == 'o') {
                middle.add(mi.pop());
            }
        }
        int[] preOrder = new int[n + 1];
        int[] inOrder = new int[n + 1];
        int[] postOrder = new int[n + 1];
        for (int i = 0; i < first.size(); i++) {
            preOrder[i] = first.get(i);
            inOrder[i] = middle.get(i);
        }
        solve(preOrder, inOrder, postOrder, 0, 0, 0, n);
        for (int i = 0; i < n; i++) {
            System.out.print(postOrder[i]);
            if (i != n - 1) {
                System.out.print(" ");
            }
        }
        sc.close();
    }
}
