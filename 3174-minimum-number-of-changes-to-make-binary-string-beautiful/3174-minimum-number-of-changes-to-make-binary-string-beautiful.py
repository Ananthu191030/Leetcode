class Solution:
    def minChanges(self, s: str) -> int:
        c=0
        n=len(s)
        i=0
        while i<n-1:
            if s[i]!=s[i + 1]:
                c+= 1
            i += 2
        return c
