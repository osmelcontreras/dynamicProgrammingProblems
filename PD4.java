package osPlayground.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PD4 {

	public static HashMap<Integer, List<Integer>> memo = new HashMap<>();

	public static List<Integer> howSum(int targetSum, List<Integer> numbers) {

		if (memo.containsKey(targetSum)) {
			return memo.get(targetSum); 
		}

		if (targetSum == 0) {
			ArrayList<Integer> reminderResult = new ArrayList<>();
			return reminderResult;

		}
		if (targetSum < 0) {
			return null;
		}

		for (int i = 0; i < numbers.size(); i++) {
			int reminder = targetSum - numbers.get(i);

			List<Integer> reminderResult = howSum(reminder, numbers);
			if (reminderResult != null) {
				reminderResult.add(numbers.get(i));
				memo.put(targetSum, reminderResult);
				return reminderResult;

			}
		}
		memo.put(targetSum, null);

		return null;

	}

	public static void main(String[] args) {
		// System.out.println(howSum(7, Arrays.asList(2, 3)));
		System.out.println(howSum(7, Arrays.asList(5, 3, 4, 7)));
		// System.out.println(howSum(7, Arrays.asList(2, 4)));

	}

}
