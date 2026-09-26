class LFUCache {
    class Node {
        int key, value, freq;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            freq = 1;
        }
    }
    int capacity;
    int minFreq;
    HashMap<Integer, Node> map = new HashMap<>();
    HashMap<Integer, LinkedHashSet<Integer>> freq = new HashMap<>();
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        update(node);
        return node.value;
    }
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            update(node);
            return;
        }
        if (map.size() == capacity) {
            LinkedHashSet<Integer> set = freq.get(minFreq);
            int oldKey = set.iterator().next();
            set.remove(oldKey);
            map.remove(oldKey);
        }
        Node node = new Node(key, value);
        map.put(key, node);
        freq.putIfAbsent(1, new LinkedHashSet<>());
        freq.get(1).add(key);
        minFreq = 1;
    }
    void update(Node node) {
        int oldFreq = node.freq;
        freq.get(oldFreq).remove(node.key);
        if (oldFreq == minFreq && freq.get(oldFreq).isEmpty()) {
            minFreq++;
        }
        node.freq++;
        freq.putIfAbsent(node.freq, new LinkedHashSet<>());
        freq.get(node.freq).add(node.key);
    }
}