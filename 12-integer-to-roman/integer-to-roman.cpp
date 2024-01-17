class Solution {
public:
    string intToRoman(int num) {
        string ans = "";

        while(num > 0){
            if(num >= 1000) {ans += "M"; num -= 1000;}
            else if(num >= 900) { ans += "CM"; num -= 900;}
            else if(num >= 500) { ans += "D"; num -= 500;}
            else if(num >= 400) { ans += "CD"; num -= 400;}
            else if(num >= 100) { ans += "C"; num -= 100;}
            else if(num >= 90) { ans += "XC"; num -= 90;}
            else if(num >= 50) { ans += "L"; num -= 50;}
            else if(num >= 40) { ans += "XL"; num -= 40;}
            else if(num >= 10) { ans += "X"; num -= 10;}
            else if(num >= 9) { ans += "IX"; num -= 9;}
            else if(num >= 5) { ans += "V"; num -= 5;}
            else if(num >= 4) { ans += "IV"; num -= 4;}
            else { ans += 'I'; num -= 1;}
        }

        return ans;
    }
};