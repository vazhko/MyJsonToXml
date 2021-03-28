import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FiscalBlockTest {

    private FiscalBlock fb;

    @Before
    public void init(){
        fb = new FiscalBlock();
    }

    @Test
    public void getSomeShit() throws Exception {
        String shit = fb.getSomeShit();
        assertEquals("This is really shit", shit);
    }

}
