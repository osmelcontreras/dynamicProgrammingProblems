package osPlayground.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PD5 {
	public Map<Integer, List<Integer>> memo = new HashMap<>();

	public List<Integer> bestSum(int targetSum, List<Integer> numbers) {

		if (memo.containsKey(targetSum)) {
			return memo.get(targetSum);
		}
		if (targetSum == 0)
			return Collections.emptyList();

		if (targetSum < 0)
			return null;

		List<Integer> shortestCombination = null;

		for (int i = 0; i < numbers.size(); i++) {
			int reminder = targetSum - numbers.get(i);
			List<Integer> reminderCombination = bestSum(reminder, numbers);
			memo.put(targetSum, reminderCombination);
			if (reminderCombination != null) {
				List<Integer> combination = new ArrayList<Integer>(reminderCombination);
				combination.add(numbers.get(i));
				if (shortestCombination == null || reminderCombination.size() < shortestCombination.size()) {
					shortestCombination = combination;
				}
			}

		}
		memo.put(targetSum, shortestCombination);
		return shortestCombination;

	}

	public static void main(String[] args) {

		int n = 7;
		List<Integer> arr = Arrays.asList(5, 3, 4, 7);
		int n1 = 8;
		List<Integer> arr1 = Arrays.asList(2, 3, 5);
		int n2 = 8;
		List<Integer> arr2 = Arrays.asList(1, 4, 5);
		int n3 = 100;
		List<Integer> arr3 = Arrays.asList(1, 2, 5, 25);
		System.out.println(new PD5().bestSum(n, arr)); // [7]
		System.out.println(new PD5().bestSum(n1, arr1));// [3, 5]
		System.out.println(new PD5().bestSum(n2, arr2)); // [4,4]
		System.out.println(new PD5().bestSum(n3, arr3)); // [25, 25, 25, 25]

	}

}
