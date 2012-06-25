import java.util.Arrays;

public class InitNext {

	public static void main(String... args) {
		if (args.length != 1) {
			System.err.println("Falsche Eingabe");
		}
		int[] next = next(args[0]);
		System.out.println(Arrays.toString(next));
	}

	public static int[] next(String s) {
		char[] p = s.toCharArray();
		int m = p.length;

		int[] next = new int[p.length];
		int l = 0;
		for (int q = 2; q <= m; q++) {
			while (l > 0 && p[l] != p[q-1]) {
				l = next[l-1];
			}
			if (p[l] == p[q-1]) {
				l++;
			}
			next[q-1] = l;
		}
		return next;
	}

}
