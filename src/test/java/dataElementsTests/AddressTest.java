package dataElementsTests;

import Data.SampleData;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddressTest {
    Address address = SampleData.returnSampleAddress();

    @Test
    public void getPostalCodeTest(){
        assertEquals("100-10", address.getPostalCode());
    }

    @Test
    public void setPostalCodeTest(){
        address.setPostalCode("999-99");
        assertEquals("999-99", address.getPostalCode());
    }
}
