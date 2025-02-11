package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuilder {
	
	
	public AddPlace addPlacePayload(String name, String language, String address) {
		AddPlace p=new AddPlace();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhone_number("(+91) 983 893 3937");
		p.setName(name);
		p.setWebsite("https://kiranreddy.tech.com");
		
		List<String> type=new ArrayList<String>();
		type.add("tech park");
		type.add("shop");
		
		p.setTypes(type);
		
		Location l=new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		
		return p;
	}
	public String deletePayload(String place_Id) {
		return "{ \r\n"
				+ "\r\n"
				+ "    \"place_id\":\""+place_Id+"\" \r\n"
				+ "\r\n"
				+ "} ";
	}

}
