package tests;

import helpers.mockito.NegativeMatcher;
import helpers.mockito.LengthOfQueryMatcher;
import helpers.TestParameters;
import helpers.mockito.MockitoExtension;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import twitter.SearchField;
import twitter.TwitterHomePage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SearchTweetTest {

    @Mock
    private static SearchField searchFieldMock;

    @Test @Tag("simpleTextSearchQuery")
    void simpleTextSearchQueryTweetTest() {
        when(searchFieldMock.getResults(TestParameters.simpleTextQuery)).thenReturn(TwitterHomePage.getSearchResults());

        assertThat(searchFieldMock.getResults(TestParameters.simpleTextQuery)).matches(TwitterHomePage.getSearchResults());
    }

    @Test @Tag("numericSearchQuery")
    void numericSearchQueryTweetTest() {
        when(searchFieldMock.getResults(
                argThat(new LengthOfQueryMatcher())
        )).thenReturn(
                TwitterHomePage.getSearchResults());

        assertThat(searchFieldMock.getResults(TestParameters.numericQuery)).matches(TwitterHomePage.getSearchResults());
    }

    @Test @Tag("emptySearchQuery")
    void emptySearchQueryTweetTest() {
        when(searchFieldMock.getResults(
                argThat(new NegativeMatcher(new LengthOfQueryMatcher()))
        )).thenReturn(
                TwitterHomePage.getInvalidQueryResponseMessage());

        assertThat(searchFieldMock.getResults(TestParameters.emptyQuery)).matches(TwitterHomePage.getInvalidQueryResponseMessage());
    }

    @Test @Tag("tooLongTextSearchQuery")
    void tooLongTextSearchQueryTweetTest() {
        when(searchFieldMock.getResults(
                argThat(new NegativeMatcher(new LengthOfQueryMatcher()))
        )).thenReturn(TwitterHomePage.getInvalidQueryResponseMessage());

        assertThat(searchFieldMock.getResults(TestParameters.tooLongTextQuery)).matches(TwitterHomePage.getInvalidQueryResponseMessage());
    }

    @Test @Tag("randomSearchQuery")
    void randomTextSearchQueryTweetTest() {
        when(searchFieldMock.getResults(TestParameters.randomTextQuery)).thenReturn(TwitterHomePage.getNoResultsFoundResponseMessage());

        assertThat(searchFieldMock.getResults(TestParameters.randomTextQuery)).matches(TwitterHomePage.getNoResultsFoundResponseMessage());
    }

}