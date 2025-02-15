class Solution:
   
    def punishmentNumber(self, n: int) -> int:
        def partition(i:int,cur:int,target:int,string:str):
          if len(string)==i and cur==target:
             return True
          for j in range(i,len(string)):
             if partition(j+1,cur+int(string[i:j+1]),target,string):
                 return True
          return False
        res=0
        for i in range(0,n+1):
            if partition(0,0,i,str(i*i)):
             res+=i*i
        return res
   