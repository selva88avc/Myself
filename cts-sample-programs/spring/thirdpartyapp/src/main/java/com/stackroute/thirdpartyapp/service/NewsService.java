package com.stackroute.thirdpartyapp.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.stackroute.thirdpartyapp.model.NewsData;

@Service
public class NewsService {
	
	
	public NewsData getData()
	{
	RestTemplate resttemp=new RestTemplate();
	 
String url="https://newsapi.org/v2/top-headlines?country=us&apiKey=7f118af83e1b48f6939fc5096e89fd22";
NewsData result=resttemp.getForObject(url,NewsData.class);

	return result;


	}
}
