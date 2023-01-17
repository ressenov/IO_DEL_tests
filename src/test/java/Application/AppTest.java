package Application;

import application.App;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    @Rule
    TextFromStandardInputStream systemInMock = TextFromStandardInputStream.emptyStandardInputStream();

    App app = new App();

    @Test
    void testTest(){
        systemInMock.provideLines("1", "2", "3");

        assertEquals(1, app.testTest());
        assertEquals(2, app.testTest());
        assertEquals(0, app.testTest());

    }
}
