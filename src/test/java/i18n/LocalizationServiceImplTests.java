package i18n;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LocalizationServiceImplTests {
    @ParameterizedTest
    @MethodSource("source")
    public void TestLocale(Country country, String messages) {
        assertThat(new LocalizationServiceImpl().locale(country), equalTo(messages));
    }

    static Stream<Arguments> source() {
        return Stream.of(
                arguments(Country.RUSSIA, "Добро пожаловать"),
                arguments(Country.USA, "Welcome"),
                arguments(Country.BRAZIL, "Welcome"),
                arguments(Country.GERMANY, "Welcome")
        );
    }
}
