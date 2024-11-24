class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        long ans = 0;
        Multiset st = new Multiset();

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                st.add(matrix[i][j]);
                ans += Math.abs(matrix[i][j]);
            }
        }

        TreeMap<Integer, Integer> mpn = st.mpn, mpp = st.mpp;
        while(mpn.size() > 0){
            int key = mpn.firstKey(), value = mpn.get(key)%2;
            mpn.remove(key);

            if(value > 0){
                if(mpn.size() >= 1){
                    int key2 = mpn.firstKey();
                    // System.out.println("removed another one" + key2);
                    if((mpn.get(key2)%2) == 1) mpn.remove(key2);
                    else mpn.put(key2, mpn.get(key2)-1);
                }
                else if(mpp.size() > 0 && mpp.firstKey() < Math.abs(key)){
                    int key2 = mpp.firstKey();
                    // System.out.println("removed positive one" + key2);
                    if(mpp.get(key2) > 1) mpp.put(key2, mpp.get(key2)-1);
                    else mpp.remove(key2);
                    ans -= key2*2;
                }
                else{
                    mpn.put(key, value);
                    break;
                }
            }
        }

        while(mpn.size() > 0){
            int key = mpn.firstKey(), value = mpn.get(key);
            ans += key * value*2;
            mpn.remove(key);
        }

        return ans;
    }
}

class Multiset{
    public TreeMap<Integer, Integer> mpp, mpn;

    public Multiset(){
        mpp = new TreeMap<>();
        mpn = new TreeMap<>();
    } 

    public void add(Integer key){
        if(key >= 0){
            mpp.put(key, mpp.getOrDefault(key, 0) + 1);
        }
        else{
            mpn.put(key, mpn.getOrDefault(key, 0) + 1);
        }
    }

    public void remove(Integer key){
        if(key > 0 && mpp.containsKey(key)){
            int freq = mpp.get(key);
            if(freq > 1){
                mpp.put(key, freq-1);
            }
            else mpp.remove(key);
        }
        else if(mpn.containsKey(key)){
            int freq = mpn.get(key);
            if(freq > 1){
                mpn.put(key, freq-1);
            }
            else mpn.remove(key);
        }
    }

    public boolean containsKey(Integer key){
        if(key <= 0) return mpn.containsKey(key);
        return mpp.containsKey(key);
    }

    public String toString(){
        List<Integer> resultp = new ArrayList<>(), resultn = new ArrayList<>();
        for (var entry : mpp.entrySet()) {
            resultp.addAll(Collections.nCopies(entry.getValue(), entry.getKey()));
        }
        for (var entry : mpn.entrySet()) {
            resultn.addAll(Collections.nCopies(entry.getValue(), entry.getKey()));
        }
        return resultp.toString() + "\n" + resultn.toString();
    }

    public Integer sizep(){
        return mpp.values().stream().mapToInt(Integer::intValue).sum();
    }

    public Integer sizen(){
        return mpn.values().stream().mapToInt(Integer::intValue).sum();
    }
}