package systemManagementTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DatabaseManagerTest.class,
        DocumentManagerTest.class,
})

public class SystemManagementSuite {
}
