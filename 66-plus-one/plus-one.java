class Solution {
    public int[] plusOne(int[] digits) {
        int sz = digits.length, carry = 1;
        int[] ans = null;
        List<Integer> lst = new ArrayList<>();

        for(int i=sz-1; i>=0; i--){
            int val = digits[i] + carry;
            carry = val/10;
            val = val%10;
            lst.add(val);
        }

        if(carry > 0) lst.add(1);

        // System.out.println(lst);
        sz = lst.size();
        ans = new int[sz];
        for(int i=0; i<sz; i++){
            ans[(sz-1)-i] = lst.get(i);
        }

        return ans;
    }
}