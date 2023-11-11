class Solution {
public:
    char slowestKey(vector<int>& releaseTimes, string keysPressed) {
        int arr[26] = {0};
        int sz = releaseTimes.size();

        for(int i=0; i<sz; i++){
            if(i == 0) arr[keysPressed[i] - 'a'] = releaseTimes[i];
            else arr[keysPressed[i] - 'a'] = max(releaseTimes[i] - releaseTimes[i-1], arr[keysPressed[i] - 'a']);
        }

        int ans = 0;
        for(int i=0; i<26; i++)
            if(arr[i] >= arr[ans]) ans = i;

        return char(ans+'a');
    }
};