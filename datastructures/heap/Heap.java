package datastructures.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    public void insert(int value) {
        heap.add(value);
        int index = heap.size() - 1;
        while (index > 0 && heap.get(parent(index)) < heap.get(index)) {
            swap(index, parent(index));
            index = parent(index);
        }

    }

    public List<Integer> getHeap() {
        return Collections.unmodifiableList(heap);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

}
