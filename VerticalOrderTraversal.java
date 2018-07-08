package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class VerticalOrderTraversal {
	public static void main(String[] args) {
		String input = "3,9,8,4,0,1,7,null,null,null,2,5";
		TreeNode root = TreeUtil.stringToTreeNode(input);
		List<List<Integer>> levelOrder = verticalOrder(root);
		System.out.println(levelOrder);
	}
	
	public static List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> finalArrays = new ArrayList<>();
		fillPerColumn(root,finalArrays,0,minCol(root));
		return finalArrays;
	}

	private static int minCol(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int minForLevel = 0;
		TreeNode head = root;
		while(root!=null && root.left!=null) {
				root=root.left;
				minForLevel++;	
		}
		int ans = Math.max(Math.max((minCol(head.left))+1,(minCol(head.right)-1)),minForLevel);
		return ans;
	}
	private static void fillPerColumn(TreeNode root, List<List<Integer>> finalArrays,int column,int minLeftCol) {
		if(root==null) {
			return;
		}
		int actualColumn = column+minLeftCol-1;
		if(finalArrays.size()<=actualColumn) {
			int size = finalArrays.size();
			for(int i=0;i<=actualColumn-size;i++) {
			ArrayList<Integer> thisLevelList = new ArrayList<>();
			finalArrays.add(thisLevelList);
			}
		}
		List<Integer> thisLevel = finalArrays.get(actualColumn);
		thisLevel.add(root.val);
		fillPerColumn(root.left,finalArrays,column-1,minLeftCol);
		fillPerColumn(root.right,finalArrays,column+1,minLeftCol);
		
	}
}
