import java.util.*;
class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for (int x : target) {
            pq.add((long) x);
            sum += x;
        }
        while (true) {
            long max = pq.poll();
            long rest = sum - max;
            if (max == 1 || rest == 1)
                return true;
            if (rest == 0 || max <= rest)
                return false;
            long prev = max % rest;
            if (prev == 0)
                return false;
            pq.add(prev);
            sum = rest + prev;
        }
    }
}