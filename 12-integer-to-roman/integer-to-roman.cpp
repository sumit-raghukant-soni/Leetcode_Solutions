class Solution {
public:
    string intToRoman(int num) {
        string thousand[] = {"", "M", "MM", "MMM"};
        string hundred[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        string tens[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        string ones[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousand[num/1000] + hundred[(num%1000)/100] + tens[(num%100)/10] + ones[(num%10)];
    }
};