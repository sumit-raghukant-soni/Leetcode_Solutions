class Solution {
    public List<String> removeComments(String[] source) {
        int sz = source.length, sz2;
        boolean mode = true;
        List<String> ans = new ArrayList<>();

        String str = "";
        for(int i=0; i<sz; i++){
            sz2 = source[i].length();
            str = mode ? "" : str;
            for(int j=0; j<sz2; j++){
                if(j+1 < sz2){
                    if(mode){
                        if(source[i].charAt(j) == '/' && source[i].charAt(j+1) == '*') {
                            mode = false;
                            j++;
                        }
                        else if(source[i].charAt(j) == '/' && source[i].charAt(j+1) == '/') {
                            break;
                        }
                        else str += source[i].charAt(j);
                    }
                    else if(source[i].charAt(j) == '*' && source[i].charAt(j+1) == '/') {
                        mode = true;
                        j++;
                    }
                }
                else if(mode) {
                    str += source[i].charAt(j);
                }
            }
            if(!str.isEmpty() && mode) ans.add(str);
        }

        return ans;
    }
}