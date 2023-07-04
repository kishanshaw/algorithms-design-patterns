package datastructures;

public class BinaryHeap {
    private int[] arr;
    private int capacity;
    private int size;

    public BinaryHeap(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public int leftChild(int i) {
        return 2 * i + 1;
    }

    public int rightChild(int i) {
        return 2 * i + 2;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public void insert(int value) {
        if (this.capacity == this.size) {
            System.out.println("Heap is full on capacity");
        } else {
            size++;
            arr[size - 1] = value;
            for (int i = size - 1; i != 0 && arr[parent(i)] > arr[i]; i = parent(i)) {
                swap(arr, parent(i), i);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] getArr() {
        return this.arr;
    }

    public void minHeapify(int i) {
        int leftChild = leftChild(i), rightChild = rightChild(i);
        int smallest = i;
        if (leftChild < size && arr[leftChild] < arr[i]) {
            smallest = leftChild;
        }
        if (rightChild < size && arr[rightChild] < arr[smallest]) {
            smallest = rightChild;
        }
        if (smallest != i) {
            swap(arr, i, smallest);
            minHeapify(smallest);
        }
    }

    public void minHeapifyIterative(int i) {
        boolean isDone = false;
        while (!isDone) {
            int left = leftChild(i);
            int right = rightChild(i);
            int smallest = i;
            if (left < size && arr[left] < arr[i]) {
                smallest = left;
            }
            if (right < size && arr[right] < arr[smallest]) {
                smallest = right;
            }

            if (smallest != i) {
                swap(arr, i, smallest);
            } else {
                isDone = true;
            }
        }
    }

    public int extractMin() {
        if (size == 0) {
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            size--;
            return arr[0];
        } else {
            swap(arr, 0, size - 1);
            size--;
            minHeapify(0);
            return arr[size];
        }
    }

    public void decreaseKey(int index, int newVal) {
        arr[index] = newVal;
        while (index != 0 && arr[index] < arr[parent(index)]) {
            swap(arr, index, parent(index));
            index = parent(index);
        }
    }

    public void deleteKey(int index) {
        arr[index] = Integer.MIN_VALUE;
        extractMin();
    }
}
