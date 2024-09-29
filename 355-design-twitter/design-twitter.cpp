class Tuser{
    public:
    int id;
    vector<int> friends;
    Tuser(int id){
        this->id = id;
    }

    void startFollowing(int uid){
        friends.push_back(uid);
    }

    void stopFollowing(int uid){
        auto itr = find(friends.begin(), friends.end(), uid);
        if(itr != friends.end()) friends.erase(itr);
    }
};
class Twitter {
public:
    unordered_set<int> users;
    unordered_map<int, Tuser*> mp;
    vector<pair<int, int>> tweets;
    
    Twitter(){}

    void checkUser(int userId){
        if(users.find(userId) == users.end()){
            users.insert(userId);
            mp[userId] = new Tuser(userId);
        }
    }
    
    void postTweet(int userId, int tweetId) {
        checkUser(userId);
        tweets.push_back({userId, tweetId});
    }
    
    vector<int> getNewsFeed(int userId) {
        int sz = tweets.size(), k = 0;
        vector<int> ans;
        for(int i=sz-1; i>=0; i--){
            if(tweets[i].first == userId || find(mp[userId]->friends.begin(), mp[userId]->friends.end(), tweets[i].first) != mp[userId]->friends.end()){
                ans.push_back(tweets[i].second);
                k++;
            }
            if(k == 10) break;
        }

        return ans;
    }
    
    void follow(int followerId, int followeeId) {
        checkUser(followerId);
        checkUser(followeeId);
        
        mp[followerId]->startFollowing(followeeId);
    }
    
    void unfollow(int followerId, int followeeId) {
        checkUser(followerId);
        checkUser(followeeId);

        mp[followerId]->stopFollowing(followeeId);
    }
};

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter* obj = new Twitter();
 * obj->postTweet(userId,tweetId);
 * vector<int> param_2 = obj->getNewsFeed(userId);
 * obj->follow(followerId,followeeId);
 * obj->unfollow(followerId,followeeId);
 */