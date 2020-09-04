package com.mycompany.myapp.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mycompany.myapp.web.rest.TestUtil;

public class AirlineCompanyTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AirlineCompany.class);
        AirlineCompany airlineCompany1 = new AirlineCompany();
        airlineCompany1.setId(1L);
        AirlineCompany airlineCompany2 = new AirlineCompany();
        airlineCompany2.setId(airlineCompany1.getId());
        assertThat(airlineCompany1).isEqualTo(airlineCompany2);
        airlineCompany2.setId(2L);
        assertThat(airlineCompany1).isNotEqualTo(airlineCompany2);
        airlineCompany1.setId(null);
        assertThat(airlineCompany1).isNotEqualTo(airlineCompany2);
    }
}
