package introtdd.ch05di;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SalesAnalysisServiceTest {
    private static final List<Sale> exampleSales = Arrays.asList(
            new Sale("Apples", "Cardiff", 10, 2),
            new Sale("Oranges", "Cardiff", 3, 5),
            new Sale("Bananas", "Cardiff", 6, 20),
            new Sale("Oranges", "London", 5, 7)
    );
    private static final Map<String, Integer> expectedStoreSales = Map.of(
            "Cardiff", 155,
            "London", 35
    );

    @Test
    public void shouldAggregateStoreSales_manually() {
        SalesRepository stubRepo = () -> exampleSales;

        SalesAnalysisService service = new SalesAnalysisService(stubRepo);

        var result = service.tallyStoreSales();
        assertThat(result, is(expectedStoreSales));
    }

    @Test
    public void shouldAggregateStoreSales_usingMockito() {
        SalesRepository mockRepo = mock(SalesRepository.class);
        when(mockRepo.loadSales()).thenReturn(exampleSales);

        SalesAnalysisService service = new SalesAnalysisService(mockRepo);

        var result = service.tallyStoreSales();
        assertThat(result, is(expectedStoreSales));
        verify(mockRepo).loadSales();
    }
}
