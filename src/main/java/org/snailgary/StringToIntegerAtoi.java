package org.snailgary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 * </p>
 *
 * @author chandler
 * @since 2021/11/2
 */
public class StringToIntegerAtoi {

    public int myAtoi(String s) {
        char[] chars = s.toCharArray();

        boolean isNegative = false;
        boolean initNegative = false;
        boolean hasNumBefore = false;
        long result = 0;
        for (int i = 0; i < chars.length; i++) {

            char c = chars[i];

            if (c == ' ') {
                if (hasNumBefore || initNegative) {
                    break;
                }
                continue;
            }

            int digit = Character.digit(c, 10);
            if (i == 0 && (c != '-' && c != '+') && digit < 0) {
                return 0;
            }
            if (c == '+' && !initNegative) {
                initNegative = true;
                continue;
            } else if (c == '-' && !initNegative) {
                if (i > 0 && hasNumBefore) {
                    break;
                }
                isNegative = true;
                initNegative = true;
                continue;
            } else if (c == '.') {
                break;
            }

            if (digit < 0) {
                break;
            }


            if (result > Integer.MAX_VALUE / 10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            hasNumBefore = true;
            result *= 10;
            result += digit;


        }
        if (result > Integer.MAX_VALUE) {
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return (int) (isNegative ? -result : result);
    }

    static class Automaton {
        public int sign = 1;
        public long ans = 0;
        private String state = "start";
        private Map<String, String[]> table = new HashMap<String, String[]>() {{
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }};

        public void get(char c) {
            state = table.get(state)[get_col(c)];
            if ("in_number".equals(state)) {
                ans = ans * 10 + c - '0';
                ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
            } else if ("signed".equals(state)) {
                sign = c == '+' ? 1 : -1;
            }
        }

        private int get_col(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (Character.isDigit(c)) {
                return 2;
            }
            return 3;
        }
    }

    public static void main(String[] args) {
        StringToIntegerAtoi atoi = new StringToIntegerAtoi();
//        System.out.println(atoi.myAtoi("123"));
//        System.out.println(atoi.myAtoi("-123"));
//        System.out.println(atoi.myAtoi("-91283472332"));
//        System.out.println(atoi.myAtoi("21474836460"));
//        System.out.println(atoi.myAtoi("+12"));
//        System.out.println(atoi.myAtoi("00000-42a1234"));
//        System.out.println(atoi.myAtoi("4193 with words"));
//        System.out.println(atoi.myAtoi("2147483648"));
        System.out.println(atoi.myAtoi("  +  413"));
//         String str = "00000-42a1234";
//        // String str = "4193 with words";
//        Automaton automaton = new Automaton();
//        int length = str.length();
//        for (int i = 0; i < length; ++i) {
//            automaton.get(str.charAt(i));
//        }
//
//        System.out.println((int) (automaton.sign * automaton.ans));
    }

}
