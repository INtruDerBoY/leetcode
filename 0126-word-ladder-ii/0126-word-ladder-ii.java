import java.util.*;

class Solution {

    public List<List<String>> findLadders(
            String beginWord, String endWord, List<String> wordList) {

        List<List<String>> ans = new ArrayList<>();
        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return ans;
        }

        Map<String, List<String>> parents = new HashMap<>();
        Queue<String> q = new LinkedList<>();

        q.offer(beginWord);
        set.remove(beginWord);

        boolean found = false;

        // BFS
        while (!q.isEmpty() && !found) {
            int size = q.size();
            Set<String> usedOnLevel = new HashSet<>();

            for (int i = 0; i < size; i++) {
                String word = q.poll();
                char[] arr = word.toCharArray();

                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == original) {
                            continue;
                        }

                        arr[j] = ch;
                        String next = new String(arr);

                        if (set.contains(next)) {
                            parents.computeIfAbsent(
                                next, k -> new ArrayList<>()
                            ).add(word);

                            if (usedOnLevel.add(next)) {
                                q.offer(next);
                            }

                            if (next.equals(endWord)) {
                                found = true;
                            }
                        }
                    }

                    arr[j] = original;
                }
            }

            // Remove words only after the whole level is processed
            set.removeAll(usedOnLevel);
        }

        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, beginWord, parents, path, ans);
        }

        return ans;
    }

    private void dfs(
            String word,
            String beginWord,
            Map<String, List<String>> parents,
            List<String> path,
            List<List<String>> ans) {

        if (word.equals(beginWord)) {
            List<String> result = new ArrayList<>(path);
            Collections.reverse(result);
            ans.add(result);
            return;
        }

        for (String parent :
                parents.getOrDefault(word, Collections.emptyList())) {

            path.add(parent);
            dfs(parent, beginWord, parents, path, ans);
            path.remove(path.size() - 1);
        }
    }
}