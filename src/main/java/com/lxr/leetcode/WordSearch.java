package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * eg.
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * <p>
 * Constraints:
 * <p>
 * board and word consists only of lowercase and uppercase English letters.
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class WordSearch {

    /**
     * 因为这个相当于是把所有的路都找出来了，所以时间复杂度过高，故舍弃
     */
    public boolean exist(char[][] board, String word) {
        // 存放着所有的符合条件的word[0:i]子串路径坐标
        // 本来想只存放最后字符坐标的，但是题目要求同一个坐标不能重复使用，所以必须得把整个路径存下来
        List<List<Coordinate>> paths = new ArrayList<>();
        // 中间变量
        List<List<Coordinate>> temp = new ArrayList<>();

        if (word.length() == 0) {
            return true;
        }

        if (board.length == 0) {
            return false;
        }

        // 首先找第一个字符
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    Coordinate coordinate = new Coordinate(i, j);
                    List<Coordinate> path = new ArrayList<>();
                    path.add(coordinate);
                    paths.add(path);
                }
            }
        }

        // 索引
        int index = 1;

        // 找剩下的字符
        while (index < word.length()) {
            temp.clear();

            for (List<Coordinate> path : paths) {
                // 末尾字符坐标
                Coordinate coordinate = path.get(path.size() - 1);

                // 上
                if (coordinate.x > 0 && word.charAt(index) == board[coordinate.x - 1][coordinate.y]) {
                    Coordinate curr = new Coordinate(coordinate.x - 1, coordinate.y);

                    if (!path.contains(curr)) {
                        List<Coordinate> newPath = new ArrayList<>(path);
                        newPath.add(curr);

                        temp.add(newPath);
                    }
                }

                // 下
                if (coordinate.x < board.length - 1 && word.charAt(index) == board[coordinate.x + 1][coordinate.y]) {
                    Coordinate curr = new Coordinate(coordinate.x + 1, coordinate.y);

                    if (!path.contains(curr)) {
                        List<Coordinate> newPath = new ArrayList<>(path);
                        newPath.add(curr);

                        temp.add(newPath);
                    }
                }

                // 左
                if (coordinate.y > 0 && word.charAt(index) == board[coordinate.x][coordinate.y - 1]) {
                    Coordinate curr = new Coordinate(coordinate.x, coordinate.y - 1);

                    if (!path.contains(curr)) {
                        List<Coordinate> newPath = new ArrayList<>(path);
                        newPath.add(curr);

                        temp.add(newPath);
                    }
                }

                // 右
                if (coordinate.y < board[0].length - 1 && word.charAt(index) == board[coordinate.x][coordinate.y + 1]) {
                    Coordinate curr = new Coordinate(coordinate.x, coordinate.y + 1);

                    if (!path.contains(curr)) {
                        List<Coordinate> newPath = new ArrayList<>(path);
                        newPath.add(curr);

                        temp.add(newPath);
                    }
                }
            }

            paths.clear();
            paths.addAll(temp);

            index++;
        }

        if (paths.size() > 0) {
            return true;
        }

        return false;
    }

    /**
     * 定义该类是为了方便起见，主要目的是为了可以使用List的contains方法
     */
    class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    /**
     * 21ms     17.76% Run time
     * 54.7MB   6.83% Memory
     */
    public boolean exist2(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        }

        if (board.length == 0) {
            return false;
        }

        // 用于判断路径是否重复的二维数组（默认每个元素都是0）
        int[][] pathFill;

        // 第一个坐标
        List<Node> firstNodeList = new ArrayList<>();

        // 找到所有的第一个坐标
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    Node node = new Node(i, j);
                    firstNodeList.add(node);
                }
            }
        }

        // 当word长度只有1的情况下
        if (word.length() == 1 && firstNodeList.size() > 0) {
            return true;
        }

        for (Node firstNode : firstNodeList) {
            pathFill = new int[board.length][board[0].length];
            pathFill[firstNode.x][firstNode.y] = 1;

            int index = 1;
            Node curNode = firstNode;

            while (index < word.length()) {
                if (curNode.children.size() == 0) {
                    // 找到所有的第index节点
                    // 上
                    if (curNode.x > 0 && word.charAt(index) == board[curNode.x - 1][curNode.y]
                            && pathFill[curNode.x - 1][curNode.y] == 0) {
                        Node curr = new Node(curNode.x - 1, curNode.y);
                        curr.parent = curNode;

                        curNode.children.add(curr);
                    }

                    // 下
                    if (curNode.x < board.length - 1 && word.charAt(index) == board[curNode.x + 1][curNode.y]
                            && pathFill[curNode.x + 1][curNode.y] == 0) {
                        Node curr = new Node(curNode.x + 1, curNode.y);
                        curr.parent = curNode;

                        curNode.children.add(curr);
                    }

                    // 左
                    if (curNode.y > 0 && word.charAt(index) == board[curNode.x][curNode.y - 1]
                            && pathFill[curNode.x][curNode.y - 1] == 0) {
                        Node curr = new Node(curNode.x, curNode.y - 1);
                        curr.parent = curNode;

                        curNode.children.add(curr);
                    }

                    // 右
                    if (curNode.y < board[0].length - 1 && word.charAt(index) == board[curNode.x][curNode.y + 1]
                            && pathFill[curNode.x][curNode.y + 1] == 0) {
                        Node curr = new Node(curNode.x, curNode.y + 1);
                        curr.parent = curNode;

                        curNode.children.add(curr);
                    }
                }

                // 找到了符合条件的一个路径
                if (curNode.children.size() > 0 && index == word.length() - 1) {
                    return true;
                }

                // 如果index节点没有找到或者已经遍历完了
                if (curNode.children.size() == 0 || curNode.curIndex == curNode.children.size()) {
                    if (curNode.parent == null) {
                        break;
                    } else {
                        pathFill[curNode.x][curNode.y] = 0;

                        index--;
                        curNode = curNode.parent;
                        curNode.curIndex++;
                    }
                } else {
                    // 如果index节点存在且没有遍历完
                    curNode = curNode.children.get(curNode.curIndex);
                    index++;

                    pathFill[curNode.x][curNode.y] = 1;
                }
            }
        }

        return false;
    }

    /**
     * 路径坐标（类似于双向链表）
     */
    class Node {
        // 该点坐标
        int x;
        int y;

        // 父节点
        Node parent;

        // 下一个点的坐标（由于有多种可能性，故用集合）
        List<Node> children = new ArrayList<>();

        // 当前遍历到的孩子索引
        int curIndex = 0;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
