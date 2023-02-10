package searchFormData;

import lombok.Data;

@Data
public class formsearch {
	
	//公共交通機関経路検索
	public static class publicTransportformInput{
		public String departure;
		public String destination;
		public String sort = "time";
		public Integer count = 20;
		
		public publicTransportformInput(String departure, String destination, String sort, Integer count) {
			this.departure = departure;
			this.destination = destination;
			this.sort = sort;
			this.count = count;
		}
	}
	
	//周辺駅検索
	public static class nearStaionformInput{
		public String address;
		public Integer radius = 1000;
		
		public nearStaionformInput(String address, Integer radius) {
			this.address = address;
			this.radius = radius;
		}
	}
	
	//徒歩距離検索
	public static class walkingDistanceformInput{
		public String origin;
		public String destination;
		
		public walkingDistanceformInput(String origin, String destination) {
			this.origin = origin;
			this.destination = destination;
		}
	}
	
	//経路検索
	public static class travelSearchformInput{
		public String departurePlace;
		public String arrivalPlace;
		public String sort = "time";
		public Integer count;
		public Integer radius;
	}
	
}
