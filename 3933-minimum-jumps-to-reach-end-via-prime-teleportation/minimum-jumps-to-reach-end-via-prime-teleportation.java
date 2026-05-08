class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        // ✅ Step 1: Sieve of Eratosthenes — find all primes up to 10^6
        int MAX = 1_000_001;
        boolean[] isComposite = new boolean[MAX];
        for (int i = 2; i * i < MAX; i++)
            if (!isComposite[i])
                for (int j = i*i; j < MAX; j += i)
                    isComposite[j] = true;

        // ✅ Step 2: Group indices by prime factors
        Map<Integer, List<Integer>> primeToIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            // Factorize nums[i] and find prime factors
            for (int p = 2; p * p <= val; p++) {
                if (!isComposite[p] && val % p == 0) {
                    primeToIndices.computeIfAbsent(p, x -> new ArrayList<>()).add(i);
                    while (val % p == 0) val /= p; // divide out all p
                }
            }
            if (val > 1 && !isComposite[val]) // remaining prime factor
                primeToIndices.computeIfAbsent(val, x -> new ArrayList<>()).add(i);
        }

        // ✅ Step 3: BFS from index 0
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[0] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int steps = dist[curr];

            // Reached destination!
            if (curr == n - 1) return steps;

            // Adjacent moves
            for (int next : new int[]{curr - 1, curr + 1}) {
                if (next >= 0 && next < n && dist[next] == -1) {
                    dist[next] = steps + 1;
                    queue.add(next);
                }
            }

            // Prime teleportation — if nums[curr] is prime
            int val = nums[curr];
            if (!isComposite[val] && val > 1) {
                List<Integer> group = primeToIndices.get(val);
                if (group != null) {
                    for (int next : group) {
                        if (next != curr && dist[next] == -1) {
                            dist[next] = steps + 1;
                            queue.add(next);
                        }
                    }
                    // ✅ Delete group — never process again!
                    primeToIndices.remove(val);
                }
            }
        }

        return dist[n - 1];
    }
}