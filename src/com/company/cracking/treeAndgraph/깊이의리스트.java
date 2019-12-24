package com.company.cracking.treeAndgraph;

import java.util.ArrayList;
import java.util.List;

public class 깊이의리스트 {

    //  pre-order traversal
    List<List<TreeNode>> solution1(TreeNode root) {

        List<List<TreeNode>> ret = new ArrayList<>();
        createLinkedList(root, ret, 0);
        return ret;
    }

    private void createLinkedList(TreeNode root, List<List<TreeNode>> ret, int level) {
        if (root == null) return;

        List<TreeNode> list = null;

        if (ret.size() == level) {
            list = new ArrayList<>();
        } else {
            list = ret.get(level);
        }

        list.add(root);

        createLinkedList(root.left, ret, level + 1);
        createLinkedList(root.right, ret, level + 1);
    }

    // 너비 우선 탐색으로 구현
    List<List<TreeNode>> solution2(TreeNode root) {
        List<List<TreeNode>> ret = new ArrayList<>();

        List<TreeNode> cur = new ArrayList<>();
        if (root != null) {
            cur.add(root);
        }

        while (cur.size() > 0) {
            ret.add(cur);
            List<TreeNode> temp = cur;
            cur = new ArrayList<>();
            for (TreeNode t : temp) {
                if (t.left != null) cur.add(t.left);
                if (t.right != null) cur.add(t.right);
            }
        }
        return ret;
    }
}
