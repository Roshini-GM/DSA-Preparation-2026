class Trie {

    class Node {
        Node[] child = new Node[26];
        boolean end;
    }

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (curr.child[index] == null) {
                curr.child[index] = new Node();
            }

            curr = curr.child[index];
        }

        curr.end = true;
    }

    public boolean search(String word) {
        Node curr = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (curr.child[index] == null) {
                return false;
            }

            curr = curr.child[index];
        }

        return curr.end;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;

        for (char c : prefix.toCharArray()) {
            int index = c - 'a';

            if (curr.child[index] == null) {
                return false;
            }

            curr = curr.child[index];
        }

        return true;
    }
}