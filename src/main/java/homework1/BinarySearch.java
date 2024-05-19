package homework1;

public class BinarySearch {
    public static int[] search(Entry[] entries, String searchableName) {
        int[] result = new int[2];
        result[0] = findStartIndex(entries, searchableName);
        result[1] = findEndIndex(entries, searchableName);
        return result;
    }

    private static int findStartIndex(Entry[] entries, String name) {
        int low = 0, high = entries.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (entries[mid].getFullName().compareTo(name) >= 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int findEndIndex(Entry[] entries, String name) {
        int low = 0, high = entries.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (entries[mid].getFullName().compareTo(name) <= 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}