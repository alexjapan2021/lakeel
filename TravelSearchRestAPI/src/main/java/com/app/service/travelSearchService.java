package com.app.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class travelSearchService {
	
	//JSONファイルを読込
	public String jsonFileReadData(String filePath) throws IOException {
		String jsonData;

		File json = new File(filePath);
		FileReader fr=new FileReader(json);
		BufferedReader br=new BufferedReader(fr);
		StringBuilder sb=  new StringBuilder();
		while((jsonData = br.readLine())!=null)
		{
		    sb.append(jsonData);
		}
		jsonData = sb.toString();
		br.close();
		return jsonData;
	}
}
