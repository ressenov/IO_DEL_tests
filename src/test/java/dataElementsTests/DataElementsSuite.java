package dataElementsTests;


import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AddressTest.class,
        MockedPersonTest.class,
        PersonTest.class,

})

//@RunWith(JUnitPlatform.class)
//@SelectPackages("dataElementsTests")


public class DataElementsSuite {

}
