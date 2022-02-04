package osPlayground.dp;

import java.util.HashMap;

public class DP1 {

	public HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();

	public int fib(int num) {
		// HashMap<Integer, Integer> memo = new HashMap<>();

		if (memo.containsKey(num)) {

			// System.out.println("Getting value from computed result for " + num);
			return memo.get(num);
		}
		if (num == 0) {
			return 0;
		}
		if (num == 1) {
			return 1;
		}
		int result = fib(num - 1) + fib(num - 2);
		// System.out.println("Putting result in cache for " + num);
		memo.put(num, result);
		return result;
	}

	public static void main(String[] args) {

		// System.out.println(new DP1().fib(6));
		// System.out.println(new DP1().fib(7));
		// System.out.println(new DP1().fib(51));
		System.out.println(new DP1().fib(50));

	}

}
