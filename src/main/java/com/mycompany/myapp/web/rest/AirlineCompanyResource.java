package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.AirlineCompany;
import com.mycompany.myapp.repository.AirlineCompanyRepository;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.AirlineCompany}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class AirlineCompanyResource {

    private final Logger log = LoggerFactory.getLogger(AirlineCompanyResource.class);

    private static final String ENTITY_NAME = "airlineCompany";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AirlineCompanyRepository airlineCompanyRepository;

    public AirlineCompanyResource(AirlineCompanyRepository airlineCompanyRepository) {
        this.airlineCompanyRepository = airlineCompanyRepository;
    }

    /**
     * {@code POST  /airline-companies} : Create a new airlineCompany.
     *
     * @param airlineCompany the airlineCompany to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new airlineCompany, or with status {@code 400 (Bad Request)} if the airlineCompany has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/airline-companies")
    public ResponseEntity<AirlineCompany> createAirlineCompany(@RequestBody AirlineCompany airlineCompany) throws URISyntaxException {
        log.debug("REST request to save AirlineCompany : {}", airlineCompany);
        if (airlineCompany.getId() != null) {
            throw new BadRequestAlertException("A new airlineCompany cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AirlineCompany result = airlineCompanyRepository.save(airlineCompany);
        return ResponseEntity.created(new URI("/api/airline-companies/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /airline-companies} : Updates an existing airlineCompany.
     *
     * @param airlineCompany the airlineCompany to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated airlineCompany,
     * or with status {@code 400 (Bad Request)} if the airlineCompany is not valid,
     * or with status {@code 500 (Internal Server Error)} if the airlineCompany couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/airline-companies")
    public ResponseEntity<AirlineCompany> updateAirlineCompany(@RequestBody AirlineCompany airlineCompany) throws URISyntaxException {
        log.debug("REST request to update AirlineCompany : {}", airlineCompany);
        if (airlineCompany.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AirlineCompany result = airlineCompanyRepository.save(airlineCompany);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, airlineCompany.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /airline-companies} : get all the airlineCompanies.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of airlineCompanies in body.
     */
    @GetMapping("/airline-companies")
    public List<AirlineCompany> getAllAirlineCompanies() {
        log.debug("REST request to get all AirlineCompanies");
        return airlineCompanyRepository.findAll();
    }

    /**
     * {@code GET  /airline-companies/:id} : get the "id" airlineCompany.
     *
     * @param id the id of the airlineCompany to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the airlineCompany, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/airline-companies/{id}")
    public ResponseEntity<AirlineCompany> getAirlineCompany(@PathVariable Long id) {
        log.debug("REST request to get AirlineCompany : {}", id);
        Optional<AirlineCompany> airlineCompany = airlineCompanyRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(airlineCompany);
    }

    /**
     * {@code DELETE  /airline-companies/:id} : delete the "id" airlineCompany.
     *
     * @param id the id of the airlineCompany to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/airline-companies/{id}")
    public ResponseEntity<Void> deleteAirlineCompany(@PathVariable Long id) {
        log.debug("REST request to delete AirlineCompany : {}", id);
        airlineCompanyRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
