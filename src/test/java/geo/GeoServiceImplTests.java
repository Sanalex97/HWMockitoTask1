package geo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class GeoServiceImplTests {
    @ParameterizedTest
    @MethodSource("source")
    public void TestByIp(String ip, Location location) {
        assertThat(new GeoServiceImpl().byIp(ip), equalTo(location));
    }

    static Stream<Arguments> source() {
        return Stream.of(
                arguments(GeoServiceImpl.LOCALHOST, new Location(null, null, null, 0)),
                arguments(GeoServiceImpl.MOSCOW_IP, new Location("Moscow", Country.RUSSIA, "Lenina", 15)),
                arguments(GeoServiceImpl.NEW_YORK_IP, new Location("New York", Country.USA, " 10th Avenue", 32)),
                arguments(" ", null)
        );
    }
}
