package com.espresoh;

import com.pipl.api.search.SearchAPIError;
import com.pipl.api.search.SearchAPIRequest;
import com.pipl.api.search.SearchAPIResponse;
import com.pipl.api.search.SearchConfiguration;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main( String[] args ) {
        String emailAddress = args.length >= 1 ? args[0] : "";
        String apiTypeRequest = args.length >=2 ? args[1]: "";

        SearchConfiguration configurationBusiness = new SearchConfiguration();
        SearchConfiguration configurationSocial = new SearchConfiguration();
        SearchConfiguration configurationContact = new SearchConfiguration();

        configurationBusiness.apiKey = DemoApiKeysByDomain.BUSINESS.getApiKey();
        configurationSocial.apiKey = DemoApiKeysByDomain.SOCIAL.getApiKey();
        configurationContact.apiKey = DemoApiKeysByDomain.CONTACT.getApiKey();

        switch(apiTypeRequest) {
            case "business":
                try {
                    searchAPIRequestBusiness(emailAddress, configurationBusiness);
                } catch (IOException | SearchAPIError e) {
                    logger.log(Level.SEVERE, e.getMessage());
                }
                break;
            case "social":
                try {
                    searchAPIRequestSocial(emailAddress, configurationSocial);
                } catch (IOException | SearchAPIError e) {
                    logger.log(Level.SEVERE, e.getMessage());
                }
                break;
            case "contact":
                try {
                    searchAPIRequestContact(emailAddress, configurationContact);
                } catch (IOException | SearchAPIError e) {
                    logger.log(Level.SEVERE, e.getMessage());
                }
                break;
            default:
                logger.log(Level.INFO, "Please provide an api type request: business, social or contact as a parameter. Also check for a valid email address.");
        }

    }

    private static void searchAPIRequestBusiness(String emailAddress, SearchConfiguration configurationBusiness) throws IOException, SearchAPIError {
        SearchAPIRequest requestBusiness = new SearchAPIRequest.Builder().email(emailAddress).configuration(configurationBusiness).build();
        SearchAPIResponse responseBusiness  = requestBusiness.send();
        logger.log(Level.INFO, responseBusiness.getJson());
    }

    private static void searchAPIRequestSocial(String emailAddress, SearchConfiguration configurationSocial) throws IOException, SearchAPIError {
        SearchAPIRequest requestSocial = new SearchAPIRequest.Builder().email(emailAddress).configuration(configurationSocial).build();
        SearchAPIResponse responseSocial  = requestSocial.send();
        logger.log(Level.INFO, responseSocial.getJson());
    }

    private static void searchAPIRequestContact(String emailAddress, SearchConfiguration configurationContact) throws IOException, SearchAPIError {
        SearchAPIRequest requestContact = new SearchAPIRequest.Builder().email(emailAddress).configuration(configurationContact).build();
        SearchAPIResponse responseContact  = requestContact.send();
        logger.log(Level.INFO, responseContact.getJson());
    }
}
