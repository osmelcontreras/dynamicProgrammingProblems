package osPlayground.dp;

import java.util.HashMap;

public class PD2 {

	public static HashMap<String, Integer> memo = new HashMap<>();

	public static int gridTraveler(int m, int n) {

		String key = Integer.toString(m) + "," + Integer.toString(n);

		if (memo.containsKey(key)) {
			return memo.get(key);
		}

		if (m == 1 && n == 1) {
			return 1;
		}

		if (m == 0 || n == 0) {
			return 0;
		}

		int p = gridTraveler(m - 1, n) + gridTraveler(m, n - 1);

		memo.put(key, p);

		return p;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new PD2().gridTraveler(18, 18));
	}

}
