package osPlayground.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PD6 {

	public Map<String, Boolean> memo = new HashMap<>();

	public boolean canConstruct(String target, List<String> wordbank) {

		if (memo.containsKey(target)) {
			return memo.get(target);
		}

		if (target.equals("")) {
			return true;
		}

		for (String word : wordbank) {
			if (target.indexOf(word) == 0) {
				String suffix = target.substring(word.length());

				if (canConstruct(suffix, wordbank) == true) {
					memo.put(target, true);
					return true;
				}
			}

		}
		memo.put(target, false);
		return false;

	}

	public static void main(String[] args) {

		String t = "abcdef";
		List<String> wb = Arrays.asList("ab", "abc", "cd", "def", "abcd");
		String t1 = "skateboard";
		List<String> wb1 = Arrays.asList("bo", "rd", "ate", "ska", "boar");
		String t2 = "enterapotentpot";
		List<String> wb2 = Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t");
		String t3 = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef";
		List<String> wb3 = Arrays.asList("e", "ee", "eee", "eeee", "eeeee", "eeeeee");

		System.out.println(new PD6().canConstruct(t, wb));
		System.out.println(new PD6().canConstruct(t1, wb1));
		System.out.println(new PD6().canConstruct(t2, wb2));
		System.out.println(new PD6().canConstruct(t3, wb3));
	}

}
