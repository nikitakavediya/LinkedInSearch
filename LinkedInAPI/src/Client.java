import java.util.EnumMap;
import java.util.Map;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.enumeration.ProfileType;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.Person;


public class Client {
	public static void main(String args[])
	{
//		String url = "http://www.linkedin.com/pub/ca-santosh-dhoka/9/842/b52";
		String str="GS LAB";
		String consumerKeyValue="75sl5smxiiolx9";
		String consumerSecretValue="S9LCMnuXqxO1NTJz";
		String accessTokenValue="2af91f19-7ad4-43df-a1a9-2a30de34af78";
		String tokenSecretValue="d2667d45-6e6d-4133-8a2b-81d594fe25a5";

		final LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance(consumerKeyValue, consumerSecretValue);
		final LinkedInApiClient client = factory.createLinkedInApiClient(accessTokenValue, tokenSecretValue);
		
	/*	Person profile = client.getProfileByUrl(url, ProfileType.STANDARD);
		System.out.println("Name:" + profile.getFirstName() + " " + profile.getLastName());
		System.out.println("Headline:" + profile.getHeadline());
		System.out.println("Summary:" + profile.getSummary());
		System.out.println("Industry:" + profile.getIndustry());
		System.out.println("Picture:" + profile.getPictureUrl());*/
		
		Connections connections = client.getConnectionsForCurrentUser();
		int counter=0;
	//	System.out.println("Total connections fetched:" + connections.getTotal());
		for (Person person : connections.getPersonList()) {
			
			boolean flag=person.getHeadline().toLowerCase().contains(str.toLowerCase());
			
			if(flag)
			{
				System.out.println(person.getId() + ":" + person.getFirstName() + " " + person.getLastName() + ":" + person.getHeadline());
				counter++;
			}
			
		}
		System.out.println("Total connections fetched:" + counter);
		/*
		Map<SearchParameter, String> searchParameters = new EnumMap<SearchParameter, String>(SearchParameter.class);
		searchParameters.put(SearchParameter.KEYWORDS, "Pune");
	//	searchParameters.put(SearchParameter.COMPANY_NAME, "GS Lab");

		People people = client.searchPeople(searchParameters);
		System.out.println("Total search result:" + people.getCount());
		for (Person person : people.getPersonList()) {
		        System.out.println(person.getId() + ":" + person.getFirstName() + " " + person.getLastName() + ":" + person.getHeadline());*/
//		}

	}
}
