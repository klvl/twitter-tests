package twitter;

import org.mockito.InjectMocks;

public class TwitterHomePage {

    @InjectMocks
    private static SearchField searchField;

    public static String getInvalidQueryResponseMessage() {
        return "Sorry, you entered an invalid query. Please try your search again.";
    }

    public static String getSearchResults() {
        return "Here is list of tweets which according to the search query";
    }

    public static String getNoResultsFoundResponseMessage() {
        return "The term you entered did not bring up any results. " +
                "You may have mistyped your term or your search setting could be protecting you from some potentially " +
                "sensitive content.";
    }

    public String search(String searchQuery) {
        return searchField.getResults(searchQuery);
    }

}