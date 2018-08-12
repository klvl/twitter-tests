package helpers.mockito;

import org.mockito.ArgumentMatcher;

public class NegativeMatcher implements ArgumentMatcher<Object> {

    private ArgumentMatcher<Object> originalMatcher;

    public NegativeMatcher(ArgumentMatcher<Object> originalMatcher) {
        this.originalMatcher = originalMatcher;
    }

    @Override
    public boolean matches(Object argument) {
        return !this.originalMatcher.matches(argument);
    }
}