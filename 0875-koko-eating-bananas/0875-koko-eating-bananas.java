class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int l = 1;
        int r = max;

        while (l < r) {
            int mid = l + (r - l) / 2;
            long hours = 0;

            for (int pile : piles) {
                hours += (pile + (long) mid - 1) / mid;
            }

            if (hours <= h) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}