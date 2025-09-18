class TaskManager {
    private static class Task {
        int userId, taskId, priority;

        Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }

    // Max-heap by priority, then by taskId
    private PriorityQueue<Task> pq;
    private Map<Integer, Task> taskMap;

    public TaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((a, b) -> {
            if (a.priority != b.priority) return Integer.compare(b.priority, a.priority);
            return Integer.compare(b.taskId, a.taskId);
        });
        taskMap = new HashMap<>();

        for (List<Integer> task : tasks) {
            int userId = task.get(0), taskId = task.get(1), priority = task.get(2);
            Task t = new Task(userId, taskId, priority);
            pq.add(t);
            taskMap.put(taskId, t);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task t = new Task(userId, taskId, priority);
        pq.add(t);
        taskMap.put(taskId, t);
    }

    public void edit(int taskId, int newPriority) {
        if (!taskMap.containsKey(taskId)) return;

        // Mark old task as invalid by replacing with a new one
        Task oldTask = taskMap.get(taskId);
        Task newTask = new Task(oldTask.userId, taskId, newPriority);
        pq.add(newTask);
        taskMap.put(taskId, newTask);
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            Task top = pq.poll();
            // Only return if this is the latest version of the task
            if (taskMap.containsKey(top.taskId) && taskMap.get(top.taskId) == top) {
                taskMap.remove(top.taskId);
                return top.userId;
            }
        }
        return -1;
    }
}
