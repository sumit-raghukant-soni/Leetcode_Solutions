class Solution {
    public int idx;
    public String[] values;
    public boolean isValidSerialization(String preorder) {
        values = preorder.split(",");
        idx = 0;

        createTree();

        return idx == values.length;
    }

    public void createTree(){
        if(idx >= values.length || idx == Integer.MIN_VALUE) {
            idx = Integer.MIN_VALUE;
            return;
        }
        if(values[idx].equals("#")){ 
            idx++;
            return;
        }

        idx++;
        createTree();
        createTree();
    }
}