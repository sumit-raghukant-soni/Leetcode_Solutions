class Solution {
    public int minimumDeletions(String word, int k) {
        int sz = word.length(), ans = 0, s = 0, e = 0;
        int freq[] = new int[26];

        for(int i=0; i<sz; i++){
            freq[word.charAt(i) - 'a']++;
        }

        for(int i=0; i<26; i++){
            // if(freq[i] > 0) System.out.println((char) (i + 'a') + " " + freq[i]);
            e = e > freq[i] ? e : freq[i];
        }
        // System.out.println(s + " " + e);

        // Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        // Set<Integer> used = new HashSet<>();
        // q.add(new Pair(s, e));
        // while(!q.isEmpty()){
        //     s = q.peek().getKey(); e = q.peek().getValue();
        //     q.poll();

        //     int mid = s + (e-s)/2;
        //     if(used.contains(mid)) continue;
        //     used.add(mid);

        //     int tmp = calc(freq, mid - k/2, mid + (k+1)/2);
        //     int tmp2 = calc(freq, mid - (k+1)/2, mid + k/2);
        //     tmp = tmp > tmp2 ? tmp : tmp2;
        //     // System.out.println(mid + " " + tmp);
        //     // System.out.println();
        //     if(tmp >= ans){
        //         q.add(new Pair(mid+1, e));
        //         q.add(new Pair(s, mid-1));
        //         ans = tmp;
        //     }
        //     // else if(tmp > ans){
        //     //     // s = mid+1;
        //     //     q.add(new Pair(mid+1, e));
        //     // }
        //     else{
        //         // e = mid - 1;
        //         q.add(new Pair(s, mid-1));
        //     }
        // }

        for(int i=e; i>=1; i--){
            ans = Math.max(calc(freq, i - k/2, i + (k+1)/2), ans);
            ans = Math.max(calc(freq, i - (k+1)/2, i + k/2), ans);
        }


        return sz - ans;
    }

    private int calc(int freq[], int mini, int maxi){
        int ans = 0;

        // System.out.println(mini + ":" + maxi);
        for(int i=0; i<26; i++){
            if(freq[i] >= mini && freq[i] <= maxi) ans += freq[i];
            else if(freq[i] > maxi) ans += maxi;
        }

        return ans;
    }
}