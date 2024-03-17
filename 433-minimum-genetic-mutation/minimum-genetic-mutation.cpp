class Solution {
public:
    int minMutation(string startGene, string endGene, vector<string>& bank) {
        unordered_set<string> strings(bank.begin(), bank.end());
        if (strings.find(endGene) == strings.end())
            return -1;

        queue<string> q;
        q.push(startGene);

        int cnt = 0;
        while (!q.empty()) {
            int s = q.size();
            while (s--) {
                string curr = q.front();
                q.pop();
                if (curr == endGene)
                    return cnt;
                strings.erase(curr);
                for (int i = 0; i < 8; i++) {
                    string tmp = curr;
                    tmp[i] = 'A';
                    if(strings.find(tmp) != strings.end()) q.push(tmp);
                    tmp[i] = 'C';
                    if(strings.find(tmp) != strings.end()) q.push(tmp);
                    tmp[i] = 'G';
                    if(strings.find(tmp) != strings.end()) q.push(tmp);
                    tmp[i] = 'T';
                    if(strings.find(tmp) != strings.end()) q.push(tmp);
                }
            }
            cnt++;
        }

        return -1;
    }
};