package com.HeapSortAlgorithm.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.HeapSortAlgorithm.enums.SortingType;
import com.HeapSortAlgorithm.service.HeapSortService;

@Service
public class HeapSortServiceImpl implements HeapSortService {

	private List<Integer> heap = new ArrayList<>();

	public void insert(int[] element) {
		for (int i = 0; i < element.length; i++) {
			heap.add(element[i]);
			heapifyUp();
		}
	}

	public int getMinValue() {
		heapCheck();

		return heap.get(0);
	}

	public int getMaxValue() {
		heapCheck();
		return heap.stream().max(Integer::compareTo).orElseThrow();
	}

	public void delete() {
		heapCheck();

		int lastIndex = heap.size() - 1;
		int lastElement = heap.get(lastIndex);
		heap.set(0, lastElement);
		heap.remove(lastIndex);
		heapifyDown();
	}

	public void clearList() {
		heap.clear();

	}

	private void heapifyUp() {
		int currentIndex = heap.size() - 1;
		while (currentIndex > 0) {
			int parentIndex = (currentIndex - 1) / 2;
			if (heap.get(currentIndex) < heap.get(parentIndex)) {
				int temp = heap.get(currentIndex);
				heap.set(currentIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				currentIndex = parentIndex;
			} else {
				break;
			}
		}
	}

	private void heapifyDown() {
		int currentIndex = 0;
		int heapSize = heap.size();

		while (true) {
			int leftChildIndex = 2 * currentIndex + 1;
			int rightChildIndex = 2 * currentIndex + 2;
			int smallestIndex = currentIndex;

			if (leftChildIndex < heapSize && heap.get(leftChildIndex) < heap.get(smallestIndex)) {
				smallestIndex = leftChildIndex;
			}

			if (rightChildIndex < heapSize && heap.get(rightChildIndex) < heap.get(smallestIndex)) {
				smallestIndex = rightChildIndex;
			}

			if (smallestIndex == currentIndex) {
				break;
			}

			int temp = heap.get(currentIndex);
			heap.set(currentIndex, heap.get(smallestIndex));
			heap.set(smallestIndex, temp);

			currentIndex = smallestIndex;
		}

	}

	private void heapCheck() {
		if (heap.isEmpty()) {
			throw new IllegalStateException("Heap is empty");
		}
	}

	public int[] applySortingBasedOnType(int[] arr, SortingType sortingType, Boolean isSortingApply) {
		int n = arr.length;

		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i, sortingType);
		}
		if (isSortingApply) {
			for (int i = n - 1; i > 0; i--) {
				int temp = arr[0];
				arr[0] = arr[i];
				arr[i] = temp;

				heapify(arr, i, 0, sortingType);
			}
		}
		return arr;
	}

	private void heapify(int[] arr, int n, int i, SortingType sortType) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && ((arr[left] > arr[largest] && sortType.equals(SortingType.MAX))
				|| (arr[left] < arr[largest] && sortType.equals(SortingType.MIN)))) {
			largest = left;
		}

		if (right < n && ((arr[right] > arr[largest] && sortType.equals(SortingType.MAX))
				|| (arr[right] < arr[largest] && sortType.equals(SortingType.MIN)))) {
			largest = right;
		}
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			heapify(arr, n, largest, sortType);
		}
	}

}
