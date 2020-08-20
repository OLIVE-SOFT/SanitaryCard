package com.mycompany.myapp.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mycompany.myapp.web.rest.TestUtil;

public class TravelerhealthcardTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Travelerhealthcard.class);
        Travelerhealthcard travelerhealthcard1 = new Travelerhealthcard();
        travelerhealthcard1.setId(1L);
        Travelerhealthcard travelerhealthcard2 = new Travelerhealthcard();
        travelerhealthcard2.setId(travelerhealthcard1.getId());
        assertThat(travelerhealthcard1).isEqualTo(travelerhealthcard2);
        travelerhealthcard2.setId(2L);
        assertThat(travelerhealthcard1).isNotEqualTo(travelerhealthcard2);
        travelerhealthcard1.setId(null);
        assertThat(travelerhealthcard1).isNotEqualTo(travelerhealthcard2);
    }
}
