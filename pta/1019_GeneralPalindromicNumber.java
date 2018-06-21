import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class GeneralPalindromicNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int b = sc.nextInt();
		int disscuss = 0;
		List<Integer> reside = new ArrayList<>();
		//if()
		while (b <= N) {
			disscuss = N / b;
			reside.add(N % b);
			N = disscuss;
		}
		reside.add(N);
		int length = reside.size();
		int flag = 1;
		for (int i = 0, j = length - 1; i < j; i++, j--) {
			if (reside.get(i) != reside.get(j)) {
				System.out.println("No");
				flag = 0;
				break;//如果不break;可能会打印多个No
			}
		}
		if (flag == 1) {
			System.out.println("Yes");
		}
		System.out.print(reside.get(length - 1));
		for (int j = length - 2; j >= 0; j--) {
			System.out.print(" " + reside.get(j));
		}
	}
}