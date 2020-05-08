import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChocolateBoilerSingletonTest {

    private final ChocolateBoilerSingleton cb = ChocolateBoilerSingleton.getInstance();

    @Test
    public void checkifcorrectlyfilled() {
        cb.drain();
        cb.fill();
        assertFalse(cb.isEmpty(), "Must return false");
        assertFalse(cb.isBoiled(), "Must return false");
    }

    @Test
    public void checkifcorrectlyboiled() {
        cb.fill();
        cb.boil();
        assertFalse(cb.isEmpty(), "Must return false");
        assertTrue(cb.isBoiled(), "Must return true");
    }

    @Test
    public void checkifcorrectlydrained() {
        cb.fill();
        cb.boil();
        cb.drain();
        assertTrue(cb.isEmpty(), "Must return true");
        assertTrue(cb.isBoiled(), "Must return true");
    }

    @Test
    public void checkifcorrectlyrefilled() {
        cb.fill();
        cb.boil();
        cb.drain();
        cb.fill();
        assertFalse(cb.isEmpty(), "Must return false");
        assertFalse(cb.isBoiled(), "Must return false");
    }

    @Test
    public void checkifnonewinstance() {
        ChocolateBoilerSingleton cbs = ChocolateBoilerSingleton.getInstance();
        assertEquals(cbs, cb, "Must be equals");
    }

    @Test
    public void checkiffillinonethenfillinother() {
        ChocolateBoilerSingleton cbs = ChocolateBoilerSingleton.getInstance();
        cbs.fill();
        assertFalse(cb.isEmpty(), "Must return false");
        assertFalse(cb.isBoiled(), "Must return false");
    }
}
