class Solution {
public:
    unordered_map<string, unordered_set<string>> parent;
    unordered_map<string, int> visited;
    vector<vector<string>> ans;
    vector<string> path;
    void getPaths(string endWord, string beginWord){
        path.insert(path.begin(), endWord);
        if(path[0] == beginWord) ans.push_back(path);

        for(string p : parent[endWord]){
            getPaths(p, beginWord);
        }

        path.erase(path.begin());
    }
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        int wsz = beginWord.size();
        unordered_set<string> dict(wordList.begin(), wordList.end());

        queue<string> q;
        q.push(beginWord);
        visited[beginWord] = 0;

        while(!q.empty()){
            string front = q.front();
            q.pop();
            // cout << front << endl;
            // dict.erase(front);
            for(int i=0; i<wsz; i++){
                string word = front;
                for(int j=0; j<26; j++){
                    word[i] = 'a' + j;
                    // cout << word << " ";
                    if(word == front) continue;
                    if(dict.find(word) != dict.end()){
                        if(visited.find(word) == visited.end()){
                            // cout << "+" << " ";
                            q.push(word);
                            parent[word].insert(front);
                            visited[word] = 1 + visited[front];
                        }
                        else if(visited[word] == 1 + visited[front]){
                            parent[word].insert(front);
                        }
                    }
                }
                // cout << endl;
            }
        }
        
        getPaths(endWord, beginWord);
        return ans;
    }
};