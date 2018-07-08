package TreesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {

	public static void main(String[] args) {
		String[] words = {"wrt","wrf","er","ett","rftt"};
		//String[] words = {"zx","zy"};
		//String[] words = {"aac","aabb","aaba"};

		System.out.println(alienOrder(words));
	}

	public static String alienOrder(String[] words) {
		LinkedHashMap<String,LinkedList<Character>> dictionaryOrder = new LinkedHashMap<>();
		StringBuffer finalOrder = new StringBuffer();
		for(String s: words) {
			for(int charIndex = 0;charIndex<s.length();charIndex++) {
				String prefix = charIndex==0?"":s.substring(0, charIndex);
				Character linkedChar = s.charAt(charIndex);
				dictionaryOrder.putIfAbsent(prefix, new LinkedList<Character>());
				LinkedList<Character> orderForPrefix = dictionaryOrder.get(prefix);
				if(orderForPrefix.contains(linkedChar)&&(orderForPrefix.indexOf(linkedChar)<orderForPrefix.size()-1)) {
					return "";
				}else {
					if(orderForPrefix.indexOf(linkedChar)==-1)
						orderForPrefix.add(linkedChar);
				}
			}
		}
		
		System.out.println(dictionaryOrder);
		String selectedKey = null;
		LinkedList<Character> randomList=null;
		for(String key:dictionaryOrder.keySet()) {
			if(dictionaryOrder.get(key).size()>1) {
				selectedKey=key;
				randomList=dictionaryOrder.get(key);
			}
		}
		
		for(String key: dictionaryOrder.keySet()) {
			if(!key.equals(selectedKey)) {
				LinkedList<Character> thisList = dictionaryOrder.get(key);
				if(thisList.size()<=1) {
					continue;
				}
				for(int indexInCurrentList = 1;indexInCurrentList<=thisList.size()-1;indexInCurrentList++) {
					Character previousChar = thisList.get(indexInCurrentList-1);
					Character currentChar = thisList.get(indexInCurrentList);
					Character nextChar = thisList.size()>indexInCurrentList+1?thisList.get(indexInCurrentList+1):null;
					int previousCharIndex = randomList.indexOf(previousChar);
					int currentCharIndex = randomList.indexOf(currentChar);
					int nextCharIndex = Integer.MIN_VALUE;
					if(nextChar!=null)
					nextCharIndex = randomList.indexOf(nextChar);
					if(previousCharIndex<currentCharIndex&& currentCharIndex<nextCharIndex)
						continue;
					if(previousCharIndex>-1&&currentCharIndex>-1&&nextChar!=null&&nextCharIndex>1) {
						if(!(previousCharIndex<currentCharIndex&& currentCharIndex<nextCharIndex))
							return"";
					}else if(previousCharIndex>-1&&currentCharIndex==-1){
						randomList.add(previousCharIndex+1,currentChar);
						currentCharIndex++;
						if(nextChar!=null)
						randomList.add(currentCharIndex+1,nextChar);
					}else if(previousCharIndex==-1&&currentCharIndex>-1) {
						randomList.add(currentCharIndex,previousChar);
						previousCharIndex=currentCharIndex;
						currentCharIndex++;
						if(nextChar!=null)
						randomList.add(currentCharIndex+1,nextChar);
					}else if(previousCharIndex==-1&&currentCharIndex==-1&&nextChar!=null&&nextCharIndex>-1) {
						randomList.add(nextCharIndex,previousChar);
						randomList.add(nextCharIndex+1,nextChar);
					}else {
						randomList.add(previousChar);
						randomList.add(currentChar);
						randomList.add(nextChar);
					}
				}
			}
		}
		for(LinkedList<Character> thisList:dictionaryOrder.values()) {
			if(thisList.size()==1&&(randomList.indexOf(thisList.getFirst())==-1)) {
				randomList.add(thisList.getFirst());
			}
		}
		return randomList.toString();
	}
}

