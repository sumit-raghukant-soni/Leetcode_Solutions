class Solution {
public:
    int snakesAndLadders(vector<vector<int>>& board) {
        int n = board.size(), steps = 0, target = n * n;
        queue<int> q;
        q.push(1);

        while (!q.empty()) {
            int s = q.size();
            steps++;
            while (s--) {
                int cur = q.front();
                q.pop();

                for (int i = 1; i <= 6; i++) {
                    if (cur + i > target)
                        continue;
                    int next = cur + i;
                    int r = (next - 1) / n;
                    int c = (next - 1) % n;
                    c = r % 2 ? n - c - 1 : c;
                    r = n - r - 1;

                    if (board[r][c] == 0)
                        continue;
                    next = board[r][c] != -1 ? board[r][c] : next;
                    board[r][c] = 0;
                    if (next == target)
                        return steps;
                    q.push(next);
                }
            }
        }
        return -1;
    }
};