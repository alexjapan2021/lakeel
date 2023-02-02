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
	}
	
	//周辺駅検索
	public static class nearStaionformInput{
		public String address;
		public Integer radius = 1000;
	}
	
	//徒歩距離検索
	public static class walkingDistanceformInput{
		public String origin;
		public String destination;
	}
	
}
