class CombinationIterator {
    int arr[] = null, sz, n;
    String str;
    public CombinationIterator(String chars, int cL) {
        sz = chars.length();
        n = cL;
        arr = new int[n];
        str = chars;
        this.reset();
    }

    private void reset() {
        for(int i=0; i<n; i++) arr[i] = i;
    }
    
    public String next() {
        if(!this.hasNext()) return null;

        String ans = "";
        for(int i=0; i<n; i++){
            // System.out.println(arr[i] + " " + str.charAt(arr[i]) + " " + str);
            ans += str.charAt(arr[i]);
        }

        // arr[n-1]++;
        if(arr[n-1] == sz-1){
            int j = n-2;
            while(j >= 0 && arr[j+1]-1 == arr[j]){
                j--;
            }

            // j++;
            if(j != -1){
                arr[j]++;
                j++;
                // if(j == 0){
                //     arr[0]++;
                //     j++;
                // }
                while(j < n){
                    arr[j] = arr[j-1]+1;
                    j++;
                }
            }
            else {
                arr[0] = -1;
            }
        }
        else {
            arr[n-1]++;
        }


        return ans;
    }
    
    public boolean hasNext() {
        return arr[0] != -1;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */