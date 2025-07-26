class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        int level = -1, l2 = label;
        while(l2 > 0){
            l2 >>= 1;
            level++;
        }
        // System.out.println(label + " " + level);
        List<Integer> lst = new ArrayList<>();
        if(level > 0){
            int pos = label/2;
            if((level&1) == 0){
                int tmp = label - (int) Math.pow(2, level);
                tmp = (int) Math.pow(2, level)-1 - tmp;
                // System.out.println("tmp " + tmp);
                pos = (int) Math.pow(2, level-1) + tmp/2;
            }
            else{
                int tmp = (int) Math.pow(2, level+1)-1 - label;
                // System.out.println("tmp " + tmp);
                pos = (int) Math.pow(2, level-1) + tmp/2;
            }
            
            // System.out.println(pos);
            lst = pathInZigZagTree(pos);
        } 

        lst.add(label);
        return lst;
    }
}