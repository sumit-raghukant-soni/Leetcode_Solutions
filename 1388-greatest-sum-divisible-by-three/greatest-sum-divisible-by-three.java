class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        List<Integer> one = new ArrayList<>(), two = new ArrayList<>();

        for(int i : nums){
            sum += i;
            if(i%3 == 1) one.add(i);
            else if(i%3 == 2) two.add(i);
        }

        Collections.sort(one);
        Collections.sort(two);

        int op1 = Integer.MAX_VALUE, op2 = Integer.MAX_VALUE;

        if(sum%3 == 0) return sum;

        if(sum%3 == 1) {
            if(!one.isEmpty()) op1 = one.get(0);
            if(two.size() >= 2) op2 = two.get(0) + two.get(1);
        }
        else {
            if(!two.isEmpty()) op1 = two.get(0);
            if(one.size() >= 2) op2 = one.get(0) + one.get(1);
        }

        return sum - (op1 > op2 ? op2 : op1);
    }
}