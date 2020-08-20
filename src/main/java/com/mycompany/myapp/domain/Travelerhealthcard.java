package com.mycompany.myapp.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.Duration;

/**
 * A Travelerhealthcard.
 */
@Entity
@Table(name = "travelerhealthcard")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Travelerhealthcard implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "plane_seat_number")
    private String planeSeatNumber;

    @Column(name = "airline_company")
    private String airlineCompany;

    @Column(name = "temperature_monitoring")
    private Double temperatureMonitoring;

    @Column(name = "body_temperature")
    private Integer bodyTemperature;

    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @Column(name = "arrival_time")
    private ZonedDateTime arrivalTime;

    @Column(name = "first_stopovercountry")
    private String firstStopovercountry;

    @Column(name = "second_stopovercountry")
    private String secondStopovercountry;

    @Column(name = "third_stopovercountry")
    private String thirdStopovercountry;

    @Column(name = "first_departuredate_country")
    private LocalDate firstDeparturedateCountry;

    @Column(name = "second_departuredate_country")
    private LocalDate secondDeparturedateCountry;

    @Column(name = "third_departuredate_country")
    private LocalDate thirdDeparturedateCountry;

    @Column(name = "first_duration_ofstay_country")
    private Duration firstDurationOfstayCountry;

    @Column(name = "second_duration_ofstay_country")
    private Duration secondDurationOfstayCountry;

    @Column(name = "third_duration_ofstay_country")
    private Duration thirdDurationOfstayCountry;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public Travelerhealthcard firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Travelerhealthcard lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public Travelerhealthcard email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Travelerhealthcard phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Travelerhealthcard dateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public Travelerhealthcard streetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
        return this;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public Travelerhealthcard city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Travelerhealthcard postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Travelerhealthcard flightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
        return this;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getPlaneSeatNumber() {
        return planeSeatNumber;
    }

    public Travelerhealthcard planeSeatNumber(String planeSeatNumber) {
        this.planeSeatNumber = planeSeatNumber;
        return this;
    }

    public void setPlaneSeatNumber(String planeSeatNumber) {
        this.planeSeatNumber = planeSeatNumber;
    }

    public String getAirlineCompany() {
        return airlineCompany;
    }

    public Travelerhealthcard airlineCompany(String airlineCompany) {
        this.airlineCompany = airlineCompany;
        return this;
    }

    public void setAirlineCompany(String airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public Double getTemperatureMonitoring() {
        return temperatureMonitoring;
    }

    public Travelerhealthcard temperatureMonitoring(Double temperatureMonitoring) {
        this.temperatureMonitoring = temperatureMonitoring;
        return this;
    }

    public void setTemperatureMonitoring(Double temperatureMonitoring) {
        this.temperatureMonitoring = temperatureMonitoring;
    }

    public Integer getBodyTemperature() {
        return bodyTemperature;
    }

    public Travelerhealthcard bodyTemperature(Integer bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
        return this;
    }

    public void setBodyTemperature(Integer bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public Travelerhealthcard arrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
        return this;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public ZonedDateTime getArrivalTime() {
        return arrivalTime;
    }

    public Travelerhealthcard arrivalTime(ZonedDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }

    public void setArrivalTime(ZonedDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getFirstStopovercountry() {
        return firstStopovercountry;
    }

    public Travelerhealthcard firstStopovercountry(String firstStopovercountry) {
        this.firstStopovercountry = firstStopovercountry;
        return this;
    }

    public void setFirstStopovercountry(String firstStopovercountry) {
        this.firstStopovercountry = firstStopovercountry;
    }

    public String getSecondStopovercountry() {
        return secondStopovercountry;
    }

    public Travelerhealthcard secondStopovercountry(String secondStopovercountry) {
        this.secondStopovercountry = secondStopovercountry;
        return this;
    }

    public void setSecondStopovercountry(String secondStopovercountry) {
        this.secondStopovercountry = secondStopovercountry;
    }

    public String getThirdStopovercountry() {
        return thirdStopovercountry;
    }

    public Travelerhealthcard thirdStopovercountry(String thirdStopovercountry) {
        this.thirdStopovercountry = thirdStopovercountry;
        return this;
    }

    public void setThirdStopovercountry(String thirdStopovercountry) {
        this.thirdStopovercountry = thirdStopovercountry;
    }

    public LocalDate getFirstDeparturedateCountry() {
        return firstDeparturedateCountry;
    }

    public Travelerhealthcard firstDeparturedateCountry(LocalDate firstDeparturedateCountry) {
        this.firstDeparturedateCountry = firstDeparturedateCountry;
        return this;
    }

    public void setFirstDeparturedateCountry(LocalDate firstDeparturedateCountry) {
        this.firstDeparturedateCountry = firstDeparturedateCountry;
    }

    public LocalDate getSecondDeparturedateCountry() {
        return secondDeparturedateCountry;
    }

    public Travelerhealthcard secondDeparturedateCountry(LocalDate secondDeparturedateCountry) {
        this.secondDeparturedateCountry = secondDeparturedateCountry;
        return this;
    }

    public void setSecondDeparturedateCountry(LocalDate secondDeparturedateCountry) {
        this.secondDeparturedateCountry = secondDeparturedateCountry;
    }

    public LocalDate getThirdDeparturedateCountry() {
        return thirdDeparturedateCountry;
    }

    public Travelerhealthcard thirdDeparturedateCountry(LocalDate thirdDeparturedateCountry) {
        this.thirdDeparturedateCountry = thirdDeparturedateCountry;
        return this;
    }

    public void setThirdDeparturedateCountry(LocalDate thirdDeparturedateCountry) {
        this.thirdDeparturedateCountry = thirdDeparturedateCountry;
    }

    public Duration getFirstDurationOfstayCountry() {
        return firstDurationOfstayCountry;
    }

    public Travelerhealthcard firstDurationOfstayCountry(Duration firstDurationOfstayCountry) {
        this.firstDurationOfstayCountry = firstDurationOfstayCountry;
        return this;
    }

    public void setFirstDurationOfstayCountry(Duration firstDurationOfstayCountry) {
        this.firstDurationOfstayCountry = firstDurationOfstayCountry;
    }

    public Duration getSecondDurationOfstayCountry() {
        return secondDurationOfstayCountry;
    }

    public Travelerhealthcard secondDurationOfstayCountry(Duration secondDurationOfstayCountry) {
        this.secondDurationOfstayCountry = secondDurationOfstayCountry;
        return this;
    }

    public void setSecondDurationOfstayCountry(Duration secondDurationOfstayCountry) {
        this.secondDurationOfstayCountry = secondDurationOfstayCountry;
    }

    public Duration getThirdDurationOfstayCountry() {
        return thirdDurationOfstayCountry;
    }

    public Travelerhealthcard thirdDurationOfstayCountry(Duration thirdDurationOfstayCountry) {
        this.thirdDurationOfstayCountry = thirdDurationOfstayCountry;
        return this;
    }

    public void setThirdDurationOfstayCountry(Duration thirdDurationOfstayCountry) {
        this.thirdDurationOfstayCountry = thirdDurationOfstayCountry;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Travelerhealthcard)) {
            return false;
        }
        return id != null && id.equals(((Travelerhealthcard) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Travelerhealthcard{" +
            "id=" + getId() +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", dateOfBirth='" + getDateOfBirth() + "'" +
            ", streetAddress='" + getStreetAddress() + "'" +
            ", city='" + getCity() + "'" +
            ", postalCode='" + getPostalCode() + "'" +
            ", flightNumber='" + getFlightNumber() + "'" +
            ", planeSeatNumber='" + getPlaneSeatNumber() + "'" +
            ", airlineCompany='" + getAirlineCompany() + "'" +
            ", temperatureMonitoring=" + getTemperatureMonitoring() +
            ", bodyTemperature=" + getBodyTemperature() +
            ", arrivalDate='" + getArrivalDate() + "'" +
            ", arrivalTime='" + getArrivalTime() + "'" +
            ", firstStopovercountry='" + getFirstStopovercountry() + "'" +
            ", secondStopovercountry='" + getSecondStopovercountry() + "'" +
            ", thirdStopovercountry='" + getThirdStopovercountry() + "'" +
            ", firstDeparturedateCountry='" + getFirstDeparturedateCountry() + "'" +
            ", secondDeparturedateCountry='" + getSecondDeparturedateCountry() + "'" +
            ", thirdDeparturedateCountry='" + getThirdDeparturedateCountry() + "'" +
            ", firstDurationOfstayCountry='" + getFirstDurationOfstayCountry() + "'" +
            ", secondDurationOfstayCountry='" + getSecondDurationOfstayCountry() + "'" +
            ", thirdDurationOfstayCountry='" + getThirdDurationOfstayCountry() + "'" +
            "}";
    }
}
