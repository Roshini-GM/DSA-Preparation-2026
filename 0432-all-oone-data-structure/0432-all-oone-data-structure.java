class AllOne {
    class Node {
        int count;
        Set<String> keys = new HashSet<>();
        Node prev, next;
        Node(int count) {
            this.count = count;
        }
    }
    Node head = new Node(0);
    Node tail = new Node(0);
    HashMap<String, Node> map = new HashMap<>();
    public AllOne() {
        head.next = tail;
        tail.prev = head;
    }
    void addAfter(Node prev, Node node) {
        node.next = prev.next;
        node.prev = prev;
        prev.next.prev = node;
        prev.next = node;
    }
    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void inc(String key) {
        if (!map.containsKey(key)) {
            if (head.next == tail || head.next.count != 1) {
                addAfter(head, new Node(1));
            }
            head.next.keys.add(key);
            map.put(key, head.next);
        } else {
            Node curr = map.get(key);
            if (curr.next == tail || curr.next.count != curr.count + 1) {
                addAfter(curr, new Node(curr.count + 1));
            }
            curr.next.keys.add(key);
            map.put(key, curr.next);
            curr.keys.remove(key);
            if (curr.keys.isEmpty()) {
                remove(curr);
            }
        }
    }
    public void dec(String key) {
        Node curr = map.get(key);
        curr.keys.remove(key);
        if (curr.count == 1) {
            map.remove(key);
        } else {
            if (curr.prev == head || curr.prev.count != curr.count - 1) {
                addAfter(curr.prev, new Node(curr.count - 1));
            }
            curr.prev.keys.add(key);
            map.put(key, curr.prev);
        }
        if (curr.keys.isEmpty()) {
            remove(curr);
        }
    }
    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        }
        return tail.prev.keys.iterator().next();
    }
    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }
        return head.next.keys.iterator().next();
    }
}