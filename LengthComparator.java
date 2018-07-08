package TreesAndGraphs;

import java.util.Comparator;

public class LengthComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		return ((Integer)o1.length()).compareTo(o2.length());
	}
}
