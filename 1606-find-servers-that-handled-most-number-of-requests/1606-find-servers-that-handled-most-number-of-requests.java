import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        TreeSet<Integer> free = new TreeSet<>();
        int[] count = new int[k];

        for (int i = 0; i < k; i++) {
            free.add(i);
        }

        for (int i = 0; i < arrival.length; i++) {
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                free.add(busy.poll()[1]);
            }

            if (free.isEmpty()) continue;

            Integer server = free.ceiling(i % k);

            if (server == null) {
                server = free.first();
            }

            free.remove(server);
            count[server]++;

            busy.offer(new int[]{arrival[i] + load[i], server});
        }

        int max = 0;
        for (int c : count) {
            max = Math.max(max, c);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                result.add(i);
            }
        }

        return result;
    }
}