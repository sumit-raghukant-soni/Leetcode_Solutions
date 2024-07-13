class Solution {
    class Robot{
        public:
        int position, health, i;
        char direction;
        Robot(int a, int b, char ch, int ind){
            this->position = a, this->health = b, this->direction = ch, this->i = ind;
        }
    };
public:
    vector<int> survivedRobotsHealths(vector<int>& positions, vector<int>& healths, string directions) {
        int sz = positions.size(), flg = 0;

        vector<Robot> robos;
        stack<Robot*> right;

        for(int i=0; i<sz; i++){
            robos.push_back(Robot(positions[i], healths[i], directions[i], i));
        }

        sort(robos.begin(), robos.end(), [](Robot a, Robot b){
            return a.position < b.position;
        });

        for(int i=0; i<sz; i++){
            if(robos[i].direction == 'L'){
                while(!right.empty()){
                    Robot *rrobo = right.top();
                    right.pop();
                    if(rrobo->direction == 'R'){
                        if(rrobo->health != 0 && rrobo->health < robos[i].health){
                            flg = 1;
                            rrobo->health = 0;
                            robos[i].health--;
                            // cout << " defeated by " << i << endl;
                            // cout << rrobo->health << ":" << robos[i].health << endl;
                        }
                        else if(rrobo->health == robos[i].health){
                            flg = 1;
                            rrobo->health = 0, robos[i].health = 0;
                            // cout << " tie " << i << endl;
                            // cout << rrobo->health << ":" << robos[i].health << endl;
                            break;
                        }
                        else if(rrobo->health > robos[i].health){
                            flg = 1;
                            robos[i].health = 0;
                            rrobo->health--;
                            rrobo->position = robos[i].position;
                            right.push(rrobo);
                            // cout << i << " losed by " << endl;
                            // cout << robos[i].health << ":" << rrobo->health << endl;
                            break;
                        }
                    }
                }
            }
            else right.push(&robos[i]);
        }

        if(!flg) return healths;
        
        sort(robos.begin(), robos.end(), [](Robot a, Robot b){
            return a.i < b.i;
        });

        vector<int> ans;
        for(Robot i : robos){
            if(i.health > 0) ans.push_back(i.health);
        }

        return ans;
    }
};