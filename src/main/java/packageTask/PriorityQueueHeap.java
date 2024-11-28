package packageTask;

class PriorityQueueHeap {
    private class Node {
        int value;
        int priority;

        Node(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }

    private Node[] heap;
    private int size;

    public PriorityQueueHeap(int capacity) {
        heap = new Node[capacity];
        size = 0;
    }

    public void insert(int value, int priority) {
        if (size == heap.length) {
            throw new IllegalStateException("Heap is full");
        }
        heap[size] = new Node(value, priority);
        siftUp(size);
        size++;
    }

    public int extractMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        Node max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);
        return max.value;
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap[index].priority > heap[parent].priority) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void siftDown(int index) {
        while (2 * index + 1 < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int maxIndex = left;
            if (right < size && heap[right].priority > heap[left].priority) {
                maxIndex = right;
            }
            if (heap[index].priority >= heap[maxIndex].priority) {
                break;
            }
            swap(index, maxIndex);
            index = maxIndex;
        }
    }

    private void swap(int i, int j) {
        Node temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}

