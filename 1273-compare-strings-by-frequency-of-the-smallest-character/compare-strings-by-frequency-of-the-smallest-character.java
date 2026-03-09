class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int sz1 = queries.length, sz2 = words.length;
        int ans[] = new int[sz1], fq[] = new int[sz2];

        for(int i=0; i<sz2; i++){
            fq[i] = calc(words[i]);
        }
        Arrays.sort(fq);

        for(int i=0; i<sz1; i++){
            int cnt = calc(queries[i]);
            int ind = findIndex(fq, cnt);
            // System.out.println(i + " " + ind);
            ans[i] = sz2 - ind;
        }

        return ans;
    }

    private int calc(String str){
        int sz = str.length(), freq[] = new int[26];

        for(int i=0; i<sz; i++){
            freq[str.charAt(i) - 'a']++;
        }

        for(int i=0; i<26; i++){
            if(freq[i] > 0) return freq[i];
        }

        return 0;
    }

    private int findIndex(int arr[], int val){
        int s = 0, e = arr.length-1, ans = 0;

        while(s <= e){
            int mid = s + (e-s)/2;
            // System.out.println(s + " " + mid + " " + e);
            if(arr[mid] <= val){
                s = mid + 1;
            }
            else {
                ans = mid;
                e = mid - 1;
            }
        }

        // System.out.println(s +  " " + e);
        return s == -1 || s >= arr.length ? arr.length : ans;
    }
}