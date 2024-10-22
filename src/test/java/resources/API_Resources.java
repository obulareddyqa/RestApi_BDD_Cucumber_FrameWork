package resources;

public enum API_Resources {
	
	AddPlaceAPI("/maps/api/place/add/json"),
    GetPlaceAPI("/maps/api/place/get/json"),
    DeletePlaceAPI("/maps/api/place/delete/json");
	private String resource;
	API_Resources(String resource){
		this.resource=resource;
	}
	
	public String getResource() {
		return resource;
	}
	

}
