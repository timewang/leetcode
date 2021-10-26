package org.snailgary;

public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        if (s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder().append(chars[0]);
        int middleCount = numRows - 2;// 中间有几行
        // 中间有一行，则中间要有独立一个折线
        // 两行则中间要有两个折线
        for (int i = 0; i < numRows; i++) {

        }
        return "";
    }

    /**
     * P1    A5    H9      N13
     * A2 P4 L6 S8 I10 I12 G14
     * Y3    I7    R11
     * @param args
     */
    /**
     * 1P      7I       13N
     * 2A   6L 8S   12I 14G
     * 3Y 5A   9H 11R
     * 4P     10I
     * @param args
     */
    public static void main(String[] args) {
        // 输入：PAYPALISHIRING
        // 输出：P1A5H9 N13 A2P4L6S8 I7I10G14 Y3I12R11
    }

}
