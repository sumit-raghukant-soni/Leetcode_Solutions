/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int importance = 0, sz = employees.size();
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<sz; i++){
            mp.put(employees.get(i).id, i);
        }

        q.add(id);

        while(!q.isEmpty()){
            int curr = mp.get(q.poll());
            importance += employees.get(curr).importance;

            for(Integer i : employees.get(curr).subordinates){
                q.add(i);
            }
        }

        return importance;
    }
}