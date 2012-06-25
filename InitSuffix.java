import java.util.Arrays;

public class InitSuffix {

	public static void main(String... args) {
		if (args.length != 1) {
			System.err.println("Falsche Eingabe");
		}
		
		int[] suffix = suffix(args[0]);
		System.out.println(Arrays.toString(suffix));
	}

	public static int[] suffix(String s) {
		int[] next = InitNext.next(s);
		int[] nextI = InitNext.next(inverse(s));
		int m = next.length;

		int[] suffix = new int[m];
		int j;
		for (j = 1; j <= m; j++) {
			suffix[j-1] = m - next[m-1];
		}
		for (int q = 1; q <= m; q++) {
			j = m - nextI[q-1];
			if (suffix[j-1] > q - nextI[q-1]) {
				suffix[j-1] = q - nextI[q-1];
			}
		}
		return suffix;
	}

	private static String inverse(String s) {
		char[] o = s.toCharArray();
		char[] n = new char[o.length];
		for (int i = 0; i < o.length; i++) {
			n[o.length - i - 1] = o[i];
		}
		return new String(n);
	}

}
