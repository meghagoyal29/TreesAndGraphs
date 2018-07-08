package TreesAndGraphs;

public class inOrderSuccessorInBST {
	
	public static void main(String[] args) {
		String input = "6,2,8,0,4,7,9,null,null,3,5"; 
		String input1 = "41,37,44,24,39,42,48,1,35,38,40,null,43,46,49,0,2,30,36,null,null,null,null,null,null,45,47,null,null,null,null,null,4,29,32,null,null,null,null,null,null,3,9,26,null,31,34,null,null,7,11,25,27,null,null,33,null,6,8,10,16,null,null,null,28,null,null,5,null,null,null,null,null,15,19,null,null,null,null,12,null,18,20,null,13,17,null,null,22,null,14,null,null,21,23";
		String input3 = "2,null,3";
		TreeNode root = TreeUtil.stringToTreeNode(input3);
		TreeNode p = new TreeNode(40);
		System.out.println(inorderSuccessor(root,p,null,null).val);
	}
	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p, TreeNode parent, TreeNode grandParent) {
		if(root==null||p==null) {
			return null;
		}
		if(p.val==root.val) {
			if(root.right!=null) {
				return findLeftMostChild(root.right);
			}else if(parent!=null && parent.left!=null && root.val == parent.left.val)
				return parent;
			else {
				return grandParent;
			}
		}else if(p.val<root.val) {
			return inorderSuccessor(root.left, p, root, parent);
		}
		else return inorderSuccessor(root.right, p, root, (parent!=null && parent.left!=null&& root.val==parent.left.val)?parent:grandParent);

	}
	private static TreeNode findLeftMostChild(TreeNode node) {
		while(node!=null&&node.left!=null)
			node=node.left;
		return node;
	}
}
