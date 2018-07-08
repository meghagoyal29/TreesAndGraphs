package TreesAndGraphs;

public class SymetricTree {
	int index = 0;
	static int size = 0;
	public static void main(String[] args) {
		String input = "1,2,2,3,4,4,3";
		size = input.length();
		TreeNode node = TreeUtil.stringToTreeNode("5,4,1,null,1,null,4,2,null,2,null");
		System.out.println(isSymmetric(node));
	}
	 public static boolean isSymmetric(TreeNode root) {
		 
		 if(root==null )
			 return true;
		 if(root.left!=null&&root.right!=null) {
		 if(root.left.val==root.right.val) {
			 return (isSymmetric(root.left.left,root.right.right)&&isSymmetric(root.left.right, root.right.left));
		 }
			}
		return false;
	 }
	 
	 public static boolean isSymmetric(TreeNode left, TreeNode right) {
		 if(!((left==null&&right==null) ||(left!=null&&right!=null)))
			 return false;
		 if(left!=null&&right!=null&&left.val!=right.val) {
			 return false;
		 }
		 else if(left!=null&&right!=null)
			 return(isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left));
		 
		 return true;
	 }
}
