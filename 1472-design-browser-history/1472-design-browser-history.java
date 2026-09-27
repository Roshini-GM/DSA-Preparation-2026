import java.util.*;
class BrowserHistory {
    ArrayList<String> history = new ArrayList<>();
    int current = 0;
    public BrowserHistory(String homepage) {
        history.add(homepage);
    }
    public void visit(String url) {
        current++;
        while (history.size() > current) {
            history.remove(history.size() - 1);
        }
        history.add(url);
    }
    public String back(int steps) {
        current = Math.max(0, current - steps);
        return history.get(current);
    }
    public String forward(int steps) {
        current = Math.min(history.size() - 1, current + steps);
        return history.get(current);
    }
}