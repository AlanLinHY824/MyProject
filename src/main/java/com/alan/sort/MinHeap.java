package com.alan.sort;

import java.util.ArrayList;

class MinHeap {
    private ArrayList<Integer> heap;

    // 构造函数，初始化堆
    public MinHeap() {
        heap = new ArrayList<>();
    }

    // 获取父节点的索引
    private int parent(int i) {
        return (i - 1) / 2;
    }

    // 获取左子节点的索引
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    // 获取右子节点的索引
    private int rightChild(int i) {
        return 2 * i + 2;
    }

    // 交换堆中两个元素的位置
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // 插入元素到堆中
    public void insert(int item) {
        heap.add(item);
        int currentIndex = heap.size() - 1;
        heapifyUp(currentIndex);
    }

    // 上浮操作，将元素调整到合适位置
    private void heapifyUp(int i) {
        while (i > 0 && heap.get(parent(i)) > heap.get(i)) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // 提取堆中的最小元素
    public int extractMin() {
        if (heap.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        if (heap.size() == 1) {
            return heap.remove(0);
        }
        int root = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        heapifyDown(0);
        return root;
    }

    // 下沉操作，将元素调整到合适位置
    private void heapifyDown(int i) {
        int smallest = i;
        int left = leftChild(i);
        int right = rightChild(i);
        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }
        if (smallest!= i) {
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }

    // 测试用的 main 方法
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        System.out.println(minHeap.extractMin()); // 输出 3
        System.out.println(minHeap.extractMin()); // 输出 5
        System.out.println(minHeap.extractMin()); // 输出 6
    }
}