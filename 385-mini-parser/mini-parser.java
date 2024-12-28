/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * // Constructor initializes an empty nested list.
 * public NestedInteger();
 *
 * // Constructor initializes a single integer.
 * public NestedInteger(int value);
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list.
 * public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // Set this NestedInteger to hold a single integer.
 * public void setInteger(int value);
 *
 * // Set this NestedInteger to hold a nested list and adds a nested integer to
 * it.
 * public void add(NestedInteger ni);
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
class Solution {
    int i = 0;

    public NestedInteger deserialize(String s) {
        int len = s.length();

        return solve(s, len);
    }

    private NestedInteger solve(String s, int len) {
        // System.out.println(i);
        if (i == len)
            return null;

        NestedInteger root = new NestedInteger();

        if (s.charAt(i) == '[') {
            // System.out.println("List Created");
            while (i < len && s.charAt(i) != ']') {
                i++;
                if(s.charAt(i) == ']') {
                    i++;
                    return root;
                }
                NestedInteger child = solve(s, len);
                // System.out.println("Back to list" + i);
                root.add(child);
            }
            i++;
        } else {
            // System.out.println("Integer Added");
            String val = "";
            int j = i;
            for (; j < len && (s.charAt(j) == '-' || (s.charAt(j) >= '0' && s.charAt(j) <= '9')); j++) {
                val += s.charAt(j);
            }
            root.setInteger(Integer.parseInt(val));
            i = j;
        }

        return root;
    }
}