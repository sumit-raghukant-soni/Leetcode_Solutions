class Solution {
public:
    string convert(string s, int numRows) {
        if(numRows == 1)
            return s;
        vector<string> rowWise(numRows);
        int index = -1, way=0;
        for(int i=0; i<s.length(); i++){   
            if(way == 0){
                index++;
                if(index == numRows){
                    index-=2;
                    way = 1;
                }    
            }
            else{
                index--;
                if(index == -1){
                    index += 2;
                    way = 0;
                }
            }
            rowWise[index] += s[i];
        }
        string str;
        for(int i=0; i<numRows; i++){
            str += rowWise[i];
        }
        return str;
    }
};