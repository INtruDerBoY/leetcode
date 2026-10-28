class Solution {

    int[] parent;
    int[] size;

    int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }

    void unionBySize(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv) return;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        HashMap<String, Integer> map = new HashMap<>();

        // Connect accounts that share an email
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);

                if (map.containsKey(email)) {
                    unionBySize(i, map.get(email));
                } else {
                    map.put(email, i);
                }
            }
        }

        // Group emails by their component root
        List<String>[] merged = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            merged[i] = new ArrayList<>();
        }

        for (String email : map.keySet()) {
            int root = find(map.get(email));
            merged[root].add(email);
        }

        // Sort emails and build the answer
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (merged[i].isEmpty()) continue;

            Collections.sort(merged[i]);

            List<String> account = new ArrayList<>();
            account.add(accounts.get(i).get(0));
            account.addAll(merged[i]);

            ans.add(account);
        }

        return ans;
    }
}