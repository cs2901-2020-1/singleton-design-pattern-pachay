import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        log.debug("Pucha probando pes");

        ChocolateBoiler cb1 = new ChocolateBoiler();
        ChocolateBoilerTest cbt1 = new ChocolateBoilerTest();

    }
}
