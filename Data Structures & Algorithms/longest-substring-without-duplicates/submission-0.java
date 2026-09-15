

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int maxLength = 0;
        int left = 0;
        // Map to store the last seen index of each character
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            
            // If character is already in the map, move the left pointer
            // to the right of the previous occurrence of the character
            if (map.containsKey(currentChar)) {
                left = Math.max(left, map.get(currentChar) + 1);
            }
            
            // Update the last seen index of the character
            map.put(currentChar, right);
            
            // Calculate the length of the current window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}