package com.stackroute.thirdpartyapp.controller;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.thirdpartyapp.model.Article;
import com.stackroute.thirdpartyapp.model.NewsData;
import com.stackroute.thirdpartyapp.service.NewsService;

@RestController
public class NewsController {
	
	@Autowired
	NewsService service;
	
	
	@RequestMapping(value="/viewNews",method=RequestMethod.GET,consumes=MediaType.ALL_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getdata()
	{
	NewsData data=service.getData();
	
	List<Article> articles= Arrays.asList(data.getArticles());
	
	return new ResponseEntity<List<Article>>(articles,HttpStatus.OK);
		
	}

}
