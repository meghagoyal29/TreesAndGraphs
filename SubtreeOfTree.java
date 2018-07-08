package TreesAndGraphs;

public class SubtreeOfTree {
	
	public static void main(String[] args) {
		String input1 = "3,4,5,1,2";
		String input2 = "4,1,2";
		TreeNode s = TreeUtil.stringToTreeNode(input1);
		TreeNode t = TreeUtil.stringToTreeNode(input2);
		System.out.println(isSubtree(s,t));
	}
	public static boolean isSubtree(TreeNode s, TreeNode t) {
		if(t==null)
			return true;
		if(s==null)
			return false;
		if(s.val==t.val && matchTree(s,t))
		return true;
		else return (isSubtree(s.left,t) || isSubtree(s.right, t));
	}
	private static boolean matchTree(TreeNode s, TreeNode t) {
		if(s==null&&t==null)
			return true;
		else if(s==null||t==null)
			return false;
		else if(s.val!=t.val)
			return false;
		else return (matchTree(s.left, t.left)&&matchTree(s.right,t.right));
		
	}
	
}
