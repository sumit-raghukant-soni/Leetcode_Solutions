class Solution {
    public String maskPII(String s) {
        if(s.indexOf("@") > -1) return maskEmail(s);
        return maskPhone(s);
    }

    private String maskEmail(String s){
        int mid = s.indexOf("@");
        String name = s.substring(0, mid);
        StringBuilder last = new StringBuilder(s.substring(mid));
        int sz1 = name.length(), sz2 = last.length();

        for(int i=0; i<sz2; i++){
            if(last.charAt(i) >= 'A' && last.charAt(i) <= 'Z'){
                last.setCharAt(i, (char) (last.charAt(i) - 'A' + 'a'));
            }
        }

        // if(sz1 > 1){
            name = 
            (name.charAt(0) >= 'A' && name.charAt(0) <= 'Z' ? ((char) (name.charAt(0) - 'A' + 'a')) : name.charAt(0)) 
            + "*****"
            + (name.charAt(sz1-1) >= 'A' && name.charAt(sz1-1) <= 'Z' ? ((char) (name.charAt(sz1-1) - 'A' + 'a')) : name.charAt(sz1-1));
        // }

        System.out.println(name + " " + last);

        return name + last.toString();
    }

    private String maskPhone(String s){
        String phone = s.replaceAll("[-() +]", "");
        int sz = phone.length();
        String front = "";

        for(int i=0; i<sz-10; i++){
            front += "*";
        }

        if(sz > 10){
            front = "+" + front + "-";
        }

        return front + "***-***-" + phone.substring(sz-4);
    }
}