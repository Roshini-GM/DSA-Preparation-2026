import java.util.*;
class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    LinkedList<String> result = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0),
                    k -> new PriorityQueue<>()).offer(ticket.get(1));
        }
        dfs("JFK");
        return result;
    }
    void dfs(String airport) {
        PriorityQueue<String> pq = map.get(airport);
        while (pq != null && !pq.isEmpty()) {
            String next = pq.poll();
            dfs(next);
        }
        result.addFirst(airport);
    }
}