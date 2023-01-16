package dataElements;

import Data.Data;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressTest {
    Address address = Data.returnSampleAddress();

    @Test
    void getPostalCodeTest(){
        assertEquals("100-10", address.getPostalCode());
    }

    @Test
    void setPostalCodeTest(){
        address.setPostalCode("999-99");
        assertEquals("999-99", address.getPostalCode());
    }
}
