package org.snailgary;

import org.junit.Test;

import java.util.*;

public class LongestPalindrome {


    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        String current = s.charAt(0) + "";

        for (int i = 0; i < s.length() - 1; i++) {

            int j = s.length() - 1;
            while (i < j) {
                String palindrome = palindrome(i, j, s);
                if (palindrome.length() > 0 && palindrome.length() >= current.length()) {
                    current = palindrome;
                }
                j--;
            }

        }



        return current;
    }

    public String palindrome(int start, int end, String s) {
        if (isPalindrome(start, end, s)) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = start; i <= end; i++) {

                stringBuilder.append(s.charAt(i));

            }
            return stringBuilder.toString();
        }
        return "";
    }



    public boolean isPalindrome(int start, int end, String s) {
        int length = (end - start) + 1 ;
        if (length == 2) {
            return s.charAt(start) == s.charAt(end);
        }
        if (length == 3) {
            return s.charAt(start) == s.charAt(end);
        }


        int m = length % 2;
        boolean isPalindrome = true;
        if (m == 0) {

            int left = start;
            int right = end;
            w: while(left < right){

                if (s.charAt(left) != s.charAt(right)) {
                    isPalindrome = false;
                    break w;
                }
                left++;right--;
            }

        }else if(m == 1){
            int middle = length / 2 + start;

            int left = start;
            int right = end;
            w: while (left < middle && right > middle) {

                if (s.charAt(left) != s.charAt(right)) {
                    isPalindrome = false;
                    break w;
                }
                left++;right--;

            }

        }

        return isPalindrome;
    }

    @Test
    public void result() {
        System.out.println(longestPalindrome("bananas"));
    }

    @Test
    public void test() {
        String s = "abadddddd";
        char[] chars = s.toCharArray();
        System.out.println(s.length() % 2);
        int[] minAndMaxIndex = new int[2];
        int middle;
        if (s.length() % 2 == 0) {
            middle = s.length() / 2 -1;
        }else {
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
