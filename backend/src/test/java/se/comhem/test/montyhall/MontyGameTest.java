package se.comhem.test.montyhall;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.junit.Assert;
import se.comhem.test.montyhall.domain.MontyGame;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;


public class MontyGameTest {

    @Mock
    MontyGame montyGameMock;

    @Before
    public void setup()  {
        initMocks(this);
    }

    @Test
    public void testPlayNoSwitch() {
        when(montyGameMock.playNoSwitch()).thenCallRealMethod();

        when(montyGameMock.getRandomDoor()).thenReturn(1);
        Assert.assertTrue(null, montyGameMock.playNoSwitch());

        when(montyGameMock.getRandomDoor()).thenReturn(0,2);
        Assert.assertFalse(null, montyGameMock.playNoSwitch());
    }

    @Test
    public void testPlayWithSwitch() {
        when(montyGameMock.playWithSwitch()).thenCallRealMethod();

        when(montyGameMock.getRandomDoor()).thenReturn(1);
        Assert.assertFalse(null, montyGameMock.playWithSwitch());

        when(montyGameMock.getRandomDoor()).thenReturn(1, 2);
        Assert.assertTrue(null, montyGameMock.playWithSwitch());
    }

    @Test
    public void testPlay() {
        when(montyGameMock.play(true)).thenCallRealMethod();

        when(montyGameMock.playWithSwitch()).thenReturn(true);
        Assert.assertTrue(null, montyGameMock.play(true));

        when(montyGameMock.play(false)).thenCallRealMethod();
        when(montyGameMock.playNoSwitch()).thenReturn(true);
        Assert.assertTrue(null, montyGameMock.play(true));
    }
}
