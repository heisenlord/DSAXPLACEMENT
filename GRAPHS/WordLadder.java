import java.util.*;

class Node {
    String word;
    int level;

    public Node(String word, int level) {
        this.word = word;
        this.level = level;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord))
            return 0; // Early exit if endWord is not in the wordList

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(beginWord, 1)); // Start BFS with the beginWord at level 1

        while (!q.isEmpty()) {
            Node node = q.poll();
            String word = node.word;
            int level = node.level;

            if (word.equals(endWord)) { // Check if the current word is the endWord
                return level;
            }

            for (int i = 0; i < word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == word.charAt(i))
                        continue; // Skip same character

                    String newString = word.substring(0, i) + c + word.substring(i + 1);
                    if (set.contains(newString)) {
                        set.remove(newString);
                        q.add(new Node(newString, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}
