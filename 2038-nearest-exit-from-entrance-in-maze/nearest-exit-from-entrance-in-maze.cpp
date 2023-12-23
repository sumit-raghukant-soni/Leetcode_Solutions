class Solution {
public:
    class elem{
        public:
        int x, y, dis;
        elem(int xVal, int yVal, int dVal) { x = xVal; y = yVal; dis = dVal; }
    };
    int nearestExit(vector<vector<char>>& maze, vector<int>& entrance) {
        int r = maze.size(), c = maze[0].size();
        int dr[] = {0, 1, 0, -1}, dc[] = {1, 0, -1, 0};

        queue<elem*> q;
        vector<vector<bool>> vis(r, vector<bool>(c, false));
        elem *e = new elem(entrance[0], entrance[1], 0);
        q.push(e);
        vis[entrance[0]][entrance[1]] = true;

        while(!q.empty()){
            elem *front = q.front();
            q.pop();
            if((front->x == 0 || front->x == r-1 || front->y == 0 || front->y == c-1) 
            && (entrance[0] != front->x || front->y != entrance[1])) return front->dis;
            for(int i=0; i<4; i++){
                int nR = front->x + dr[i], nC = front->y + dc[i];
                if(nR >= 0 && nR < r && nC >= 0 && nC < c && maze[nR][nC] == '.' && !vis[nR][nC]){
                    q.push(new elem(nR, nC, front->dis+1));
                    vis[nR][nC] = true;
                }
            }
        }

        return -1;
    }
};