class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] counts = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            counts[rightChar - 'A']++;
            
            // Track the frequency of the most frequent character in the current window
            maxFreq = Math.max(maxFreq, counts[rightChar - 'A']);

            // The number of characters to replace is: (window length - frequency of most frequent character)
            // If this exceeds k, the window is invalid; shrink from the left
            while ((right - left + 1) - maxFreq > k) {
                counts[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}