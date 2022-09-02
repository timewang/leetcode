package org.snailgary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 * 电话号码的字母组合
 * Created by wangzhongfu on 2022/8/31
 */
public class LetterCombinationsOfPhoneNumber {

    Map<String, List<String>> numberLetterMap = new HashMap<String, List<String>>() {
        {
            put("2", Arrays.asList("a", "b", "c"));
            put("3", Arrays.asList("d", "e", "f"));
            put("4", Arrays.asList("g", "h", "i"));
            put("5", Arrays.asList("j", "k", "l"));
            put("6", Arrays.asList("m", "n", "o"));
            put("7", Arrays.asList("p", "q", "r", "s"));
            put("8", Arrays.asList("t", "u", "v"));
            put("9", Arrays.asList("w", "x", "y", "z"));
        }
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.equals("")) {
            return Collections.emptyList();
        }
        if (digits.length() == 1) {
            return numberLetterMap.get(digits);
        }
        int outStrLen = digits.length();

        List<String> letters = new ArrayList<>(outStrLen * outStrLen * outStrLen);
        // 按列 取
        List<List<String>> lettersList = new ArrayList<>(outStrLen);
        for (int i = 0; i < outStrLen; i++) {
            lettersList.add(numberLetterMap.get(digits.charAt(i) + ""));
        }
        // 23 2a\2b\2c 3d\3e\3f
        int index = 0;

        find(outStrLen, lettersList, index, letters, "");
        // System.out.println(letters);
        return letters;
    }

    private void find(int outStrLen, List<List<String>> lettersList, int index, List<String> lettersResult, String oneResult) {
        if (outStrLen == index) {
            lettersResult.add(oneResult);
            return;
        }
        for (String s : lettersList.get(index)) {
            find(outStrLen, lettersList, index + 1, lettersResult, oneResult + s);
        }
    }
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinationsOfficial(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                System.out.println(index + ":" + combination);
                combination.deleteCharAt(index);
                System.out.println(index + ":" + combination);
            }
        }
    }

    public static void main(String[] args) {
        new LetterCombinationsOfPhoneNumber().letterCombinationsOfficial("23");
    }

}
