class Solution {
    int count = 0;
    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        for (char c : tiles.toCharArray())
            freq[c - 'A']++;
        backtrack(freq);
        return count;
    }
    void backtrack(int[] freq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0)
                continue;
            count++;
            freq[i]--;
            backtrack(freq);
            freq[i]++;
        }
    }
}