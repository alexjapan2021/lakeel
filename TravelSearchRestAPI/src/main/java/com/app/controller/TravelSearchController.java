package com.app.controller;

import org.springframework.web.bind.annotation.RestController;
import com.app.service.travelSearchService;
import searchFormData.formsearch.nearStaionformInput;
import searchFormData.formsearch.publicTransportformInput;
import searchFormData.formsearch.travelSearchformInput;
import searchFormData.formsearch.walkingDistanceformInput;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/travelsearch")
public class TravelSearchController {
	
	private travelSearchService tss = new travelSearchService();
	
	//公共交通機関経路検索API
	@GetMapping("/publictransport")
	public Object getPublicTransportList(@RequestBody publicTransportformInput form) {
		Object jsonData = null;
		try {
			jsonData = tss.jsonFileReadData("./src/main/java/InputData/publicTransportRouteList.json");
		}catch(Exception ex) {	
			ex.printStackTrace();
		}
		return jsonData;
	}
	
	//周辺駅検索API
	@GetMapping("/nearstation")
	public Object getNearStationList(@RequestBody nearStaionformInput form) {
		Object jsonData = null;
		try {
			//TODO 周辺駅検索を行う
			//仮に
			jsonData = tss.jsonFileReadData("./src/main/java/InputData/nearStationList.json");
		}catch(Exception ex) {	
			ex.printStackTrace();
		}
		return jsonData;
	}
	
	//徒歩距離検索API
	@GetMapping("/walkingdistance")
	public Object getWalkingDistanceList(@RequestBody walkingDistanceformInput form) {
		Object jsonData = null;
		try {
			//TODO 
			jsonData = tss.jsonFileReadData("./src/main/java/InputData/walkingDistanceList.json");
		}catch(Exception ex) {	
			ex.printStackTrace();
		}
		return jsonData;
	}
	
	//経路検索API
	@GetMapping("/startToEnd")
	public Object getTravelSearchList(@RequestBody travelSearchformInput form) {
		Object finalTravelSearchResult = null;
		try {
			
			
			//周辺駅検索API(出発地)
			Object departureNS = getNearStationList(new nearStaionformInput(form.departurePlace, form.radius));
			
			//周辺駅検索API(到着地)
			Object arrivalNS = getNearStationList(new nearStaionformInput(form.departurePlace, form.radius));
			
//			for(departureNS;) { //TODO 出発駅リストをLoopで回す
			   //徒歩距離検索API(出発駅)
				Object departurestationDistance = getWalkingDistanceList(new walkingDistanceformInput(form.departurePlace, departureNS.toString())); //出発駅を渡す
//				for(arrivalNS) { //TODO 到着駅リストをLoopで回す
					//徒歩距離検索API(到着駅)
					Object arrivastationDistance = getWalkingDistanceList(new walkingDistanceformInput(form.departurePlace, arrivalNS.toString())); //到着駅を渡す
					
					//公共交通機関経路検索API
					Object publictransportresult = getPublicTransportList(new publicTransportformInput(departureNS.toString(), arrivalNS.toString(), form.sort, form.count));
					
					
					// departurestationDistance + arrivastationDistance + publictransportresult.totaldistance > 2000 // 通勤距離（自宅と勤務場所との徒歩最短距離）および使用する交通機関の総使用区間がそれぞれ2km以上
					//自宅と勤務場所との徒歩最短距離が2000m以下の場合に除外する。
					if(true) { //( > 2000)
						//　departurestationDistance, publictransportresult, arrivastationDistanceをルート結果リストに追加する
						//finalTravelSearchResult
					}
					
//				}
//			}	
			
		   //経路検索結果を返す
		   finalTravelSearchResult = tss.jsonFileReadData("./src/main/java/OutputData/travelList.json");
		
		}catch(Exception ex) {	
			ex.printStackTrace();
		}
		return finalTravelSearchResult;
	}
}
