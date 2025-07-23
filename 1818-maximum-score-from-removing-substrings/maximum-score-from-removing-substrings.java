class Solution {
    public int maximumGain(String str, int x, int y) {
        int sz = str.length(), ans = 0, f, s;
        char a, b;
        Stack<Character> st = new Stack<>();

        if(x < y){
            a = 'b'; b = 'a';
            f = y; s = x;
        }
        else {
            a = 'a'; b = 'b'; 
            f = x; s = y;
        }

        // System.out.println(a + " " + b);
        // System.out.println(f + " " + s);
        for(int i=0; i<sz; i++){
            // System.out.println(i);
            if(!st.isEmpty() && st.peek() == a && str.charAt(i) == b){
                // System.out.println("Here");
                ans += f;
                st.pop();
            }
            else if(f == s && !st.isEmpty() && st.peek() == b && str.charAt(i) == a){
                // System.out.println("Here");
                ans += f;
                st.pop();
            }
            else st.push(str.charAt(i));
        }

        // System.out.println(st + " " + ans);
        String str2 = "";
        sz = st.size();
        while(!st.isEmpty()){
            str2 = st.pop() + str2;
        }
        // System.out.println(str2);
        for(int i=0; i<sz; i++){
            if(!st.isEmpty() && st.peek() == a && str2.charAt(i) == b){
                ans += f;
                st.pop();
            }
            else if(!st.isEmpty() && st.peek() == b && str2.charAt(i) == a){
                ans += s;
                st.pop();
            }
            else st.push(str2.charAt(i));
        }

        return ans;
    }
}