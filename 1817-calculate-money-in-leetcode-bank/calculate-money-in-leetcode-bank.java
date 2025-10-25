class Solution {
    public int totalMoney(int n) {
        int i=8, ans = 0, sum = 28;
        Queue<Integer> q = new LinkedList<>();

        for(int j=0; j<7; j++) q.add(j+1);

        while(n > 7){
            ans += sum;
            // System.out.println(q + " " + q.peek());
            sum = sum + i - q.poll();
            q.add(i++);
            n -= 7;
        }

        while(n > 0){
            // System.out.println(q.peek());
            ans += q.poll();
            n--;
        }

        return ans;
    }
}