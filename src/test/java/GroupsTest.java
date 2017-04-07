import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by ellioe03 on 07/04/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class GroupsTest {


    @Test
    public void myTests() {
        assertEquals(Groups.groupCheck("()"), true);
//        assertEquals(Groups.groupCheck("({"), false);
    }

}