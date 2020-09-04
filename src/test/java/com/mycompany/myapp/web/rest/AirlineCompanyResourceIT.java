package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.JhipsterApp;
import com.mycompany.myapp.domain.AirlineCompany;
import com.mycompany.myapp.repository.AirlineCompanyRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link AirlineCompanyResource} REST controller.
 */
@SpringBootTest(classes = JhipsterApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class AirlineCompanyResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_IATA = "AAAAAAAAAA";
    private static final String UPDATED_IATA = "BBBBBBBBBB";

    private static final String DEFAULT_ICAO = "AAAAAAAAAA";
    private static final String UPDATED_ICAO = "BBBBBBBBBB";

    private static final String DEFAULT_CALLSIGN = "AAAAAAAAAA";
    private static final String UPDATED_CALLSIGN = "BBBBBBBBBB";

    private static final String DEFAULT_COUNTRY = "AAAAAAAAAA";
    private static final String UPDATED_COUNTRY = "BBBBBBBBBB";

    private static final Integer DEFAULT_ALID = 1;
    private static final Integer UPDATED_ALID = 2;

    private static final Integer DEFAULT_UID = 1;
    private static final Integer UPDATED_UID = 2;

    private static final String DEFAULT_ALIAS = "AAAAAAAAAA";
    private static final String UPDATED_ALIAS = "BBBBBBBBBB";

    private static final String DEFAULT_MODE = "AAAAAAAAAA";
    private static final String UPDATED_MODE = "BBBBBBBBBB";

    private static final String DEFAULT_ACTIVE = "AAAAAAAAAA";
    private static final String UPDATED_ACTIVE = "BBBBBBBBBB";

    @Autowired
    private AirlineCompanyRepository airlineCompanyRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restAirlineCompanyMockMvc;

    private AirlineCompany airlineCompany;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AirlineCompany createEntity(EntityManager em) {
        AirlineCompany airlineCompany = new AirlineCompany()
            .name(DEFAULT_NAME)
            .iata(DEFAULT_IATA)
            .icao(DEFAULT_ICAO)
            .callsign(DEFAULT_CALLSIGN)
            .country(DEFAULT_COUNTRY)
            .alid(DEFAULT_ALID)
            .uid(DEFAULT_UID)
            .alias(DEFAULT_ALIAS)
            .mode(DEFAULT_MODE)
            .active(DEFAULT_ACTIVE);
        return airlineCompany;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AirlineCompany createUpdatedEntity(EntityManager em) {
        AirlineCompany airlineCompany = new AirlineCompany()
            .name(UPDATED_NAME)
            .iata(UPDATED_IATA)
            .icao(UPDATED_ICAO)
            .callsign(UPDATED_CALLSIGN)
            .country(UPDATED_COUNTRY)
            .alid(UPDATED_ALID)
            .uid(UPDATED_UID)
            .alias(UPDATED_ALIAS)
            .mode(UPDATED_MODE)
            .active(UPDATED_ACTIVE);
        return airlineCompany;
    }

    @BeforeEach
    public void initTest() {
        airlineCompany = createEntity(em);
    }

    @Test
    @Transactional
    public void createAirlineCompany() throws Exception {
        int databaseSizeBeforeCreate = airlineCompanyRepository.findAll().size();
        // Create the AirlineCompany
        restAirlineCompanyMockMvc.perform(post("/api/airline-companies")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(airlineCompany)))
            .andExpect(status().isCreated());

        // Validate the AirlineCompany in the database
        List<AirlineCompany> airlineCompanyList = airlineCompanyRepository.findAll();
        assertThat(airlineCompanyList).hasSize(databaseSizeBeforeCreate + 1);
        AirlineCompany testAirlineCompany = airlineCompanyList.get(airlineCompanyList.size() - 1);
        assertThat(testAirlineCompany.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testAirlineCompany.getIata()).isEqualTo(DEFAULT_IATA);
        assertThat(testAirlineCompany.getIcao()).isEqualTo(DEFAULT_ICAO);
        assertThat(testAirlineCompany.getCallsign()).isEqualTo(DEFAULT_CALLSIGN);
        assertThat(testAirlineCompany.getCountry()).isEqualTo(DEFAULT_COUNTRY);
        assertThat(testAirlineCompany.getAlid()).isEqualTo(DEFAULT_ALID);
        assertThat(testAirlineCompany.getUid()).isEqualTo(DEFAULT_UID);
        assertThat(testAirlineCompany.getAlias()).isEqualTo(DEFAULT_ALIAS);
        assertThat(testAirlineCompany.getMode()).isEqualTo(DEFAULT_MODE);
        assertThat(testAirlineCompany.getActive()).isEqualTo(DEFAULT_ACTIVE);
    }

    @Test
    @Transactional
    public void createAirlineCompanyWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = airlineCompanyRepository.findAll().size();

        // Create the AirlineCompany with an existing ID
        airlineCompany.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAirlineCompanyMockMvc.perform(post("/api/airline-companies")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(airlineCompany)))
            .andExpect(status().isBadRequest());

        // Validate the AirlineCompany in the database
        List<AirlineCompany> airlineCompanyList = airlineCompanyRepository.findAll();
        assertThat(airlineCompanyList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllAirlineCompanies() throws Exception {
        // Initialize the database
        airlineCompanyRepository.saveAndFlush(airlineCompany);

        // Get all the airlineCompanyList
        restAirlineCompanyMockMvc.perform(get("/api/airline-companies?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(airlineCompany.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].iata").value(hasItem(DEFAULT_IATA)))
            .andExpect(jsonPath("$.[*].icao").value(hasItem(DEFAULT_ICAO)))
            .andExpect(jsonPath("$.[*].callsign").value(hasItem(DEFAULT_CALLSIGN)))
            .andExpect(jsonPath("$.[*].country").value(hasItem(DEFAULT_COUNTRY)))
            .andExpect(jsonPath("$.[*].alid").value(hasItem(DEFAULT_ALID)))
            .andExpect(jsonPath("$.[*].uid").value(hasItem(DEFAULT_UID)))
            .andExpect(jsonPath("$.[*].alias").value(hasItem(DEFAULT_ALIAS)))
            .andExpect(jsonPath("$.[*].mode").value(hasItem(DEFAULT_MODE)))
            .andExpect(jsonPath("$.[*].active").value(hasItem(DEFAULT_ACTIVE)));
    }
    
    @Test
    @Transactional
    public void getAirlineCompany() throws Exception {
        // Initialize the database
        airlineCompanyRepository.saveAndFlush(airlineCompany);

        // Get the airlineCompany
        restAirlineCompanyMockMvc.perform(get("/api/airline-companies/{id}", airlineCompany.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(airlineCompany.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.iata").value(DEFAULT_IATA))
            .andExpect(jsonPath("$.icao").value(DEFAULT_ICAO))
            .andExpect(jsonPath("$.callsign").value(DEFAULT_CALLSIGN))
            .andExpect(jsonPath("$.country").value(DEFAULT_COUNTRY))
            .andExpect(jsonPath("$.alid").value(DEFAULT_ALID))
            .andExpect(jsonPath("$.uid").value(DEFAULT_UID))
            .andExpect(jsonPath("$.alias").value(DEFAULT_ALIAS))
            .andExpect(jsonPath("$.mode").value(DEFAULT_MODE))
            .andExpect(jsonPath("$.active").value(DEFAULT_ACTIVE));
    }
    @Test
    @Transactional
    public void getNonExistingAirlineCompany() throws Exception {
        // Get the airlineCompany
        restAirlineCompanyMockMvc.perform(get("/api/airline-companies/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAirlineCompany() throws Exception {
        // Initialize the database
        airlineCompanyRepository.saveAndFlush(airlineCompany);

        int databaseSizeBeforeUpdate = airlineCompanyRepository.findAll().size();

        // Update the airlineCompany
        AirlineCompany updatedAirlineCompany = airlineCompanyRepository.findById(airlineCompany.getId()).get();
        // Disconnect from session so that the updates on updatedAirlineCompany are not directly saved in db
        em.detach(updatedAirlineCompany);
        updatedAirlineCompany
            .name(UPDATED_NAME)
            .iata(UPDATED_IATA)
            .icao(UPDATED_ICAO)
            .callsign(UPDATED_CALLSIGN)
            .country(UPDATED_COUNTRY)
            .alid(UPDATED_ALID)
            .uid(UPDATED_UID)
            .alias(UPDATED_ALIAS)
            .mode(UPDATED_MODE)
            .active(UPDATED_ACTIVE);

        restAirlineCompanyMockMvc.perform(put("/api/airline-companies")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedAirlineCompany)))
            .andExpect(status().isOk());

        // Validate the AirlineCompany in the database
        List<AirlineCompany> airlineCompanyList = airlineCompanyRepository.findAll();
        assertThat(airlineCompanyList).hasSize(databaseSizeBeforeUpdate);
        AirlineCompany testAirlineCompany = airlineCompanyList.get(airlineCompanyList.size() - 1);
        assertThat(testAirlineCompany.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testAirlineCompany.getIata()).isEqualTo(UPDATED_IATA);
        assertThat(testAirlineCompany.getIcao()).isEqualTo(UPDATED_ICAO);
        assertThat(testAirlineCompany.getCallsign()).isEqualTo(UPDATED_CALLSIGN);
        assertThat(testAirlineCompany.getCountry()).isEqualTo(UPDATED_COUNTRY);
        assertThat(testAirlineCompany.getAlid()).isEqualTo(UPDATED_ALID);
        assertThat(testAirlineCompany.getUid()).isEqualTo(UPDATED_UID);
        assertThat(testAirlineCompany.getAlias()).isEqualTo(UPDATED_ALIAS);
        assertThat(testAirlineCompany.getMode()).isEqualTo(UPDATED_MODE);
        assertThat(testAirlineCompany.getActive()).isEqualTo(UPDATED_ACTIVE);
    }

    @Test
    @Transactional
    public void updateNonExistingAirlineCompany() throws Exception {
        int databaseSizeBeforeUpdate = airlineCompanyRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAirlineCompanyMockMvc.perform(put("/api/airline-companies")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(airlineCompany)))
            .andExpect(status().isBadRequest());

        // Validate the AirlineCompany in the database
        List<AirlineCompany> airlineCompanyList = airlineCompanyRepository.findAll();
        assertThat(airlineCompanyList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAirlineCompany() throws Exception {
        // Initialize the database
        airlineCompanyRepository.saveAndFlush(airlineCompany);

        int databaseSizeBeforeDelete = airlineCompanyRepository.findAll().size();

        // Delete the airlineCompany
        restAirlineCompanyMockMvc.perform(delete("/api/airline-companies/{id}", airlineCompany.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<AirlineCompany> airlineCompanyList = airlineCompanyRepository.findAll();
        assertThat(airlineCompanyList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
