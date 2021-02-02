package se.comhem.test.montyhall;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import se.comhem.test.montyhall.service.MontyService;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MontyServiceTest {

    MontyService montyMock = mock(MontyService.class);

    @Test
    public void testGetMonty() {

        when(montyMock.getRandomDoor()).thenReturn(1, 2, 1, 2);
        when(montyMock.getMonty(100, false)).thenCallRealMethod();

        int monty = montyMock.getMonty(100, false);
        System.out.println("Monty: " + monty);

        Assert.assertEquals(null, 98, monty);
    }
}
