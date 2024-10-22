package stepDefination;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeClass() throws IOException {

		StepDefination k = new StepDefination();
		if (StepDefination.place_Id == null) {
			k.add_place_payload_with("kiranReddy", "marati", "Maharastra");
			k.user_call_with_http_request("AddPlaceAPI", "POST");
			k.verify_with_the_place_id_as_with("kiranReddy", "GetPlaceAPI");
		}
	}
}
