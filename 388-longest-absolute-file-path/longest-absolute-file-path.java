class Solution {
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        int sz = lines.length, ans = 0, curr = 0, prev = 0;
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<sz; i++){
            // System.out.println(lines[i]);
            if(st.size() == 0 && !lines[i].contains(".")){
                curr += lines[i].length();
                // System.out.println(curr + "Parent added: " + lines[i]);
                st.push(lines[i].length());
                prev = 1;
            }
            else{
                int j=0, sz2 = lines[i].length(), cnt = 0;
                while(j < sz2 && lines[i].charAt(j) == '\t'){
                    j += 1;
                    cnt++;
                }
                // System.out.println(cnt);
                while(!st.isEmpty() && st.size() > cnt){
                    curr -= st.pop();
                }
                curr += sz2 - j;
                st.push(sz2 - j);
                if(lines[i].substring(j, sz2).contains(".")){
                    // System.out.println(curr + "File added: " + lines[i]);
                    ans = Math.max(ans, curr + st.size()-1);
                }
                else{
                    // System.out.println(curr + "Sub Directory added: " + lines[i]);
                }
            }
        }

        return ans;
    }
}