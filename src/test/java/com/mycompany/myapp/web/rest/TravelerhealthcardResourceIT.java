package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.JhipsterApp;
import com.mycompany.myapp.domain.Travelerhealthcard;
import com.mycompany.myapp.repository.TravelerhealthcardRepository;

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
import java.time.Duration;
import java.time.LocalDate;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.time.ZoneId;
import java.util.List;

import static com.mycompany.myapp.web.rest.TestUtil.sameInstant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link TravelerhealthcardResource} REST controller.
 */
@SpringBootTest(classes = JhipsterApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class TravelerhealthcardResourceIT {

    private static final String DEFAULT_FIRST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_FIRST_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_LAST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_LAST_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_PHONE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_PHONE_NUMBER = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATE_OF_BIRTH = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_OF_BIRTH = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_STREET_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_STREET_ADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_CITY = "AAAAAAAAAA";
    private static final String UPDATED_CITY = "BBBBBBBBBB";

    private static final String DEFAULT_POSTAL_CODE = "AAAAAAAAAA";
    private static final String UPDATED_POSTAL_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_FLIGHT_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_FLIGHT_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_PLANE_SEAT_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_PLANE_SEAT_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_AIRLINE_COMPANY = "AAAAAAAAAA";
    private static final String UPDATED_AIRLINE_COMPANY = "BBBBBBBBBB";

    private static final Double DEFAULT_TEMPERATURE_MONITORING = 1D;
    private static final Double UPDATED_TEMPERATURE_MONITORING = 2D;

    private static final Integer DEFAULT_BODY_TEMPERATURE = 1;
    private static final Integer UPDATED_BODY_TEMPERATURE = 2;

    private static final LocalDate DEFAULT_ARRIVAL_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_ARRIVAL_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final ZonedDateTime DEFAULT_ARRIVAL_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_ARRIVAL_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final String DEFAULT_FIRST_STOPOVERCOUNTRY = "AAAAAAAAAA";
    private static final String UPDATED_FIRST_STOPOVERCOUNTRY = "BBBBBBBBBB";

    private static final String DEFAULT_SECOND_STOPOVERCOUNTRY = "AAAAAAAAAA";
    private static final String UPDATED_SECOND_STOPOVERCOUNTRY = "BBBBBBBBBB";

    private static final String DEFAULT_THIRD_STOPOVERCOUNTRY = "AAAAAAAAAA";
    private static final String UPDATED_THIRD_STOPOVERCOUNTRY = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_FIRST_DEPARTUREDATE_COUNTRY = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_FIRST_DEPARTUREDATE_COUNTRY = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_SECOND_DEPARTUREDATE_COUNTRY = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_SECOND_DEPARTUREDATE_COUNTRY = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_THIRD_DEPARTUREDATE_COUNTRY = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_THIRD_DEPARTUREDATE_COUNTRY = LocalDate.now(ZoneId.systemDefault());

    private static final Duration DEFAULT_FIRST_DURATION_OFSTAY_COUNTRY = Duration.ofHours(6);
    private static final Duration UPDATED_FIRST_DURATION_OFSTAY_COUNTRY = Duration.ofHours(12);

    private static final Duration DEFAULT_SECOND_DURATION_OFSTAY_COUNTRY = Duration.ofHours(6);
    private static final Duration UPDATED_SECOND_DURATION_OFSTAY_COUNTRY = Duration.ofHours(12);

    private static final Duration DEFAULT_THIRD_DURATION_OFSTAY_COUNTRY = Duration.ofHours(6);
    private static final Duration UPDATED_THIRD_DURATION_OFSTAY_COUNTRY = Duration.ofHours(12);

    @Autowired
    private TravelerhealthcardRepository travelerhealthcardRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restTravelerhealthcardMockMvc;

    private Travelerhealthcard travelerhealthcard;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Travelerhealthcard createEntity(EntityManager em) {
        Travelerhealthcard travelerhealthcard = new Travelerhealthcard()
            .firstName(DEFAULT_FIRST_NAME)
            .lastName(DEFAULT_LAST_NAME)
            .email(DEFAULT_EMAIL)
            .phoneNumber(DEFAULT_PHONE_NUMBER)
            .dateOfBirth(DEFAULT_DATE_OF_BIRTH)
            .streetAddress(DEFAULT_STREET_ADDRESS)
            .city(DEFAULT_CITY)
            .postalCode(DEFAULT_POSTAL_CODE)
            .flightNumber(DEFAULT_FLIGHT_NUMBER)
            .planeSeatNumber(DEFAULT_PLANE_SEAT_NUMBER)
            .airlineCompany(DEFAULT_AIRLINE_COMPANY)
            .temperatureMonitoring(DEFAULT_TEMPERATURE_MONITORING)
            .bodyTemperature(DEFAULT_BODY_TEMPERATURE)
            .arrivalDate(DEFAULT_ARRIVAL_DATE)
            .arrivalTime(DEFAULT_ARRIVAL_TIME)
            .firstStopovercountry(DEFAULT_FIRST_STOPOVERCOUNTRY)
            .secondStopovercountry(DEFAULT_SECOND_STOPOVERCOUNTRY)
            .thirdStopovercountry(DEFAULT_THIRD_STOPOVERCOUNTRY)
            .firstDeparturedateCountry(DEFAULT_FIRST_DEPARTUREDATE_COUNTRY)
            .secondDeparturedateCountry(DEFAULT_SECOND_DEPARTUREDATE_COUNTRY)
            .thirdDeparturedateCountry(DEFAULT_THIRD_DEPARTUREDATE_COUNTRY)
            .firstDurationOfstayCountry(DEFAULT_FIRST_DURATION_OFSTAY_COUNTRY)
            .secondDurationOfstayCountry(DEFAULT_SECOND_DURATION_OFSTAY_COUNTRY)
            .thirdDurationOfstayCountry(DEFAULT_THIRD_DURATION_OFSTAY_COUNTRY);
        return travelerhealthcard;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Travelerhealthcard createUpdatedEntity(EntityManager em) {
        Travelerhealthcard travelerhealthcard = new Travelerhealthcard()
            .firstName(UPDATED_FIRST_NAME)
            .lastName(UPDATED_LAST_NAME)
            .email(UPDATED_EMAIL)
            .phoneNumber(UPDATED_PHONE_NUMBER)
            .dateOfBirth(UPDATED_DATE_OF_BIRTH)
            .streetAddress(UPDATED_STREET_ADDRESS)
            .city(UPDATED_CITY)
            .postalCode(UPDATED_POSTAL_CODE)
            .flightNumber(UPDATED_FLIGHT_NUMBER)
            .planeSeatNumber(UPDATED_PLANE_SEAT_NUMBER)
            .airlineCompany(UPDATED_AIRLINE_COMPANY)
            .temperatureMonitoring(UPDATED_TEMPERATURE_MONITORING)
            .bodyTemperature(UPDATED_BODY_TEMPERATURE)
            .arrivalDate(UPDATED_ARRIVAL_DATE)
            .arrivalTime(UPDATED_ARRIVAL_TIME)
            .firstStopovercountry(UPDATED_FIRST_STOPOVERCOUNTRY)
            .secondStopovercountry(UPDATED_SECOND_STOPOVERCOUNTRY)
            .thirdStopovercountry(UPDATED_THIRD_STOPOVERCOUNTRY)
            .firstDeparturedateCountry(UPDATED_FIRST_DEPARTUREDATE_COUNTRY)
            .secondDeparturedateCountry(UPDATED_SECOND_DEPARTUREDATE_COUNTRY)
            .thirdDeparturedateCountry(UPDATED_THIRD_DEPARTUREDATE_COUNTRY)
            .firstDurationOfstayCountry(UPDATED_FIRST_DURATION_OFSTAY_COUNTRY)
            .secondDurationOfstayCountry(UPDATED_SECOND_DURATION_OFSTAY_COUNTRY)
            .thirdDurationOfstayCountry(UPDATED_THIRD_DURATION_OFSTAY_COUNTRY);
        return travelerhealthcard;
    }

    @BeforeEach
    public void initTest() {
        travelerhealthcard = createEntity(em);
    }

    @Test
    @Transactional
    public void createTravelerhealthcard() throws Exception {
        int databaseSizeBeforeCreate = travelerhealthcardRepository.findAll().size();
        // Create the Travelerhealthcard
        restTravelerhealthcardMockMvc.perform(post("/api/travelerhealthcards")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(travelerhealthcard)))
            .andExpect(status().isCreated());

        // Validate the Travelerhealthcard in the database
        List<Travelerhealthcard> travelerhealthcardList = travelerhealthcardRepository.findAll();
        assertThat(travelerhealthcardList).hasSize(databaseSizeBeforeCreate + 1);
        Travelerhealthcard testTravelerhealthcard = travelerhealthcardList.get(travelerhealthcardList.size() - 1);
        assertThat(testTravelerhealthcard.getFirstName()).isEqualTo(DEFAULT_FIRST_NAME);
        assertThat(testTravelerhealthcard.getLastName()).isEqualTo(DEFAULT_LAST_NAME);
        assertThat(testTravelerhealthcard.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testTravelerhealthcard.getPhoneNumber()).isEqualTo(DEFAULT_PHONE_NUMBER);
        assertThat(testTravelerhealthcard.getDateOfBirth()).isEqualTo(DEFAULT_DATE_OF_BIRTH);
        assertThat(testTravelerhealthcard.getStreetAddress()).isEqualTo(DEFAULT_STREET_ADDRESS);
        assertThat(testTravelerhealthcard.getCity()).isEqualTo(DEFAULT_CITY);
        assertThat(testTravelerhealthcard.getPostalCode()).isEqualTo(DEFAULT_POSTAL_CODE);
        assertThat(testTravelerhealthcard.getFlightNumber()).isEqualTo(DEFAULT_FLIGHT_NUMBER);
        assertThat(testTravelerhealthcard.getPlaneSeatNumber()).isEqualTo(DEFAULT_PLANE_SEAT_NUMBER);
        assertThat(testTravelerhealthcard.getAirlineCompany()).isEqualTo(DEFAULT_AIRLINE_COMPANY);
        assertThat(testTravelerhealthcard.getTemperatureMonitoring()).isEqualTo(DEFAULT_TEMPERATURE_MONITORING);
        assertThat(testTravelerhealthcard.getBodyTemperature()).isEqualTo(DEFAULT_BODY_TEMPERATURE);
        assertThat(testTravelerhealthcard.getArrivalDate()).isEqualTo(DEFAULT_ARRIVAL_DATE);
        assertThat(testTravelerhealthcard.getArrivalTime()).isEqualTo(DEFAULT_ARRIVAL_TIME);
        assertThat(testTravelerhealthcard.getFirstStopovercountry()).isEqualTo(DEFAULT_FIRST_STOPOVERCOUNTRY);
        assertThat(testTravelerhealthcard.getSecondStopovercountry()).isEqualTo(DEFAULT_SECOND_STOPOVERCOUNTRY);
        assertThat(testTravelerhealthcard.getThirdStopovercountry()).isEqualTo(DEFAULT_THIRD_STOPOVERCOUNTRY);
        assertThat(testTravelerhealthcard.getFirstDeparturedateCountry()).isEqualTo(DEFAULT_FIRST_DEPARTUREDATE_COUNTRY);
        assertThat(testTravelerhealthcard.getSecondDeparturedateCountry()).isEqualTo(DEFAULT_SECOND_DEPARTUREDATE_COUNTRY);
        assertThat(testTravelerhealthcard.getThirdDeparturedateCountry()).isEqualTo(DEFAULT_THIRD_DEPARTUREDATE_COUNTRY);
        assertThat(testTravelerhealthcard.getFirstDurationOfstayCountry()).isEqualTo(DEFAULT_FIRST_DURATION_OFSTAY_COUNTRY);
        assertThat(testTravelerhealthcard.getSecondDurationOfstayCountry()).isEqualTo(DEFAULT_SECOND_DURATION_OFSTAY_COUNTRY);
        assertThat(testTravelerhealthcard.getThirdDurationOfstayCountry()).isEqualTo(DEFAULT_THIRD_DURATION_OFSTAY_COUNTRY);
    }

    @Test
    @Transactional
    public void createTravelerhealthcardWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = travelerhealthcardRepository.findAll().size();

        // Create the Travelerhealthcard with an existing ID
        travelerhealthcard.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restTravelerhealthcardMockMvc.perform(post("/api/travelerhealthcards")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(travelerhealthcard)))
            .andExpect(status().isBadRequest());

        // Validate the Travelerhealthcard in the database
        List<Travelerhealthcard> travelerhealthcardList = travelerhealthcardRepository.findAll();
        assertThat(travelerhealthcardList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllTravelerhealthcards() throws Exception {
        // Initialize the database
        travelerhealthcardRepository.saveAndFlush(travelerhealthcard);

        // Get all the travelerhealthcardList
        restTravelerhealthcardMockMvc.perform(get("/api/travelerhealthcards?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(travelerhealthcard.getId().intValue())))
            .andExpect(jsonPath("$.[*].firstName").value(hasItem(DEFAULT_FIRST_NAME)))
            .andExpect(jsonPath("$.[*].lastName").value(hasItem(DEFAULT_LAST_NAME)))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].phoneNumber").value(hasItem(DEFAULT_PHONE_NUMBER)))
            .andExpect(jsonPath("$.[*].dateOfBirth").value(hasItem(DEFAULT_DATE_OF_BIRTH.toString())))
            .andExpect(jsonPath("$.[*].streetAddress").value(hasItem(DEFAULT_STREET_ADDRESS)))
            .andExpect(jsonPath("$.[*].city").value(hasItem(DEFAULT_CITY)))
            .andExpect(jsonPath("$.[*].postalCode").value(hasItem(DEFAULT_POSTAL_CODE)))
            .andExpect(jsonPath("$.[*].flightNumber").value(hasItem(DEFAULT_FLIGHT_NUMBER)))
            .andExpect(jsonPath("$.[*].planeSeatNumber").value(hasItem(DEFAULT_PLANE_SEAT_NUMBER)))
            .andExpect(jsonPath("$.[*].airlineCompany").value(hasItem(DEFAULT_AIRLINE_COMPANY)))
            .andExpect(jsonPath("$.[*].temperatureMonitoring").value(hasItem(DEFAULT_TEMPERATURE_MONITORING.doubleValue())))
            .andExpect(jsonPath("$.[*].bodyTemperature").value(hasItem(DEFAULT_BODY_TEMPERATURE)))
            .andExpect(jsonPath("$.[*].arrivalDate").value(hasItem(DEFAULT_ARRIVAL_DATE.toString())))
            .andExpect(jsonPath("$.[*].arrivalTime").value(hasItem(sameInstant(DEFAULT_ARRIVAL_TIME))))
            .andExpect(jsonPath("$.[*].firstStopovercountry").value(hasItem(DEFAULT_FIRST_STOPOVERCOUNTRY)))
            .andExpect(jsonPath("$.[*].secondStopovercountry").value(hasItem(DEFAULT_SECOND_STOPOVERCOUNTRY)))
            .andExpect(jsonPath("$.[*].thirdStopovercountry").value(hasItem(DEFAULT_THIRD_STOPOVERCOUNTRY)))
            .andExpect(jsonPath("$.[*].firstDeparturedateCountry").value(hasItem(DEFAULT_FIRST_DEPARTUREDATE_COUNTRY.toString())))
            .andExpect(jsonPath("$.[*].secondDeparturedateCountry").value(hasItem(DEFAULT_SECOND_DEPARTUREDATE_COUNTRY.toString())))
            .andExpect(jsonPath("$.[*].thirdDeparturedateCountry").value(hasItem(DEFAULT_THIRD_DEPARTUREDATE_COUNTRY.toString())))
            .andExpect(jsonPath("$.[*].firstDurationOfstayCountry").value(hasItem(DEFAULT_FIRST_DURATION_OFSTAY_COUNTRY.toString())))
            .andExpect(jsonPath("$.[*].secondDurationOfstayCountry").value(hasItem(DEFAULT_SECOND_DURATION_OFSTAY_COUNTRY.toString())))
            .andExpect(jsonPath("$.[*].thirdDurationOfstayCountry").value(hasItem(DEFAULT_THIRD_DURATION_OFSTAY_COUNTRY.toString())));
    }
    
    @Test
    @Transactional
    public void getTravelerhealthcard() throws Exception {
        // Initialize the database
        travelerhealthcardRepository.saveAndFlush(travelerhealthcard);

        // Get the travelerhealthcard
        restTravelerhealthcardMockMvc.perform(get("/api/travelerhealthcards/{id}", travelerhealthcard.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(travelerhealthcard.getId().intValue()))
            .andExpect(jsonPath("$.firstName").value(DEFAULT_FIRST_NAME))
            .andExpect(jsonPath("$.lastName").value(DEFAULT_LAST_NAME))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
            .andExpect(jsonPath("$.phoneNumber").value(DEFAULT_PHONE_NUMBER))
            .andExpect(jsonPath("$.dateOfBirth").value(DEFAULT_DATE_OF_BIRTH.toString()))
            .andExpect(jsonPath("$.streetAddress").value(DEFAULT_STREET_ADDRESS))
            .andExpect(jsonPath("$.city").value(DEFAULT_CITY))
            .andExpect(jsonPath("$.postalCode").value(DEFAULT_POSTAL_CODE))
            .andExpect(jsonPath("$.flightNumber").value(DEFAULT_FLIGHT_NUMBER))
            .andExpect(jsonPath("$.planeSeatNumber").value(DEFAULT_PLANE_SEAT_NUMBER))
            .andExpect(jsonPath("$.airlineCompany").value(DEFAULT_AIRLINE_COMPANY))
            .andExpect(jsonPath("$.temperatureMonitoring").value(DEFAULT_TEMPERATURE_MONITORING.doubleValue()))
            .andExpect(jsonPath("$.bodyTemperature").value(DEFAULT_BODY_TEMPERATURE))
            .andExpect(jsonPath("$.arrivalDate").value(DEFAULT_ARRIVAL_DATE.toString()))
            .andExpect(jsonPath("$.arrivalTime").value(sameInstant(DEFAULT_ARRIVAL_TIME)))
            .andExpect(jsonPath("$.firstStopovercountry").value(DEFAULT_FIRST_STOPOVERCOUNTRY))
            .andExpect(jsonPath("$.secondStopovercountry").value(DEFAULT_SECOND_STOPOVERCOUNTRY))
            .andExpect(jsonPath("$.thirdStopovercountry").value(DEFAULT_THIRD_STOPOVERCOUNTRY))
            .andExpect(jsonPath("$.firstDeparturedateCountry").value(DEFAULT_FIRST_DEPARTUREDATE_COUNTRY.toString()))
            .andExpect(jsonPath("$.secondDeparturedateCountry").value(DEFAULT_SECOND_DEPARTUREDATE_COUNTRY.toString()))
            .andExpect(jsonPath("$.thirdDeparturedateCountry").value(DEFAULT_THIRD_DEPARTUREDATE_COUNTRY.toString()))
            .andExpect(jsonPath("$.firstDurationOfstayCountry").value(DEFAULT_FIRST_DURATION_OFSTAY_COUNTRY.toString()))
            .andExpect(jsonPath("$.secondDurationOfstayCountry").value(DEFAULT_SECOND_DURATION_OFSTAY_COUNTRY.toString()))
            .andExpect(jsonPath("$.thirdDurationOfstayCountry").value(DEFAULT_THIRD_DURATION_OFSTAY_COUNTRY.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingTravelerhealthcard() throws Exception {
        // Get the travelerhealthcard
        restTravelerhealthcardMockMvc.perform(get("/api/travelerhealthcards/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateTravelerhealthcard() throws Exception {
        // Initialize the database
        travelerhealthcardRepository.saveAndFlush(travelerhealthcard);

        int databaseSizeBeforeUpdate = travelerhealthcardRepository.findAll().size();

        // Update the travelerhealthcard
        Travelerhealthcard updatedTravelerhealthcard = travelerhealthcardRepository.findById(travelerhealthcard.getId()).get();
        // Disconnect from session so that the updates on updatedTravelerhealthcard are not directly saved in db
        em.detach(updatedTravelerhealthcard);
        updatedTravelerhealthcard
            .firstName(UPDATED_FIRST_NAME)
            .lastName(UPDATED_LAST_NAME)
            .email(UPDATED_EMAIL)
            .phoneNumber(UPDATED_PHONE_NUMBER)
            .dateOfBirth(UPDATED_DATE_OF_BIRTH)
            .streetAddress(UPDATED_STREET_ADDRESS)
            .city(UPDATED_CITY)
            .postalCode(UPDATED_POSTAL_CODE)
            .flightNumber(UPDATED_FLIGHT_NUMBER)
            .planeSeatNumber(UPDATED_PLANE_SEAT_NUMBER)
            .airlineCompany(UPDATED_AIRLINE_COMPANY)
            .temperatureMonitoring(UPDATED_TEMPERATURE_MONITORING)
            .bodyTemperature(UPDATED_BODY_TEMPERATURE)
            .arrivalDate(UPDATED_ARRIVAL_DATE)
            .arrivalTime(UPDATED_ARRIVAL_TIME)
            .firstStopovercountry(UPDATED_FIRST_STOPOVERCOUNTRY)
            .secondStopovercountry(UPDATED_SECOND_STOPOVERCOUNTRY)
            .thirdStopovercountry(UPDATED_THIRD_STOPOVERCOUNTRY)
            .firstDeparturedateCountry(UPDATED_FIRST_DEPARTUREDATE_COUNTRY)
            .secondDeparturedateCountry(UPDATED_SECOND_DEPARTUREDATE_COUNTRY)
            .thirdDeparturedateCountry(UPDATED_THIRD_DEPARTUREDATE_COUNTRY)
            .firstDurationOfstayCountry(UPDATED_FIRST_DURATION_OFSTAY_COUNTRY)
            .secondDurationOfstayCountry(UPDATED_SECOND_DURATION_OFSTAY_COUNTRY)
            .thirdDurationOfstayCountry(UPDATED_THIRD_DURATION_OFSTAY_COUNTRY);

        restTravelerhealthcardMockMvc.perform(put("/api/travelerhealthcards")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedTravelerhealthcard)))
            .andExpect(status().isOk());

        // Validate the Travelerhealthcard in the database
        List<Travelerhealthcard> travelerhealthcardList = travelerhealthcardRepository.findAll();
        assertThat(travelerhealthcardList).hasSize(databaseSizeBeforeUpdate);
        Travelerhealthcard testTravelerhealthcard = travelerhealthcardList.get(travelerhealthcardList.size() - 1);
        assertThat(testTravelerhealthcard.getFirstName()).isEqualTo(UPDATED_FIRST_NAME);
        assertThat(testTravelerhealthcard.getLastName()).isEqualTo(UPDATED_LAST_NAME);
        assertThat(testTravelerhealthcard.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testTravelerhealthcard.getPhoneNumber()).isEqualTo(UPDATED_PHONE_NUMBER);
        assertThat(testTravelerhealthcard.getDateOfBirth()).isEqualTo(UPDATED_DATE_OF_BIRTH);
        assertThat(testTravelerhealthcard.getStreetAddress()).isEqualTo(UPDATED_STREET_ADDRESS);
        assertThat(testTravelerhealthcard.getCity()).isEqualTo(UPDATED_CITY);
        assertThat(testTravelerhealthcard.getPostalCode()).isEqualTo(UPDATED_POSTAL_CODE);
        assertThat(testTravelerhealthcard.getFlightNumber()).isEqualTo(UPDATED_FLIGHT_NUMBER);
        assertThat(testTravelerhealthcard.getPlaneSeatNumber()).isEqualTo(UPDATED_PLANE_SEAT_NUMBER);
        assertThat(testTravelerhealthcard.getAirlineCompany()).isEqualTo(UPDATED_AIRLINE_COMPANY);
        assertThat(testTravelerhealthcard.getTemperatureMonitoring()).isEqualTo(UPDATED_TEMPERATURE_MONITORING);
        assertThat(testTravelerhealthcard.getBodyTemperature()).isEqualTo(UPDATED_BODY_TEMPERATURE);
        assertThat(testTravelerhealthcard.getArrivalDate()).isEqualTo(UPDATED_ARRIVAL_DATE);
        assertThat(testTravelerhealthcard.getArrivalTime()).isEqualTo(UPDATED_ARRIVAL_TIME);
        assertThat(testTravelerhealthcard.getFirstStopovercountry()).isEqualTo(UPDATED_FIRST_STOPOVERCOUNTRY);
        assertThat(testTravelerhealthcard.getSecondStopovercountry()).isEqualTo(UPDATED_SECOND_STOPOVERCOUNTRY);
        assertThat(testTravelerhealthcard.getThirdStopovercountry()).isEqualTo(UPDATED_THIRD_STOPOVERCOUNTRY);
        assertThat(testTravelerhealthcard.getFirstDeparturedateCountry()).isEqualTo(UPDATED_FIRST_DEPARTUREDATE_COUNTRY);
        assertThat(testTravelerhealthcard.getSecondDeparturedateCountry()).isEqualTo(UPDATED_SECOND_DEPARTUREDATE_COUNTRY);
        assertThat(testTravelerhealthcard.getThirdDeparturedateCountry()).isEqualTo(UPDATED_THIRD_DEPARTUREDATE_COUNTRY);
        assertThat(testTravelerhealthcard.getFirstDurationOfstayCountry()).isEqualTo(UPDATED_FIRST_DURATION_OFSTAY_COUNTRY);
        assertThat(testTravelerhealthcard.getSecondDurationOfstayCountry()).isEqualTo(UPDATED_SECOND_DURATION_OFSTAY_COUNTRY);
        assertThat(testTravelerhealthcard.getThirdDurationOfstayCountry()).isEqualTo(UPDATED_THIRD_DURATION_OFSTAY_COUNTRY);
    }

    @Test
    @Transactional
    public void updateNonExistingTravelerhealthcard() throws Exception {
        int databaseSizeBeforeUpdate = travelerhealthcardRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTravelerhealthcardMockMvc.perform(put("/api/travelerhealthcards")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(travelerhealthcard)))
            .andExpect(status().isBadRequest());

        // Validate the Travelerhealthcard in the database
        List<Travelerhealthcard> travelerhealthcardList = travelerhealthcardRepository.findAll();
        assertThat(travelerhealthcardList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteTravelerhealthcard() throws Exception {
        // Initialize the database
        travelerhealthcardRepository.saveAndFlush(travelerhealthcard);

        int databaseSizeBeforeDelete = travelerhealthcardRepository.findAll().size();

        // Delete the travelerhealthcard
        restTravelerhealthcardMockMvc.perform(delete("/api/travelerhealthcards/{id}", travelerhealthcard.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Travelerhealthcard> travelerhealthcardList = travelerhealthcardRepository.findAll();
        assertThat(travelerhealthcardList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
