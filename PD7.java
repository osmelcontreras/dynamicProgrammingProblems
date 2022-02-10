package osPlayground.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PD7 {
	public Map<String, Integer> memo = new HashMap<>();

	public int countConstruct(String target, List<String> wordBank) {
		if (memo.containsKey(target)) {
			return memo.get(target);
		}

		if (target.equals("")) {
			return 1;
		}

		int totalCount = 0;
		for (String word : wordBank) {
			if (target.indexOf(word) == 0) {
				String suffix = target.substring(word.length());
				int numWaysForRest = countConstruct(suffix, wordBank);
				totalCount += numWaysForRest;
				memo.put(target, totalCount);
			}

		}
		memo.put(target, totalCount);
		return totalCount;
	}

	public static void main(String[] args) {

		String t0 = "purple";
		List<String> wb0 = Arrays.asList("purp", "p", "ur", "le", "purpl");
		String t = "abcdef";
		List<String> wb = Arrays.asList("ab", "abc", "cd", "def", "abcd");
		String t1 = "skateboard";
		List<String> wb1 = Arrays.asList("bo", "rd", "ate", "ska", "boar");
		String t2 = "enterapotentpot";
		List<String> wb2 = Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t");
		String t3 = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef";
		List<String> wb3 = Arrays.asList("e", "ee", "eee", "eeee", "eeeee", "eeeeee");

		System.out.println(new PD7().countConstruct(t0, wb0));
		System.out.println(new PD7().countConstruct(t, wb));
		System.out.println(new PD7().countConstruct(t1, wb1));
		System.out.println(new PD7().countConstruct(t2, wb2));
		System.out.println(new PD7().countConstruct(t3, wb3));
	}

}
