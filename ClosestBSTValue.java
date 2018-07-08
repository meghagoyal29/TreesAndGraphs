package TreesAndGraphs;

public class ClosestBSTValue {
	public static void main(String[] args) {
		String input = "4,2,5,1,3";
		TreeNode root = TreeUtil.stringToTreeNode(input);
		System.out.println(closestValue(root,3.1));
	}
	public static int closestValue(TreeNode root, double target) {
		Double minDiff = null;
		int answer = searchBST(root,target,minDiff);
		return answer;

	}
	private static Integer searchBST(TreeNode root, double target, Double minDiff) {
		if(root==null) 
			return null;
		Integer retVal=null;
		double diff = Math.abs(target-root.val);
		if(minDiff==null||diff<minDiff) {
			minDiff = diff;
		}
		if(target==(double)root.val) {
			return root.val;
		}else if(target<(double)root.val) {
		retVal = searchBST(root.left,target,minDiff);
		}else
			retVal = searchBST(root.right,target,minDiff);
		Double retDiff;
		if(retVal!=null) {
		retDiff = Math.abs(retVal-target);
		if(retDiff!=null) {
			if(retDiff<diff) {
				return retVal;
			}else return root.val;
		}
		
	}
		return root.val;
}
}
