package org.snailgary;

import org.junit.Test;

import java.util.*;

public class LongestPalindrome {

    //Map<String, Boolean> isCharEqual = new HashMap<>();

    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        String current = s.charAt(0) + "";

        for (int i = 0; i < s.length() - 1; i++) {

            int j = s.length() - 1;
            w: while (i < j) {
                if (current.length() == s.length()) {
                    return s;
                }
                if (s.charAt(i) == s.charAt(j) && (j-i+1) >= current.length()) {
                    String palindrome = palindrome(i, j, s);
                    if (palindrome.length() > 0 && palindrome.length() >= current.length()) {
                        current = palindrome;
                    }

                }
                j--;
            }

        }

        return current;
    }

    public String longestPalindrome1(String s) {
        if (s.length() == 0) {
            return "";
        }
        String current = s.charAt(0) + "";

        for (int i = 0; i < s.length() - 1; i++) {

            int j = s.length() - 1;

           /* if ((j-i+1) < current.length() ) {
                return current;
            }*/

            w: while (i < j) {
                if (current.length() == s.length()) {
                    return s;
                }
                if (s.charAt(i) == s.charAt(j) && (j-i+1) >= current.length()) {

                    boolean isPalindrome = isPalindrome(i, j, s);

                    if (isPalindrome) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int start = i; start <= j; start++) {
                            stringBuilder.append(s.charAt(start));
                        }
                        current = stringBuilder.toString();
                    }

                }
                j--;
            }

        }

        return current;
    }

    public boolean isPalindrome(int start, int end, String s) {
        int length = (end - start) + 1;
        if (length == 2 || length == 3) {
            return s.charAt(start) == s.charAt(end);
        }
        int m = length % 2;

        boolean isPalindrome = true;
        if (m == 0) {

            int left = start;
            int right = end;
            w:
            while (left < right ) {

                if (s.charAt(left) != s.charAt(right)) {
                    isPalindrome = false;
                    break w;
                }
                left++;
                right--;
            }

        } else if (m == 1) {
            int middle = length / 2 + start;

            int left = start;
            int right = end;

            w:
            while (left < middle && right > middle) {
                if (s.charAt(left) != s.charAt(right)) {
                    isPalindrome = false;
                    break w;
                }

                left++;
                right--;

            }

        }

        return isPalindrome;
    }

    public String longestPalindromeOfficial(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    public String palindrome(int start, int end, String s) {

        int length = (end - start) + 1;
        if (length == 2) {
            //return s.charAt(start) == s.charAt(end);
            if (s.charAt(start) == s.charAt(end)) {
                return s.charAt(start) + "" + s.charAt(end) + "";
            }
        }
        if (length == 3) {
            if (s.charAt(start) == s.charAt(end)) {
                return s.charAt(start) + "" + s.charAt(end - 1) + "" + s.charAt(end) + "";
            }
        }

        StringBuilder leftString = new StringBuilder();
        StringBuilder rightString = new StringBuilder();
        int m = length % 2;

        boolean isPalindrome = true;
        if (m == 0) {

            int left = start;
            int right = end;
            int meiddleIndex = length/2 + start;
            w:
            while (left < right && meiddleIndex <= end) {

                if (s.charAt(left) != s.charAt(right)) {
                    isPalindrome = false;
                    break w;
                }
                leftString.append(s.charAt(left));
                rightString.append(s.charAt(meiddleIndex));
                left++;
                meiddleIndex++;
                right--;
            }

        } else if (m == 1) {
            int middle = length / 2 + start;

            int left = start;
            int right = end;
            int meiddleIndex = length/2 + start;

            w:
            while (left < middle && right > middle) {
                if (s.charAt(left) != s.charAt(right)) {
                    isPalindrome = false;
                    break w;
                }
                leftString.append(s.charAt(left));
                rightString.append(s.charAt(meiddleIndex));
                left++;
                meiddleIndex++;
                right--;

            }
            //leftString.append(s.charAt(middle));
            rightString.append(s.charAt(end));

        }

        if (isPalindrome) {
            return leftString.toString() + rightString.toString();
        }

        return "";
    }

    @Test
    public void testReverse() {
        StringBuilder stringBuilder = new StringBuilder();
        String s = "abcba";
        stringBuilder.append(s);
        System.out.println(stringBuilder.reverse());
        int start = 0;
        int end = 4;
        int length = s.length();
        int modularTwo = length%2;
        if (modularTwo == 0) {

        }else {


        }

    }

    @Test
    public void result() {
        //System.out.println(isCharEqual);
        long start = System.currentTimeMillis();
        //String s = longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        String s = longestPalindrome("babad");
        System.out.println(s);
        System.out.println(s.length());
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void test() {
        String s = "abadddddd";
        char[] chars = s.toCharArray();
        System.out.println(s.length() % 2);
        int[] minAndMaxIndex = new int[2];
        int middle;
        if (s.length() % 2 == 0) {
            middle = s.length() / 2 - 1;
        } else {
            middle = s.length() / 2;
        }

        List<Character> characters = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            characters.add(s.charAt(i));

            int j = i + 1;
            while (j < s.length()) {

                if (i == 0) {
                    if (s.charAt(j) == s.charAt(i)) {
                        //characters.
                    }
                }


            }


        }


    }

    @Test
    public void testCharInt() {
        String s = "abc";
    }


}
