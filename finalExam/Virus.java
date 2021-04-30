package finalExam;

import java.util.LinkedList;
import java.util.Queue;

public class Virus {
    public class State{
        int r;
        int c;
        int time;

        public State(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public State(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }

        public State() {
        }
    }

    // The count of rows: m
    // The count of cols: n
    // Time complexity: O(m*n)
    // Space complexity: O(m*n)
    public String getResult(char[][] body, int maxTime){
        int[] rDir = {-1, 0, 1, 0};
        int[] cDir = {0, 1, 0, -1};

        int rows = body.length;

        int cols = body[0].length;

        Queue<State> q = new LinkedList<>();
        State original = new State(0, 0, 0);

        q.add(original);
        body[0][0] = '1';

        while (!q.isEmpty()) {
            State curr = q.poll();
            if (curr.r == rows - 1 && curr.c == cols - 1) {
                if (curr.time <= maxTime) {
                    return "can infect";
                } else {
                    return "cannot infect";
                }
            }

            for (int i = 0; i < 4; i++) {
                int nextR = curr.r + rDir[i];
                int nextC = curr.c + cDir[i];
                int nextT = curr.time + 1;
                State next = new State(nextR, nextC, nextT);

                if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols && body[nextR][nextC] == '0') {
                    q.add(next);
                    body[nextR][nextC] = '1';
                }
            }
        }
        return "cannot infect";
    }

    public static void main(String[] args) {
        Virus virus1 = new Virus();
        char[][] body1 = {
                {'0','0','X','0'},
                {'X','0','X','X'},
                {'X','0','0','0'}
        };
        int maxTime1 = 5;
        System.out.println("The result should be can infect: " + virus1.getResult(body1, 5));
        
    }
}
