package assignment8;

import java.util.*;

public class WordLadder {
    public class State {
        String s;
        int level;
    }

    public List<String> getNeighbors(String s, Set<String> wordSet) {
        List<String> res = new ArrayList<>();
        char[] characters = s.toCharArray();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < characters.length; i++) {
                if (ch == characters[i]) {
                    continue;
                }
                char oldCharacter = characters[i];
                characters[i] = ch;
                if (wordSet.contains(String.valueOf(characters))) {
                    res.add(String.valueOf(characters));
                }
                characters[i] = oldCharacter;
            }
        }
        return res;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for (String s : wordList) {
            wordSet.add(s);
        }

        Queue<State> q = new LinkedList<>();
        State Original = new State();
        Original.s = beginWord;
        Original.level = 1;
        q.add(Original);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while(!q.isEmpty()) {
            State curr = q.remove();
            List<String> nextStrings = getNeighbors(curr.s, wordSet);
            for (String nextS : nextStrings) {
                if (nextS.equals(endWord)) {
                    return curr.level + 1;
                }
                if (!visited.contains(nextS)) {
                    visited.add(nextS);
                    State next = new State();
                    next.s = nextS;
                    next.level = curr.level + 1;
                    q.add(next);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder wl1 = new WordLadder();
        String beginWord1 = "hit";
        String endWord1 = "cog";
        String[] sourceArray1 = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList1 = Arrays.asList(sourceArray1);
        System.out.println("Should be 5: " + wl1.ladderLength(beginWord1, endWord1, wordList1));

        WordLadder wl2 = new WordLadder();
        String beginWord2 = "hit";
        String endWord2 = "cog";
        String[] sourceArray2 = {"hot","dot","dog","lot","log"};
        List<String> wordList2 = Arrays.asList(sourceArray2);
        System.out.println("Should be 0: " + wl1.ladderLength(beginWord2, endWord2, wordList2));

    }
}
