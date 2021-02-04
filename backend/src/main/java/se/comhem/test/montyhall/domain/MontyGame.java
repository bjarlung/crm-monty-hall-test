package se.comhem.test.montyhall.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.Random;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MontyGame {

    private final Random random;

    MontyGame() {
        this.random = new Random();
    }

    public boolean play(boolean doSwitch) {
        return doSwitch ? playWithSwitch() : playNoSwitch();
    }

    public boolean playNoSwitch() {
        return getRandomDoor() == getRandomDoor();
    }

    public boolean playWithSwitch() {
        return getRandomDoor() != getRandomDoor();
    }

    public int getRandomDoor() {
        return random.nextInt(3);
    }
}
