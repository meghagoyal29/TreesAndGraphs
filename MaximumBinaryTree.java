package TreesAndGraphs;

import java.util.ArrayList;

public class MaximumBinaryTree {

	public static void main(String args[]) {
		int[] arr = {3,2,1,6,0,5};
		TreeNode ans= constructMaximumBinaryTree(arr, 0,arr.length-1) ;
		ArrayList<Integer> ansList = TreeUtil.copyBST(ans);
		for(Integer i : ansList) {
			System.out.print(i+" ");
		}
	}
	public static TreeNode constructMaximumBinaryTree(int[] nums, int left,int right) {
		if(left>right)
			return null;
		int part = maxIndex(nums,left,right);
		System.out.println("part: "+part+"left: "+left+"right: "+right);
		TreeNode root = new TreeNode(nums[part]);
		root.left=(part==0)?null:constructMaximumBinaryTree(nums,left,part-1);
		root.right=(part==nums.length-1)?null:constructMaximumBinaryTree(nums, part+1, right);
		return root;
	}

	private static int maxIndex(int[] nums, int left, int right) {
		
		int max = Integer.MIN_VALUE;
		int returnValue = -1;
		for(int i=left;i<=right;i++) {
			if(nums[i]>max) {
				max = nums[i];
				returnValue = i;
			}
		}
		return returnValue;
	}
	
}
