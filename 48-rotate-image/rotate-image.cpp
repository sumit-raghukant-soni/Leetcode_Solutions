class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int er=matrix.size()-1, ec=matrix[0].size()-1, sr=0,sc=0,i,j,k=0,size=matrix.size()-1;

        while(sc<matrix.size()/2)
        {
            k=0;
            while(k<size)
            {
                for(i=sr+1; i<=er; i++)
                {
                    swap(matrix[i][sc], matrix[i-1][sc]);
                }
                for(i=sc+1; i<=ec;i++)
                {
                    swap(matrix[er][i], matrix[er][i-1]);
                }
                for(i=er-1; i>=sr; i--)
                {
                    swap(matrix[i][ec], matrix[i+1][ec]);
                }
                for(i=ec-1; i>=sc && sc != matrix.size()/2; i--)
                {
                    swap(matrix[sc][i], matrix[sc][i+1]);
                }
                k++;
            }
            for(i=sc; i<ec && sc != matrix.size()/2;i++)
            {
                swap(matrix[sc][i], matrix[sc][i+1]);
            }
            sc++;
            sr++;
            er--;
            ec--;
            size-=2;
        }

    }
};