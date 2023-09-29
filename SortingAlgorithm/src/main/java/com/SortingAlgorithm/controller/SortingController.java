package com.SortingAlgorithm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SortingAlgorithm.service.SortingService;

@RestController

public class SortingController {

	@Autowired
	private SortingService sortingService;
	
	@PostMapping("/sortarray")
	public int [] sort(@RequestBody int[] arr)
	{
		return sortingService.sortingAlgo(arr);
	}
	
	
}
