package com.HeapSortAlgorithm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HeapSortAlgorithm.enums.SortingType;
import com.HeapSortAlgorithm.service.HeapSortService;

@RestController
@RequestMapping("/api")
public class HeapSortController {

	@Autowired
	private HeapSortService heapSortService;

	@PostMapping("/insert")
	public void insertValues(@RequestBody int[] arr) {
		heapSortService.insert(arr);
	}

	@GetMapping("/max")
	public int getMaxValue() {
		return heapSortService.getMaxValue();
	}
  
	@GetMapping("/min")
	public int getMinValue() {
		return heapSortService.getMinValue();
	}

	@PostMapping("/applyMinHeap")
	public int[] applyMinHeap(@RequestBody int[] arr) {
		return heapSortService.applySortingBasedOnType(arr, SortingType.MIN, false);
	}

	@PostMapping("/applyMaxHeap")
	public int[] applyMaxHeap(@RequestBody int[] arr) {
		return heapSortService.applySortingBasedOnType(arr, SortingType.MAX, false);

	}

	@PostMapping("/applyMinHeapSort")
	public int[] applyMinHeapSort(@RequestBody int[] arr) {
		return heapSortService.applySortingBasedOnType(arr, SortingType.MIN, true);
	}

	@PostMapping("/applyMaxHeapSort")
	public int[] applyMaxHeapSort(@RequestBody int[] arr) {
		return heapSortService.applySortingBasedOnType(arr, SortingType.MAX, true);

	}

	@DeleteMapping("/clearlist")
	public void clearList() {
		heapSortService.clearList();
	}

	@DeleteMapping("/deletemin")
	public void delete() {
		heapSortService.delete();
	}
}
