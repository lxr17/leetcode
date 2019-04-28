package com.lxr.leetcode;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern
 * on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * <p>
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * eg.
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ZigZagConversion {

    /**
     * 27ms    31.14% Run time
     * 43.8 MB 5.02% Memory
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int columnNum = s.length() / 2 + 1;
        Character[][] arr = new Character[numRows][columnNum];

        StringBuilder stringBuilder = new StringBuilder();

        int lastX = 0;
        int lastY = 0;
        for (int i = 0; i < s.length(); i++) {
            if (lastY % (numRows - 1) == 0 && lastX < numRows - 1) {
                arr[lastX][lastY] = s.charAt(i);
                lastX++;
            } else {
                arr[lastX][lastY] = s.charAt(i);
                lastY++;
                lastX--;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != null) {
                    stringBuilder.append(arr[i][j]);
                }
            }
        }

        return stringBuilder.toString();
    }

    /**
     * print the array
     *
     * @param arr
     */
    private void print(Character[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(arr[i][j]);
                }
            }
            System.out.println();
        }
    }

}
