package com.mycompany.myapp.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A AirlineCompany.
 */
@Entity
@Table(name = "airline_company")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AirlineCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "iata")
    private String iata;

    @Column(name = "icao")
    private String icao;

    @Column(name = "callsign")
    private String callsign;

    @Column(name = "country")
    private String country;

    @Column(name = "alid")
    private Integer alid;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "alias")
    private String alias;

    @Column(name = "mode")
    private String mode;

    @Column(name = "active")
    private String active;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public AirlineCompany name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIata() {
        return iata;
    }

    public AirlineCompany iata(String iata) {
        this.iata = iata;
        return this;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getIcao() {
        return icao;
    }

    public AirlineCompany icao(String icao) {
        this.icao = icao;
        return this;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getCallsign() {
        return callsign;
    }

    public AirlineCompany callsign(String callsign) {
        this.callsign = callsign;
        return this;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    public String getCountry() {
        return country;
    }

    public AirlineCompany country(String country) {
        this.country = country;
        return this;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getAlid() {
        return alid;
    }

    public AirlineCompany alid(Integer alid) {
        this.alid = alid;
        return this;
    }

    public void setAlid(Integer alid) {
        this.alid = alid;
    }

    public Integer getUid() {
        return uid;
    }

    public AirlineCompany uid(Integer uid) {
        this.uid = uid;
        return this;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAlias() {
        return alias;
    }

    public AirlineCompany alias(String alias) {
        this.alias = alias;
        return this;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getMode() {
        return mode;
    }

    public AirlineCompany mode(String mode) {
        this.mode = mode;
        return this;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getActive() {
        return active;
    }

    public AirlineCompany active(String active) {
        this.active = active;
        return this;
    }

    public void setActive(String active) {
        this.active = active;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AirlineCompany)) {
            return false;
        }
        return id != null && id.equals(((AirlineCompany) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AirlineCompany{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", iata='" + getIata() + "'" +
            ", icao='" + getIcao() + "'" +
            ", callsign='" + getCallsign() + "'" +
            ", country='" + getCountry() + "'" +
            ", alid=" + getAlid() +
            ", uid=" + getUid() +
            ", alias='" + getAlias() + "'" +
            ", mode='" + getMode() + "'" +
            ", active='" + getActive() + "'" +
            "}";
    }
}
