package TreesAndGraphs;

import java.util.ArrayList;

public class RootToLeafNumbers {
	public static void main(String [] args) {
		String input = "2,0,0";
		TreeNode root = TreeUtil.stringToTreeNode(input);
		System.out.println(sumNumbers(root));
	}
	 public static int sumNumbers(TreeNode root) {
	  Integer sum = 0;
	  ArrayList<String> nums = getFullNums(root);
	  for(String num:nums) {
		  sum+=Integer.parseInt(num);
	  }
	  return sum;
	    }
	 static ArrayList<String>getFullNums(TreeNode root){
		 ArrayList<String> nums = new ArrayList<>();
		 if(root==null) {
			 return nums;
		 }
		 ArrayList<String> numsAfter = new ArrayList<>();
		 numsAfter.addAll(getFullNums(root.left));
		 numsAfter.addAll(getFullNums(root.right));
		 if(numsAfter.size()==0) {
			 numsAfter.add("");
		 }
		 for(String num:numsAfter) {
			 nums.add(root.val+num);
		 }
		 return nums;
	 }
	 public static int sumNumbersMath(TreeNode root, int steps) {
		  return sum(root,0);
		    }
	 public static int sum(TreeNode root, int sum) {
		    if (root == null) return 0;    
		    if (root.left == null && root.right == null) return 10*sum + root.val;
		    return sum(root.left, 10*sum + root.val) + sum(root.right, 10*sum + root.val);
		  }
}
