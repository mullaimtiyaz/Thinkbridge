package testData;

import pageFactory.RandomDataGenerator;

public class TestData {

	public String englishOption = "English";
	
	public String dutchOption = "Dutch";
	
	public String userName = RandomDataGenerator.generateRandomStringOfLength(7);
	
	public String userOrganizatioName= "Think Bridge";
	
	public String userEmail = RandomDataGenerator.getRandomEmailAddress(6);
	
	public String alertMessage = "A welcome email has been sent. Please check your email.";
	
}
