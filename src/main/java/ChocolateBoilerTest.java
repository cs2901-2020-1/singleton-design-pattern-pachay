import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChocolateBoilerTest {

    private final ChocolateBoiler cb = new ChocolateBoiler();

    @Test
    public void checkifcorrectlyinitialized() {
        assertTrue(cb.isEmpty(), "Must return true");
        assertFalse(cb.isBoiled(), "Must return false");
    }

    @Test
    public void checkifcorrectlyfilled() {
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

}
