class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        row=[1]*n
        for i in range(m-1):
            newr=[1]*n
            for j in range(n-2,-1,-1):
                newr[j]=newr[j+1]+row[j]
            row=newr
        return row[0]