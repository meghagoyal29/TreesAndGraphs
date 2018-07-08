package TreesAndGraphs;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
public class ValidateTree {

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left=new TreeNode(1);
		
		System.out.println(isValidBST(root,null,null));
	}

	public static boolean isValidBST(TreeNode root, Integer min, Integer max) {

		if(root==null)
			return true;
		if((min!= null && root.val<=min) ||(max!=null && root.val>=max))
			return false;
			if(isValidBST(root.left, min, root.val) && isValidBST(root.right,root.val,max )) 
				return true;

		return false;

	}
}
