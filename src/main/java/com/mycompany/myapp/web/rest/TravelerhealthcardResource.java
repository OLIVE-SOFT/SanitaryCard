package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.Travelerhealthcard;
import com.mycompany.myapp.repository.TravelerhealthcardRepository;
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
 * REST controller for managing {@link com.mycompany.myapp.domain.Travelerhealthcard}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class TravelerhealthcardResource {

    private final Logger log = LoggerFactory.getLogger(TravelerhealthcardResource.class);

    private static final String ENTITY_NAME = "travelerhealthcard";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TravelerhealthcardRepository travelerhealthcardRepository;

    public TravelerhealthcardResource(TravelerhealthcardRepository travelerhealthcardRepository) {
        this.travelerhealthcardRepository = travelerhealthcardRepository;
    }

    /**
     * {@code POST  /travelerhealthcards} : Create a new travelerhealthcard.
     *
     * @param travelerhealthcard the travelerhealthcard to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new travelerhealthcard, or with status {@code 400 (Bad Request)} if the travelerhealthcard has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/travelerhealthcards")
    public ResponseEntity<Travelerhealthcard> createTravelerhealthcard(@RequestBody Travelerhealthcard travelerhealthcard) throws URISyntaxException {
        log.debug("REST request to save Travelerhealthcard : {}", travelerhealthcard);
        if (travelerhealthcard.getId() != null) {
            throw new BadRequestAlertException("A new travelerhealthcard cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Travelerhealthcard result = travelerhealthcardRepository.save(travelerhealthcard);
        return ResponseEntity.created(new URI("/api/travelerhealthcards/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /travelerhealthcards} : Updates an existing travelerhealthcard.
     *
     * @param travelerhealthcard the travelerhealthcard to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated travelerhealthcard,
     * or with status {@code 400 (Bad Request)} if the travelerhealthcard is not valid,
     * or with status {@code 500 (Internal Server Error)} if the travelerhealthcard couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/travelerhealthcards")
    public ResponseEntity<Travelerhealthcard> updateTravelerhealthcard(@RequestBody Travelerhealthcard travelerhealthcard) throws URISyntaxException {
        log.debug("REST request to update Travelerhealthcard : {}", travelerhealthcard);
        if (travelerhealthcard.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Travelerhealthcard result = travelerhealthcardRepository.save(travelerhealthcard);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, travelerhealthcard.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /travelerhealthcards} : get all the travelerhealthcards.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of travelerhealthcards in body.
     */
    @GetMapping("/travelerhealthcards")
    public List<Travelerhealthcard> getAllTravelerhealthcards() {
        log.debug("REST request to get all Travelerhealthcards");
        return travelerhealthcardRepository.findAll();
    }

    /**
     * {@code GET  /travelerhealthcards/:id} : get the "id" travelerhealthcard.
     *
     * @param id the id of the travelerhealthcard to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the travelerhealthcard, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/travelerhealthcards/{id}")
    public ResponseEntity<Travelerhealthcard> getTravelerhealthcard(@PathVariable Long id) {
        log.debug("REST request to get Travelerhealthcard : {}", id);
        Optional<Travelerhealthcard> travelerhealthcard = travelerhealthcardRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(travelerhealthcard);
    }

    /**
     * {@code DELETE  /travelerhealthcards/:id} : delete the "id" travelerhealthcard.
     *
     * @param id the id of the travelerhealthcard to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/travelerhealthcards/{id}")
    public ResponseEntity<Void> deleteTravelerhealthcard(@PathVariable Long id) {
        log.debug("REST request to delete Travelerhealthcard : {}", id);
        travelerhealthcardRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
