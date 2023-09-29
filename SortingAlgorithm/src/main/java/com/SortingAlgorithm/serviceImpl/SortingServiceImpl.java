package com.SortingAlgorithm.serviceImpl;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.SortingAlgorithm.exceptions.InvalidArrayInputException;
import com.SortingAlgorithm.exceptions.SortingException;
import com.SortingAlgorithm.service.SortingService;

@Service
public class SortingServiceImpl implements SortingService {

	public int[] sortingAlgo(int[] arr) {

		try {
			int size = arr.length;
			int max = 0;
			for (int i = 0; i < size; i++) {
				if (arr[i] < 0) {
					throw new InvalidArrayInputException("negative number are not allowed");
				}
				max = Math.max(max, arr[i]);
			}
			int[] countingArray = new int[max + 1];
			int[] outputArray = new int[size];
			Arrays.fill(countingArray, 0);

			for (int i = 0; i < size; i++) {
				countingArray[arr[i]]++;
			}

			for (int i = 1; i <= max; i++) {
				countingArray[i] += countingArray[i - 1];
			}
			for (int i = size - 1; i >= 0; i--) {
				outputArray[countingArray[arr[i]] - 1] = arr[i];
				countingArray[arr[i]]--;
			}

			return outputArray;
		} catch (InvalidArrayInputException ex) {
			throw ex;
		} catch (Exception e) {
			throw new SortingException(e.getMessage());
		}
	}

}
