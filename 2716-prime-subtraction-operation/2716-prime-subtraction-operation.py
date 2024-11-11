from typing import List
import bisect

class Solution:
    def primeSubOperation(self, nums: List[int]) -> bool:
        
        def sieve(max_num):
            is_prime = [True] * (max_num + 1)
            is_prime[0] = is_prime[1] = False
            for i in range(2, int(max_num**0.5) + 1):
                if is_prime[i]:
                    for j in range(i * i, max_num + 1, i):
                        is_prime[j] = False
            return [i for i in range(2, max_num + 1) if is_prime[i]]
        
        
        primes = sieve(1000)
        
        
        prev = 0 
        for i in range(len(nums)):
            
            pos = bisect.bisect_left(primes, nums[i])
            success = False
            
           
            for j in range(pos - 1, -1, -1):
                prime = primes[j]
                if nums[i] - prime > prev:
                    nums[i] -= prime
                    success = True
                    break
            
           
            if not success and nums[i] <= prev:
                return False
            
            
            prev = nums[i]
        
        
        return True