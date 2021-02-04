package se.comhem.test.montyhall;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import se.comhem.test.montyhall.domain.MontyGame;
import se.comhem.test.montyhall.service.MontyService;
import static org.mockito.MockitoAnnotations.initMocks;

import static org.mockito.Mockito.*;

public class MontyServiceTest {

    @Mock
    MontyGame montyGameMock;

    @InjectMocks
    MontyService montyServiceMock;

    @Before
    public void setup()  {
        initMocks(this);
    }

    @Test
    public void testGetMonty() {
        when(montyGameMock.play(false)).thenReturn(true);
        Assert.assertEquals(null, 10, montyServiceMock.getWins(10, false));
    }
}
