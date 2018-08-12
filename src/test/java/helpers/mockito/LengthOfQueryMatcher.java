package helpers.mockito;

import org.mockito.ArgumentMatcher;

public class LengthOfQueryMatcher implements ArgumentMatcher<Object> {

    @Override
    public boolean matches(Object input) {
        return input.toString().length() > 0 && input.toString().length() < 500;
    }
}