package cracking.treeAndgraph;

public class 최소트리 {


    TreeNode solution(int[] arr) {
        return createMinimalBST(arr, 0, arr.length - 1);
    }

    private TreeNode createMinimalBST(int[] arr, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (end - start) / 2;
        TreeNode t = new TreeNode(arr[mid]);
        t.left = createMinimalBST(arr, start, mid - 1);
        t.right = createMinimalBST(arr, mid + 1, end);
        return t;
    }


}
