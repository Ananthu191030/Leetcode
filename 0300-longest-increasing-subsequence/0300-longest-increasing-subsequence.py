class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        res=[]
        def binarys(res,n):
            l=0
            r=len(res)-1
            while l<=r:
                mid=(l+r)//2
                if res[mid]==n:
                    return mid
                elif res[mid]>n:
                    r=mid-1
                else:
                    l=mid+1
            return l
        for n in nums:
            if not res or res[-1]<n:
                res.append(n)
            else:
                id=binarys(res,n)
                res[id]=n
        return len(res)