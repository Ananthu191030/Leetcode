class Solution:
    def makeFancyString(self, s: str) -> str:
        ans = s[0]
        cnt = 1
        n=len(s)
        for i in range(1,n):
            if s[i] == ans[-1]:
                cnt += 1
                if cnt < 3:
                    ans += s[i]
            else:
                cnt = 1
                ans += s[i]
        return ans