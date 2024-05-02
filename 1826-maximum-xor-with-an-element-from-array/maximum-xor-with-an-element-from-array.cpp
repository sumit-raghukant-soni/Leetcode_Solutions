class node{
    public:
        node* child[2];
        node(){
            child[0]=NULL;
            child[1]=NULL;
        }
};

void insert(node* root,int n){
    bitset<32> bs(n);
    for(int i=31;i>=0;i--){
        if(root->child[bs[i]]==NULL) root->child[bs[i]]=new node();
        root=root->child[bs[i]];
    }
}

int Xor(node* root,int n){
    bitset<32> bs(n);
    int ans=0;
    for(int i=31;i>=0;i--){
        if(root->child[!bs[i]]!=NULL){
            ans+=(1<<i);
            root=root->child[!bs[i]];
        }
        else root=root->child[bs[i]];
    }

    return ans;
}
class Solution {
public:
    vector<int> maximizeXor(vector<int>& nums, vector<vector<int>>& queries) {
        sort(nums.begin(),nums.end());
        vector<pair<int,pair<int,int>>> v;

        for(int i=0;i<queries.size();i++){
            v.push_back({queries[i][1],{queries[i][0],i}});
        }
        sort(v.begin(),v.end());

        int j=0;
        vector<int> ans(queries.size());
        node* root=new node();
        for(int i=0;i<v.size();i++){
            int xi=v[i].second.first;
            int mi=v[i].first;
            int ind=v[i].second.second;

            while(j<nums.size() && nums[j]<=mi){
                insert(root,nums[j]);
                j++;
            }
            if(j==0) ans[ind]=-1;
            else ans[ind]=Xor(root,xi);
        }

        return ans;
    }
};