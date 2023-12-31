class FoodRatings {
public:
    unordered_map<string, multiset<pair<int, string> > > mp;
    unordered_map<string, string> mp2;
    unordered_map<string, int> mp3;
    FoodRatings(vector<string>& foods, vector<string>& cuisines, vector<int>& ratings) {
        int sz = foods.size();
        for(int i=0; i<sz; i++){
            mp2[foods[i]] = cuisines[i];
            mp3[foods[i]] = ratings[i];
            mp[cuisines[i]].insert({ratings[i], foods[i]});
        }
    }
    
    void changeRating(string food, int newRating) {
        mp[mp2[food]].erase({mp3[food], food});
        mp3[food] = newRating;
        mp[mp2[food]].insert({mp3[food], food});
    }
    
    string highestRated(string cuisine) {
        string ans = "";
        int tmp = 0;

        for(auto i = mp[cuisine].rbegin(); i != mp[cuisine].rend(); i++){
            if(tmp == 0 || tmp == i->first){
                tmp = i->first;
                ans = i->second;
            }
            else break;
        }
        return ans;
    }
};

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings* obj = new FoodRatings(foods, cuisines, ratings);
 * obj->changeRating(food,newRating);
 * string param_2 = obj->highestRated(cuisine);
 */