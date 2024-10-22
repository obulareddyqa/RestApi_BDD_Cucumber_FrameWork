Feature: validating Place API

@AddPlace
Scenario Outline: verify if place is being added successfully
    Given Add place Payload with "<name>" "<language>" "<address>"
    When user call "AddPlaceAPI" with "post" http request
    Then the api call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify with the PlaceId as "<name>" with "GetPlaceAPI"
    
Examples: 
	  |name         |language|address                      |
	  |AndhraPradesh|Telugu  |99, side layout, cohen 09    |
#  |Karnataka    |Kannada |89, prasanth layout, bohen 06|

@DeletePlace
Scenario: verify if delete place API is working 
		Given delete place payload
		When user call "DeletePlaceAPI" with "post" http request
		Then the api call got success with status code 200
    And "status" in response body is "OK"