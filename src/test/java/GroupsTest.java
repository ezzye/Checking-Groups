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
        assertEquals( true,Groups.groupCheck("()"));
        assertEquals( false,Groups.groupCheck("({"));
    }

    @Test
    public void shouldRecognisePairOfConsequitiveOpenAndClosedSymbols() {
        assertEquals( true,Groups.groupCheck("[]()"));
        assertEquals( false,Groups.groupCheck("[()"));
    }

    @Test
    public void shouldrecogniseSymbolPairsThatAreNonConsequetiveButNested() {
        assertEquals( true,Groups.groupCheck("[()]"));
        assertEquals( false,Groups.groupCheck("[()"));
    }

    @Test
    public void shouldrecogniseSymbolPairsThatAreNonConsequetiveButNotNested() {
        assertEquals( true,Groups.groupCheck("[()]"));
        assertEquals( false,Groups.groupCheck("[(])"));
    }

    @Test
    public void shouldrecogniseOpenGroups() {
        assertEquals( true,Groups.groupCheck("({})"));
        assertEquals( true,Groups.groupCheck("[[]()]"));
        assertEquals( true,Groups.groupCheck("[{()}[{()}]]"));
        assertEquals( true,Groups.groupCheck("<>"));
        assertEquals( true,Groups.groupCheck(""));



        assertEquals( false,Groups.groupCheck("{(})"));
        assertEquals( false,Groups.groupCheck("([]"));
        assertEquals( false,Groups.groupCheck("[])"));
    }

}