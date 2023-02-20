package twitter;

import org.mockito.InjectMocks;

public class TwitterHomePage {

    @InjectMocks
    private static SearchField searchField;

    private static String
            invalidQueryResponseMessage = "Sorry, you entered an invalid query. Please try your search again.",
            searchResults = "Here is list of tweets which according to the search query",
            noResultsFoundResponseMessage = "The term you entered did not bring up any results. You may have mistyped your term or your search setting could be protecting you from some potentially sensitive content.";

    public static String getInvalidQueryResponseMessage() {
        return invalidQueryResponseMessage;
    }

    public static String getSearchResults() {
        return searchResults;
    }

    public static String getNoResultsFoundResponseMessage() {
        return noResultsFoundResponseMessage;
    }

    public String search(String searchQuery) {
        return searchField.getResults(searchQuery);
    }

}