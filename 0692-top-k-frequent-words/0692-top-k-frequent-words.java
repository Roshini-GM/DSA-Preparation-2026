class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        if (words == null | words.length == 0) return new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
            if (!list.contains(word)) list.add(word);
        }
        Collections.sort(list, (String a, String b) -> {
                int aCount = map.get(a);
                int bCount = map.get(b);
                if (aCount == bCount) {
                    return a.compareTo(b);
                } else {  
                    return bCount - aCount;
                }
            });
        return list.subList(0, k);
    }
}