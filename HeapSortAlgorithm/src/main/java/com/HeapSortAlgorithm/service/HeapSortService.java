package com.HeapSortAlgorithm.service;

import com.HeapSortAlgorithm.enums.SortingType;

public interface HeapSortService {

	void insert(int[] element);

	int getMaxValue();

	int getMinValue();

	void delete();

	void clearList();

	int[] applySortingBasedOnType(int[] arr, SortingType sortingType, Boolean isSortingApply);

	
}
