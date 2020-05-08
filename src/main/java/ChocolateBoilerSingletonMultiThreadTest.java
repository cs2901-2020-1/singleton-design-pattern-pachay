import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;

import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;
import com.anarsoft.vmlens.concurrent.junit.ThreadCount;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
@RunWith(ConcurrentTestRunner.class)
public class ChocolateBoilerSingletonMultiThreadTest {

    private final static int THREAD_COUNT = 1;

    @Test
    @Order(1)
    @ThreadCount(THREAD_COUNT)
    public void testA() {
        ChocolateBoilerSingleton cb = ChocolateBoilerSingleton.getInstance();
        cb.fill();
        assertFalse(cb.isEmpty(), "Must return false");
        assertFalse(cb.isBoiled(), "Must return false");
    }

    @Test
    @Order(2)
    @ThreadCount(THREAD_COUNT)
    public void testB() {
        ChocolateBoilerSingleton cb = ChocolateBoilerSingleton.getInstance();
        cb.boil();
        assertFalse(cb.isEmpty(), "Must return false");
        assertTrue(cb.isBoiled(), "Must return true");
    }

    @Test
    @Order(3)
    @ThreadCount(THREAD_COUNT)
    public void testC() {
        ChocolateBoilerSingleton cb = ChocolateBoilerSingleton.getInstance();
        cb.drain();
        assertTrue(cb.isEmpty(), "Must return true");
        assertTrue(cb.isBoiled(), "Must return true");
    }

    @Test
    @Order(4)
    @ThreadCount(THREAD_COUNT)
    public void testD() {
        ChocolateBoilerSingleton cbs = ChocolateBoilerSingleton.getInstance();
        ChocolateBoilerSingleton cb = ChocolateBoilerSingleton.getInstance();
        assertEquals(cbs, cb, "Must be equals");
    }

}
