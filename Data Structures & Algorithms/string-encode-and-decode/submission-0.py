class Solution:
    def encode(self, strs: list[str]) -> str:
        """Encodes a list of strings to a single string."""
        encoded_str = ""
        for s in strs:
            # Store length of string followed by a delimiter and the string itself
            encoded_str += str(len(s)) + "#" + s
        return encoded_str

    def decode(self, s: str) -> list[str]:
        """Decodes a single string back to a list of strings."""
        res = []
        i = 0
        while i < len(s):
            # Find the delimiter to determine where the length ends
            j = i
            while s[j] != '#':
                j += 1
            
            # Extract the length of the next string
            length = int(s[i:j])
            
            # Extract the string based on the length
            # The string starts at j + 1 and ends at j + 1 + length
            res.append(s[j + 1 : j + 1 + length])
            
            # Move the pointer to the start of the next length segment
            i = j + 1 + length
            
        return res