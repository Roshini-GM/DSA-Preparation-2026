class WordDictionary {

    class Node {
        Node[] child = new Node[26];
        boolean end;
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
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
        return dfs(root, word, 0);
    }

    boolean dfs(Node curr, String word, int index) {

        if (index == word.length()) {
            return curr.end;
        }

        char c = word.charAt(index);

        if (c == '.') {
            for (Node next : curr.child) {
                if (next != null && dfs(next, word, index + 1)) {
                    return true;
                }
            }
            return false;
        }

        int pos = c - 'a';

        if (curr.child[pos] == null) {
            return false;
        }

        return dfs(curr.child[pos], word, index + 1);
    }
}