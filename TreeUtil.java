package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {
	public static ArrayList<Integer> copyBST(TreeNode node) {
		
		if(node==null)
			return null;
		
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<Integer> leftList = copyBST(node.left);
		ArrayList<Integer> rightList = copyBST(node.right);
		
		if(leftList!=null)
			arr.addAll(leftList);
		arr.add(node.val);
		if(rightList!=null)
			arr.addAll(rightList);
		return arr;
		
	}
	public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        if (input.length() == 0) {
            return null;
        }
    
        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
    
        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
	private static boolean isPallindrome(ArrayList<Integer> arr) {
		int mid = arr.size()/2;
		for(int i=0;i<mid;i++) {
			if(arr.get(i)!=arr.get(arr.size()-1-i))
				return false;
		}
		return true;
	}
	private static String serialize(TreeNode root, int level) {
    	if(root==null)
    		return"";
		StringBuffer sb = new StringBuffer();
		Queue<TreeNode> nodes = new LinkedList<>();
		nodes.add(root);
		while(!nodes.isEmpty()) {
			TreeNode thisNode = nodes.remove();
			sb.append(thisNode==null?"#":thisNode.val);
			sb.append(" ");
			if(thisNode!=null) {
			nodes.add(thisNode.left);
			nodes.add(thisNode.right);}
		}
		int i=sb.length()-1;
		while(sb.charAt(i)=='#'||sb.charAt(i)==' ') {
			sb.deleteCharAt(i);
			i--;
		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
    	
    	if(data==null||data.length()==0)
    		return null;
    	data=data.trim();
        String[] parts = data.split(" ");
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        nodes.add(root);
        int index = 1;
        while(!nodes.isEmpty()) {
        	TreeNode node = nodes.remove();
        	if(index== parts.length) break;
        	String item = parts[index++].trim();
        	if(!item.equals("#")) {
        		TreeNode left = new TreeNode(Integer.parseInt(item));
        		node.left=left;
        		nodes.add(node.left);
        	}
        	if(index== parts.length) break;
        	item = parts[index++].trim();
        	if(!item.equals("#")) {
        		TreeNode right = new TreeNode(Integer.parseInt(item));
        		node.right=right;
        		nodes.add(node.right);
        	}
        }
        return root;
    }
}
