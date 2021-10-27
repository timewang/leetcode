package org.snailgary;

/**
 * <p>
 * </p>
 *
 * @author chandler
 * @since 2021/10/26
 */

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 */
public class ReverseInteger {

    public int reverse(int x) {
        String s = x + "";
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        if (x < 0) {
            stringBuilder.append("-");
        }
        for (int i = chars.length - 1; i >=0 ; i--) {
            if (x < 0 && i == 0) {
                break;
            }
            stringBuilder.append(chars[i]);
        }
        try {
            return Integer.valueOf(stringBuilder.toString());
        } catch (NumberFormatException e) {
            // e.printStackTrace();
            return 0;
        }
    }

    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

}
