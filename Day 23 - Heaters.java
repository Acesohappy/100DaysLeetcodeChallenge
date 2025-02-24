class Solution {
        public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int min = Integer.MIN_VALUE;
        for (int house : houses) {
            int ind = findClosest(heaters, house);
            min = Math.max(min, Math.abs(heaters[ind] - house));
        }
        return min;
    }
    private int findClosest(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (Math.abs(array[mid] - target) < Math.abs(array[result] - target)) {
                result = mid;
            }
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
}
}
