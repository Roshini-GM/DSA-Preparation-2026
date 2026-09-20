class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        for (int size = n; size > 1; size--) {
            int maxIndex = 0;
            for (int i = 1; i < size; i++) {
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }
            if (maxIndex == size - 1)
                continue;
            if (maxIndex != 0) {
                reverse(arr, maxIndex);
                ans.add(maxIndex + 1);
            }
            reverse(arr, size - 1);
            ans.add(size);
        }
        return ans;
    }
    private void reverse(int[] arr, int end) {
        int left = 0, right = end;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}