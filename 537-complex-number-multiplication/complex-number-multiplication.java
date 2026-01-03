class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int a1, i1, b1, i2, num, i;
        String[] n1 = num1.split("\\+", 2), n2 = num2.split("\\+", 2);

        a1 = Integer.valueOf(n1[0]); i1 = Integer.valueOf(n1[1].substring(0, n1[1].length() - 1));
        b1 = Integer.valueOf(n2[0]); i2 = Integer.valueOf(n2[1].substring(0, n2[1].length() - 1));

        num = (a1 * b1) - (i1 * i2);
        i = (a1 * i2) + (b1 * i1);

        return String.valueOf(num) + "+" + String.valueOf(i) + "i";        
    }
}

// (1 + -1) * (0 + 0)

// num = (1 * 0) - (-1 * 0);
// i   = (1 * 0) + (0 * -1);