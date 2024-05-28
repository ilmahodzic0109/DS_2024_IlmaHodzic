package homework2;

public class ProcessQueue {
    public Process[] pq = new Process[2];
    public int length = 0;

    /* Add a new process into the priority queue */
    public void addProcess(Process process) {
        if (length == pq.length) {
            resize(2 * pq.length);
        }
        pq[length] = process;
        swim(length);
        length++;
    }

    /* Return and remove the next Process that should be run */
    public Process runNextProcess() {
        if (length == 0) {
            return null;
        }
        Process min = pq[0];
        swap(0, length - 1);
        pq[length - 1] = null;
        length--;
        sink(0);
        if (length > 0 && length == pq.length / 4) {
            resize(pq.length / 2);
        }
        return min;
    }

    /* Return the next Process that should be run (but do not delete it) */
    public Process peekNextProcess() {
        if (length == 0) {
            return null;
        }
        return pq[0];
    }

    /* Helper method to swim up element at index k  */
    private void swim(int k) {
        while (k > 0 && greater((k - 1) / 2, k)) {
            swap(k, (k - 1) / 2);
            k = (k - 1) / 2;
        }
    }

    /* Helper method to sink down element at index k */
    private void sink(int k) {
        while (2 * k + 1 < length) {
            int j = 2 * k + 1;
            if (j < length - 1 && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    /* Helper method to swap elements at i and j */
    private void swap(int i, int j) {
        Process temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /* Helper method to resize array */
    private void resize(int capacity) {
        Process[] temp = new Process[capacity];
        for (int i = 0; i < length; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }
    /* Helper method to check if element at index i is greater than  element at index j */
    private boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }
}