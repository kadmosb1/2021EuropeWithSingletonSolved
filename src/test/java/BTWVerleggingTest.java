import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BTWVerleggingTest {

    VATReverseCharge charge;

    @BeforeEach
    void init () {
        charge = VATReverseCharge.getInstance();
    }

    @Test
    void testBTWPercentages () {
        assertFalse (charge.isReverseChargeApplicable("NL"));
        assertTrue (charge.isReverseChargeApplicable("DE"));
        assertFalse (charge.isReverseChargeApplicable("CA"));
    }
}