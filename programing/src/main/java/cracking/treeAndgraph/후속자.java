package cracking.treeAndgraph;

public class 후속자 {
    TreeNode inorderSucc(TreeNode root) {
        if (root == null) return null;
        if (root.right != null) {
            return findRightChild(root.right);
        } else {
            TreeNode cur = root;
            TreeNode par = root.parent;

            while (par != null && par.left != cur) {
                cur = par;
                par = par.parent;
            }

            return par;
        }
    }

    private TreeNode findRightChild(TreeNode right) {
        TreeNode ret = right;

        while (ret.left != null) {
            ret = ret.left;
        }

        return ret;

    }

    class TreeNode {
        int val;
        TreeNode left, right, parent;

    }

}
