class Solution:
    def largestCombination(self, candidates: List[int]) -> int:
        count=[0]*24
        for c in candidates:
            for i in  range(24):
                if c & (1<<i):
                    count[i]+=1
        return max(count)