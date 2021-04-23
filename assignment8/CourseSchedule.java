package assignment8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CourseSchedule {
    int[] visited;
    ArrayList<ArrayList<Integer>> predeccesors = new ArrayList<>();
    Stack<Integer> s = new Stack<>();

    public void dfs(int n) {
        visited[n] = 1;
        for (int i : predeccesors.get(n)) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        s.push(n);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            predeccesors.add(new ArrayList<>());
        }
        for (int[] item : prerequisites) {
            if (item[0] == item[1]) {
                return false;
            }
            predeccesors.get(item[0]).add(item[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }

        Map<Integer, Integer> position = new HashMap<>();
        int index = s.size() - 1;
        while (!s.isEmpty()) {
            position.put(s.peek(), index);
            index--;
            s.pop();
        }

        for (int i = 0; i < numCourses; i++) {
            for (int predeccesor : predeccesors.get(i)) {
                if (position.get(i) < position.get(predeccesor)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule1 = new CourseSchedule();
        int numCourses1 = 4;
        int[][] prerequisites1 = {{2,0},{1,0},{3,1},{3,2},{1,3}};
        System.out.println("Should be false: " + courseSchedule1.canFinish(numCourses1, prerequisites1));

        CourseSchedule courseSchedule2 = new CourseSchedule();
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1,0}};
        System.out.println("Should be true: " + courseSchedule2.canFinish(numCourses2, prerequisites2));
    }
}
