import java.util.*;
class TextEditor {
    Stack<Character> left = new Stack<>();
    Stack<Character> right = new Stack<>();
    public TextEditor() {
    }
    public void addText(String text) {
        for (char c : text.toCharArray()) {
            left.push(c);
        }
    }
    public int deleteText(int k) {
        int count = 0;
        while (k > 0 && !left.isEmpty()) {
            left.pop();
            k--;
            count++;
        }
        return count;
    }
    public String cursorLeft(int k) {
        while (k > 0 && !left.isEmpty()) {
            right.push(left.pop());
            k--;
        }
        return getLast10();
    }
    public String cursorRight(int k) {
        while (k > 0 && !right.isEmpty()) {
            left.push(right.pop());
            k--;
        }
        return getLast10();
    }
    private String getLast10() {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = left.size() - 1; i >= 0 && count < 10; i--) {
            sb.append(left.get(i));
            count++;
        }
        return sb.reverse().toString();
    }
}