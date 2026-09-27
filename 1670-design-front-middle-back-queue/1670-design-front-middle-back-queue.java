import java.util.*;
class FrontMiddleBackQueue {
    Deque<Integer> left = new ArrayDeque<>();
    Deque<Integer> right = new ArrayDeque<>();
    public FrontMiddleBackQueue() {
    }
    void balance() {
        if (left.size() > right.size() + 1) {
            right.addFirst(left.removeLast());
        }
        if (right.size() > left.size()) {
            left.addLast(right.removeFirst());
        }
    }
    public void pushFront(int val) {
        left.addFirst(val);
        balance();
    }
    public void pushMiddle(int val) {
        if (left.size() > right.size()) {
            right.addFirst(left.removeLast());
        }
        left.addLast(val);
        balance();
    }
    public void pushBack(int val) {
        right.addLast(val);
        balance();
    }
    public int popFront() {
        if (left.isEmpty() && right.isEmpty())
            return -1;
        int val = left.removeFirst();
        balance();
        return val;
    }
    public int popMiddle() {
        if (left.isEmpty() && right.isEmpty())
            return -1;
        int val = left.removeLast();
        balance();
        return val;
    }
    public int popBack() {
        if (left.isEmpty() && right.isEmpty())
            return -1;
        int val;
        if (!right.isEmpty())
            val = right.removeLast();
        else
            val = left.removeLast();
        balance();
        return val;
    }
}