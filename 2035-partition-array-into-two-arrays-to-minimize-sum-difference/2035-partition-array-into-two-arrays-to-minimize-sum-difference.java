
class Solution {
    public int minimumDifference(int[] nums) {

        int n = nums.length / 2;

        List<Long>[] left = new ArrayList[n + 1];
        List<Long>[] right = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            left[i] = new ArrayList<>();
            right[i] = new ArrayList<>();
        }

        long total = 0;

        for (int x : nums) {
            total += x;
        }

        // Generate subset sums for both halves
        for (int mask = 0; mask < (1 << n); mask++) {

            long sum1 = 0;
            long sum2 = 0;

            int count1 = 0;
            int count2 = 0;

            for (int j = 0; j < n; j++) {

                if ((mask & (1 << j)) != 0) {
                    sum1 += nums[j];
                    count1++;

                    sum2 += nums[j + n];
                    count2++;
                }
            }

            left[count1].add(sum1);
            right[count2].add(sum2);
        }

        // Sort right subset sums
        for (int i = 0; i <= n; i++) {
            Collections.sort(right[i]);
        }

        long ans = Long.MAX_VALUE;

        // Select k elements from left
        for (int k = 0; k <= n; k++) {

            // Remaining n-k elements from right
            List<Long> list = right[n - k];

            for (long sum : left[k]) {

                // Binary search
                int low = 0;
                int high = list.size();

                while (low < high) {

                    int mid = low + (high - low) / 2;

                    long combined = sum + list.get(mid);

                    if (2 * combined >= total) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }

                // Check current position
                if (low < list.size()) {

                    long combined = sum + list.get(low);

                    ans = Math.min(
                        ans, Math.abs(total - 2 * combined)
                    );
                }

                // Check previous position
                if (low > 0) {

                    long combined = sum + list.get(low - 1);

                    ans = Math.min(
                        ans, Math.abs(total - 2 * combined)
                    );
                }
            }
        }

        return (int) ans;
    }
}
