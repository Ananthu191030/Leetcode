

import java.util.*;

// Disjoint Set (Union-Find) implementation
class DisjointSet {
    int[] rank;
    int[] parent;
    int[] size;

    // Constructor to initialize DSU
    DisjointSet(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];

        // Initialize every node
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // Function to find ultimate parent with path compression
    int findUPar(int node) {
        if (node == parent[node])
            return node;
        parent[node] = findUPar(parent[node]);
        return parent[node];
    }

    // Function to perform union by rank
    void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) return;

        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        }
        else if (rank[ulp_v] < rank[ulp_u]) {
            parent[ulp_v] = ulp_u;
        }
        else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }

    // Function to perform union by size
    void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) return;

        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
        else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

// Solution class to merge accounts
class Solution {
    // Function to merge accounts with common emails
    public List<List<String>> accountsMerge(
        List<List<String>> details) 
    {
        // Number of accounts
        int n = details.size();

        // Create Disjoint Set
        DisjointSet ds = new DisjointSet(n);

        // Map to store email -> account index
        Map<String, Integer> mapMailNode = new HashMap<>();

        // Step 1: Union accounts having common emails
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < details.get(i).size(); j++) {
                String mail = details.get(i).get(j);

                if (!mapMailNode.containsKey(mail)) {
                    mapMailNode.put(mail, i);
                }
                else {
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }

        // Step 2: Group emails under ultimate parent
        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) 
            mergedMail[i] = new ArrayList<>();

        for (Map.Entry<String, Integer> it : 
             mapMailNode.entrySet()) 
        {
            String mail = it.getKey();
            int node = ds.findUPar(it.getValue());
            mergedMail[node].add(mail);
        }

        // Step 3: Prepare final merged result
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMail[i].isEmpty()) continue;

            Collections.sort(mergedMail[i]);

            List<String> temp = new ArrayList<>();
            temp.add(details.get(i).get(0));

            for (String mail : mergedMail[i]) {
                temp.add(mail);
            }
            ans.add(temp);
        }

        // Sort final answer
        ans.sort((a, b) -> a.get(0).compareTo(b.get(0)));
        return ans;
    }
}
