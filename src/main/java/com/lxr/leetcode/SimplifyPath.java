package com.lxr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 * <p>
 * In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level.
 * <p>
 * Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.
 * <p>
 * eg1.
 * Input: "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 * <p>
 * eg2.
 * Input: "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 * <p>
 * eg3.
 * Input: "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 * <p>
 * eg4.
 * Input: "/a/./b/../../c/"
 * Output: "/c"
 * <p>
 * eg5.
 * Input: "/a/../../b/../c//.//"
 * Output: "/c"
 * <p>
 * eg6.
 * Input: "/a//b////c/d//././/.."
 * Output: "/a/b/c"
 */
public class SimplifyPath {

    /**
     * 6ms     46.92% Run time
     * 40.9MB  13.48% Memory
     */
    public String simplifyPath(String path) {
        List<String> simplifyList = new ArrayList<>();

        // 先进行拆分
        String[] splits = path.split("/");

        // 然后精简
        for (String str : splits) {
            switch (str) {
                case "":
                case ".":
                    break;
                case "..":
                    if (simplifyList.size() > 0) {
                        simplifyList.remove(simplifyList.size() - 1);
                    }
                    break;
                default:
                    simplifyList.add(str);
                    break;
            }
        }

        // 最后合并
        StringBuilder builder = new StringBuilder();
        for (String str : simplifyList) {
            builder.append("/").append(str);
        }

        if (builder.length() == 0) {
            return "/";
        } else {
            return builder.toString();
        }
    }

}
