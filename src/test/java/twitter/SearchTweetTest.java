package twitter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static twitter.SearchQueries.EMPTY;
import static twitter.SearchQueries.LONG;
import static twitter.SearchQueries.NUMERIC;
import static twitter.SearchQueries.RANDOM;
import static twitter.SearchQueries.SIMPLE;

@ExtendWith(MockitoExtension.class)
public class SearchTweetTest {

    @Mock
    private static SearchField searchFieldMock;

    @Test
    void simpleTextSearchQueryTweetTest() {
        when(
                searchFieldMock.getResults(SIMPLE)
        ).thenReturn(
                TwitterHomePage.getSearchResults()
        );

        assertThat(searchFieldMock.getResults(SIMPLE))
                .matches(TwitterHomePage.getSearchResults());
    }

    @Test
    void numericSearchQueryTweetTest() {
        when(searchFieldMock.getResults(argThat(new LengthOfQueryMatcher()))).thenReturn(TwitterHomePage.getSearchResults());

        assertThat(searchFieldMock.getResults(NUMERIC))
                .matches(TwitterHomePage.getSearchResults());
    }

    @Test
    void emptySearchQueryTweetTest() {
        when(
                searchFieldMock.getResults(argThat(new NegativeMatcher(new LengthOfQueryMatcher())))
        ).thenReturn(
                TwitterHomePage.getInvalidQueryResponseMessage()
        );

        assertThat(searchFieldMock.getResults(EMPTY))
                .matches(TwitterHomePage.getInvalidQueryResponseMessage());
    }

    @Test
    void tooLongTextSearchQueryTweetTest() {
        when(
                searchFieldMock.getResults(argThat(new NegativeMatcher(new LengthOfQueryMatcher())))
        ).thenReturn(
                TwitterHomePage.getInvalidQueryResponseMessage()
        );

        assertThat(searchFieldMock.getResults(LONG))
                .matches(TwitterHomePage.getInvalidQueryResponseMessage());
    }

    @Test
    void randomTextSearchQueryTweetTest() {
        when(
                searchFieldMock.getResults(RANDOM)
        ).thenReturn(
                TwitterHomePage.getNoResultsFoundResponseMessage()
        );

        assertThat(searchFieldMock.getResults(RANDOM))
                .matches(TwitterHomePage.getNoResultsFoundResponseMessage());
    }

}