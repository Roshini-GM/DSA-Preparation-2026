class Solution {
    public int thirdMax(int[] nums) {
        Long first = null, second = null, third = null;
        for (int n : nums) {
            long x = n;
            if (first != null && x == first) continue;
            if (second != null && x == second) continue;
            if (third != null && x == third) continue;
            if (first == null || x > first) {
                third = second;
                second = first;
                first = x;
            } else if (second == null || x > second) {
                third = second;
                second = x;
            } else if (third == null || x > third) {
                third = x;
            }
        }
        return third == null ? first.intValue() : third.intValue();
    }
}