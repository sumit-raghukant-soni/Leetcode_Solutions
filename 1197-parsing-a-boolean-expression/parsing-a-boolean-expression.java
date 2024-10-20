class Solution {
    public boolean parseBoolExpr(String exp) {
        int sz = exp.length();
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for(int i=0; i<sz; i++){
            if(exp.charAt(i) == '|' || exp.charAt(i) == '&' || exp.charAt(i) == '!'){
                // System.out.println("symbol" + exp.charAt(i));
                st1.push(exp.charAt(i));
            }
            else if(exp.charAt(i) != ')' && exp.charAt(i) != ','){
                st2.push(exp.charAt(i));
                // System.out.println(st1.size());
            }
            else if(exp.charAt(i) == ')'){
                // System.out.println("closing" + st2.size());
                Boolean tmp = st2.pop() == 't' ? true : false;
                while(st2.peek() != '('){
                    // System.out.println("insider " + st2.peek());
                    switch(st1.peek()){
                        case '&':
                            tmp = (st2.pop() == 't') & tmp;
                            break;
                        case '|':
                            tmp = (st2.pop() == 't') | tmp;
                            break;
                    }
                }
                // System.out.println(st1.peek() + " " + (!tmp));
                if(st1.pop() == '!') tmp = tmp ? false : true;
                st2.pop();
                st2.push(tmp ? 't' : 'f');
                System.out.println(tmp);
            }
        }

        return st2.peek() == 't';
    }
}