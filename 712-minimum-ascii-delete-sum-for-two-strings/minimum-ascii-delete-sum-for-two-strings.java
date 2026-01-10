class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int sz1 = s1.length(), sz2 = s2.length();
        int arr[][] = new int[sz1][sz2], ans = 0;

        for(int i=0; i<sz1; i++){
            for(int j=0; j<sz2; j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    arr[i][j] = s1.charAt(i) + (i-1 >= 0 && j-1 >= 0 ? arr[i-1][j-1] : 0);
                }
                else{
                    arr[i][j] = Math.max( (i-1 >= 0 ? arr[i-1][j] : 0), (j-1 >= 0 ? arr[i][j-1] : 0) );
                }
            }
        }

        // for(int i=0; i<sz1; i++){
        //     for(int j=0; j<sz2; j++){
        //         System.out.print(arr[i][j] + ",");
        //     }
        //     System.out.println();
        // }

        for(char ch : s1.toCharArray()){
            ans += ch;
        }
        for(char ch : s2.toCharArray()){
            ans += ch;
        }

        return ans - 2 * arr[sz1-1][sz2-1];
    }
}