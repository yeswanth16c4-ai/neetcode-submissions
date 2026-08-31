from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # Create a dictionary to store grouped anagrams
        # The key will be the sorted version of the word, the value will be a list of words
        anagrams_map = defaultdict(list)
        
        for s in strs:
            # Sort the string to create a canonical form
            # All anagrams will have the same sorted representation
            sorted_s = "".join(sorted(s))
            # Append the original string to the list corresponding to its sorted key
            anagrams_map[sorted_s].append(s)
        
        # Return only the grouped lists from the dictionary values
        return list(anagrams_map.values())