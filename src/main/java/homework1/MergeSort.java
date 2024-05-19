package homework1;

import java.util.Comparator;
public class MergeSort {
    public static void sort(Entry[] entries) {
        mergeSort(entries, 0, entries.length - 1);
    }

    private static void mergeSort(Entry[] entries, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(entries, low, mid);
            mergeSort(entries, mid + 1, high);
            merge(entries, low, mid, high);
        }
    }

    private static void merge(Entry[] entries, int low, int mid, int high) {
        Entry[] temp = new Entry[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (entries[i].compareTo(entries[j]) <= 0) {
                temp[k++] = entries[i++];
            } else {
                temp[k++] = entries[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = entries[i++];
        }
        while (j <= high) {
            temp[k++] = entries[j++];
        }
        for (int idx = 0; idx < temp.length; idx++) {
            entries[low + idx] = temp[idx];
        }
    }
}