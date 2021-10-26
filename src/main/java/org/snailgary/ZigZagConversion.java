package org.snailgary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/zigzag-conversion/
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == numRows) {
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int middleCount = numRows - 2;// 中间有几行
        // 中间有一行，则中间要有独立一个折线
        // 两行则中间要有两个折线
        // Map<Integer, List<Character>> rows = new HashMap<>(numRows);
        // int maxLastIndex = 0;
        int middle = numRows / 2;
        int celNo = chars.length / numRows;
        List<Integer> lastIndex = new ArrayList<>(chars.length);
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {

                int dataIndex = 0;
                while (dataIndex < chars.length) {
                    lastIndex.add(dataIndex);
                    stringBuilder.append(chars[dataIndex]);
                    dataIndex += numRows + middleCount;
                }
            } else if (i == numRows - 1) {

                int dataIndex = numRows - 1;

                while (dataIndex < chars.length) {
                    lastIndex.add(dataIndex);
                    stringBuilder.append(chars[dataIndex]);
                    dataIndex += numRows + middleCount;
                }

            } else {

                if (middleCount == 1) {

                    int dataIndex = i;

                    while (dataIndex < chars.length) {
                        lastIndex.add(dataIndex);
                        stringBuilder.append(chars[dataIndex]);

                        dataIndex += 2;

                    }

                } else if (numRows == 4) {
                    //PINALSIGYAHRPI
                    int dataIndex = i;
                    int span = 2;
                    int spanDown = 1;
                    while (dataIndex < chars.length) {
                        if (!lastIndex.contains(dataIndex)) {
                            stringBuilder.append(chars[dataIndex]);
                        }

                        lastIndex.add(dataIndex);

                        if ((i + 1) <= middle) {
                            //  跨过的数量从 2 开始
                            if (span == 2) {
                                dataIndex += middleCount * 2;
                                span = 1;
                            } else {
                                dataIndex += middleCount;
                                span = 2;
                            }
                        } else {
                            if (spanDown == 2) {
                                dataIndex += middleCount * 2;
                                span = 1;
                            } else {
                                dataIndex += middleCount;
                                span = 2;
                            }
                        }

                    }

                }


            }
        }
        // PAHN YPLIHIIN YIR
        // PAHN APLSIIG  YIR
        return stringBuilder.toString();
    }

    public String convert2(String s, int numRows) {
        if (numRows == 1){
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }


        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            if (goingDown) {
                curRow += 1;
            }else {
                curRow += -1;
            }
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows){
            ret.append(row);
        }
        return ret.toString();
    }

    /**
     * 第i行  P1    A5    H9      N13
     * 第二行 A2 P4 L6 S8 I10 I12 G14
     * 第三行 Y3    I7    R11
     * @param args
     */
    /**
     * 1P      7I        13N
     * 2A 4 6L 8S 10 12I 14G
     * 3Y 5A 7 9H 11R
     * 4P     10I
     *
     * @param args
     */
    public static void main(String[] args) {
        // 输入：PAYPALISHIRING
        // 输出：P1A5H9 N13 A2P4L6S8 I7I10G14 Y3I12R11
        ZigZagConversion conversion = new ZigZagConversion();
        System.out.println(conversion.convert("PAYPALISHIRING", 3));
        System.out.println(conversion.convert("PAYPALISHIRING", 4));
        System.out.println(conversion.convert("ABCDEF", 5)); // "ABCDFE"
        // PAHNAPLSIIGYIR
    }

}
