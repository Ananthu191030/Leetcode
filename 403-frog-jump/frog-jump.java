class Solution {
    public boolean canCross(int[] stones) {
 
        if (stones[1] != 1) return false;

        Set<Integer> stoneSet = new HashSet<>();
        for (int s : stones) stoneSet.add(s);

        int last = stones[stones.length - 1];

        HashMap<String, Boolean> dp = new HashMap<>();

        return f(1, 1, last, stoneSet, dp);
    }

    boolean f(int pos, int k, int last, Set<Integer> stoneSet,
              HashMap<String, Boolean> dp) {
        if (pos == last) return true;

        if (k <= 0) return false;

        String key = pos + "_" + k;
        if (dp.containsKey(key)) return dp.get(key);

        boolean result = false;
        for (int dk = -1; dk <= 1; dk++) {
            int nextK = k + dk;
            int nextPos = pos + nextK;
            if (nextK > 0 && stoneSet.contains(nextPos)) {
                if (f(nextPos, nextK, last, stoneSet, dp)) {
                    result = true;
                    break;
                }
            }
        }

        dp.put(key, result);
        return result;
    }
}