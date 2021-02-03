package se.comhem.test.montyhall;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import se.comhem.test.montyhall.domain.MontyGame;
import se.comhem.test.montyhall.service.MontyService;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MontyServiceTest {

    @Mock
    MontyGame montyGameMock;

    @Test
    public void testGetMonty() {
        MontyService montyServiceMock = new MontyService(montyGameMock);
        when(montyGameMock.play(false)).thenReturn(true);
        Assert.assertEquals(null, 10, montyServiceMock.getMonty(10, false));
    }
}
