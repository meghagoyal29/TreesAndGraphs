package TreesAndGraphs;

import java.util.ArrayList;

public class TwoSumBST {
	public static void main(String[] args) {
		String input = "2,1,3";
		int k = 3;
		TreeNode root = TreeUtil.stringToTreeNode(input);
		System.out.println(findTarget(root,k));
	}
	 public static boolean findTarget(TreeNode root, int k) {
		ArrayList<Integer> nums = TreeUtil.copyBST(root);
		Integer[] numsArr = nums.toArray(new Integer[nums.size()]);
		int left = 0; 
		int right = numsArr.length-1;
		while(left<right && left>=0 && right<numsArr.length) {
			if(numsArr[left]+numsArr[right]==k) {
				return true;
			}else if(numsArr[left]+numsArr[right]<k)
				left++;
			else right--;
		}
		return false;
	        
	    }
}
