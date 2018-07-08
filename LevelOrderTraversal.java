package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {
	public static void main(String[] args) {
		String input = "3,9,20,null,null,15,7";
		TreeNode root = TreeUtil.stringToTreeNode(input);
		List<List<Integer>> levelOrder = levelOrder(root);
		System.out.println(levelOrder);
	}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> finalArrays = new ArrayList<>();
		fillPerLevel(root,finalArrays,0);
		return finalArrays;
	}

	private static void fillPerLevel(TreeNode root, List<List<Integer>> finalArrays,int level) {
		if(root==null) {
			return;
		}
		if(finalArrays.size()<=level) {
			ArrayList<Integer> thisLevelList = new ArrayList<>();
			finalArrays.add(level,thisLevelList);
		}
		List<Integer> thisLevel = finalArrays.get(level);
		thisLevel.add(root.val);
		fillPerLevel(root.left,finalArrays,level+1);
		fillPerLevel(root.right,finalArrays,level+1);
	}
}
