class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int sz = people.length, ans = 0, i = 0;
        Arrays.sort(people);

        for(int j=sz-1; j>=i; j--){
            if(people[i] + people[j] <= limit) i++;
            ans++;
        }

        return ans;
    }
}