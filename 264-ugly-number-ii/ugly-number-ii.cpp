class Solution {
public:
    int nthUglyNumber(int n) {
        if (n == 1) return 1;

        vector<long long> multipleOf2, multipleOf3, multipleOf5, result;

        result.push_back(1);
        multipleOf2.push_back(2);
        multipleOf3.push_back(3);
        multipleOf5.push_back(5);

        int i = 0, j = 0, k = 0;

        while (result.size() < n) {
            int mini = min({multipleOf2[i], multipleOf3[j], multipleOf5[k]});
            result.push_back(mini);

            if (mini == multipleOf2[i]) i++;
            if (mini == multipleOf3[j]) j++;
            if (mini == multipleOf5[k]) k++;

            multipleOf2.push_back(result.back() * 2);
            multipleOf3.push_back(result.back() * 3);
            multipleOf5.push_back(result.back() * 5);
        }
        return result[n-1];
    }
};