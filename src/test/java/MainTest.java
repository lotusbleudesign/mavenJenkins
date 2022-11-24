import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    public MainTest(){}
    @Test
    public void getHello(){
        String msg ="Hello";
        assertEquals("Hello",msg);
    }
}
