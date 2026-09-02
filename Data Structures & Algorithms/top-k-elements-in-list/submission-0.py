from collections import Counter
import heapq

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # Step 1: Build a frequency map of all elements in the array
        count = Counter(nums)
        
        # Step 2: Use heapq.nlargest to find the k keys with the highest values
        # The 'key' parameter tells nlargest to compare elements based on their frequency
        return heapq.nlargest(k, count.keys(), key=count.get)