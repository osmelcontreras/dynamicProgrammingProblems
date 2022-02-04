package osPlayground.dp;

import java.util.HashMap;

public class DP3 {

	public static boolean canSum(int targetSum, int[] numbers) {
		HashMap<Integer, Boolean> memo = new HashMap<>();
		return canSum(targetSum, numbers, memo);
	}

	public static boolean canSum(int targetSum, int[] numbers, HashMap<Integer, Boolean> memo) {

		if (memo.containsKey(targetSum)) {
			return memo.get(targetSum);
		}

		if (targetSum == 0)
			return true;
		if (targetSum < 0)
			return false;

		for (int number : numbers) {
			int reminder = targetSum - number;

			if (canSum(reminder, numbers, memo)) {
				memo.put(targetSum, true);
				return true;
			}

		}
		memo.put(targetSum, false);
		return false;
	}

	public static void main(String[] args) {
		int ts = 12;
		int[] nA = { 3, 4, 6, 2 };
		int ts1 = 7;
		int[] nA1 = { 2, 5 };
		int ts2 = 300;
		int[] nA2 = { 7, 14 };

		System.out.println(canSum(ts, nA));
		System.out.println(canSum(ts1, nA1));
		System.out.println(canSum(ts2, nA2));
	}

}
