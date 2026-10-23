class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            int flowers = 0;
            int bouquets = 0;

            for (int bloom : bloomDay) {
                if (bloom <= mid) {
                    flowers++;

                    if (flowers == k) {
                        bouquets++;
                        flowers = 0;
                    }
                } else {
                    flowers = 0;
                }
            }

            if (bouquets >= m) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}