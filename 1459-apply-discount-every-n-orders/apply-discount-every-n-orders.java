class Cashier {
    int n, discount, cnt;
    Map<Integer, Integer> mp;
    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        cnt = 0;
        mp = new HashMap<>();
        for(int i=0; i<products.length; i++){
            mp.put(products[i], prices[i]);
        }
    }
    
    public double getBill(int[] product, int[] amount) {
        int sz = product.length;
        double total = 0;

        cnt++;
        for(int i=0; i<sz; i++){
            total += mp.get(product[i]) * amount[i];
        }

        if(cnt%n == 0){
            return total * ((100.0 - discount) / 100);
        }
        return total;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */