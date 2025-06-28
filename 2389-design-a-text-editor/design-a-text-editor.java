class TextEditor {
    StringBuilder content = null;
    int curr;
    public TextEditor() {
        curr = -1;
        // curr = 0;
        content = new StringBuilder();
    }
    
    public void addText(String text) {
        // if(curr != 0) curr++;
        curr++;
        int sz = text.length();

        if(curr < content.length()){
            content.insert(curr, text);
        }
        else{
            content.append(text);
        }

        curr += sz-1;

        // System.out.println("add " + content + " " + curr);
    }
    
    public int deleteText(int k) {
        int cnt = 0;
        while(k > 0 && curr >= 0){
            k--;
            cnt++;
            content.deleteCharAt(curr--);
        }

        // System.out.println("delete " + k + " " + content + " " + curr);
        return cnt;
    }
    
    public String cursorLeft(int k) {
        curr = curr >= k ? curr-k : -1;
        
        StringBuilder text = new StringBuilder("");
        for(int i=curr; (curr-i)<10 && i>=0; i--){
            text.insert(0, content.charAt(i));
        }

        // System.out.println("Left " + k + " " + content + " " + curr);
        return text.toString();
    }
    
    public String cursorRight(int k) {
        curr = Math.min(curr+k, content.length()-1);
        
        StringBuilder text = new StringBuilder("");
        for(int i=curr; i>=0 && i>(curr - 10); i--){
            text.insert(0, content.charAt(i));
        }

        // System.out.println("Right " + k + " " + content + " " + curr);
        return text.toString();
    }
}


/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */