package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Travelerhealthcard;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Travelerhealthcard entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TravelerhealthcardRepository extends JpaRepository<Travelerhealthcard, Long> {
}
