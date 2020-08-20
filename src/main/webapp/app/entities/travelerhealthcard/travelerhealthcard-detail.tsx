import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './travelerhealthcard.reducer';
import { ITravelerhealthcard } from 'app/shared/model/travelerhealthcard.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ITravelerhealthcardDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const TravelerhealthcardDetail = (props: ITravelerhealthcardDetailProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const { travelerhealthcardEntity } = props;
  return (
    <Row>
      <Col md="8">
        <h2>
          <Translate contentKey="jhipsterApp.travelerhealthcard.detail.title">TravelerHealthCard</Translate> [
          <b>{travelerhealthcardEntity.id}</b>]
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="firstName">
              <Translate contentKey="jhipsterApp.travelerhealthcard.firstName">First Name</Translate>
            </span>
          </dt>
          <dd>{travelerhealthcardEntity.firstName}</dd>
          <dt>
            <span id="lastName">
              <Translate contentKey="jhipsterApp.travelerhealthcard.lastName">Last Name</Translate>
            </span>
          </dt>
          <dd>{travelerhealthcardEntity.lastName}</dd>
          <dt>
            <span id="email">
              <Translate contentKey="jhipsterApp.travelerhealthcard.email">Email</Translate>
            </span>
          </dt>
          <dd>{travelerhealthcardEntity.email}</dd>
          <dt>
            <span id="phoneNumber">
              <Translate contentKey="jhipsterApp.travelerhealthcard.phoneNumber">Phone Number</Translate>
            </span>
          </dt>
          <dd>{travelerhealthcardEntity.phoneNumber}</dd>
          <dt>
            <span id="dateOfBirth">
              <Translate contentKey="jhipsterApp.travelerhealthcard.dateOfBirth">Date Of Birth</Translate>
            </span>
          </dt>
          <dd>
            {travelerhealthcardEntity.dateOfBirth ? (
              <TextFormat value={travelerhealthcardEntity.dateOfBirth} type="date" format={APP_LOCAL_DATE_FORMAT} />
            ) : null}
          </dd>
          <dt>
            <span id="streetAddress">
              <Translate contentKey="jhipsterApp.travelerhealthcard.streetAddress">Street Address</Translate>
            </span>
          </dt>
          <dd>{travelerhealthcardEntity.streetAddress}</dd>
          <dt>
            <span id="city">
              <Translate contentKey="jhipsterApp.travelerhealthcard.city">City</Translate>
            </span>
          </dt>
          <dd>{travelerhealthcardEntity.city}</dd>
          <dt>
            <span id="postalCode">
              <Translate contentKey="jhipsterApp.travelerhealthcard.postalCode">Postal Code</Translate>
            </span>
          </dt>
          <dd>{travelerhealthcardEntity.postalCode}</dd>
          <dt>
            <span id="flightNumber">
              <Translate contentKey="jhipsterApp.travelerhealthcard.flightNumber">Flight Number</Translate>
            </span>
          </dt>
          <dd>{travelerhealthcardEntity.flightNumber}</dd>
          <dt>
            <span id="planeSeatNumber">
              <Translate contentKey="jhipsterApp.travelerhealthcard.planeSeatNumber">Plane Seat Number</Translate>
            </span>
          </dt>
          <dd>{travelerhealthcardEntity.planeSeatNumber}</dd>
          <dt>
            <span id="airlineCompany">
              <Translate contentKey="jhipsterApp.travelerhealthcard.airlineCompany">Airline Company</Translate>
            </span>
          </dt>
          <dd>{travelerhealthcardEntity.airlineCompany}</dd>
          <dt>
            <span id="temperatureMonitoring">
              <Translate contentKey="jhipsterApp.travelerhealthcard.temperatureMonitoring">Temperature Monitoring</Translate>
            </span>
          </dt>
          <dd>{travelerhealthcardEntity.temperatureMonitoring}</dd>
          <dt>
            <span id="bodyTemperature">
              <Translate contentKey="jhipsterApp.travelerhealthcard.bodyTemperature">Body Temperature</Translate>
            </span>
          </dt>
          <dd>{travelerhealthcardEntity.bodyTemperature}</dd>
          <dt>
            <span id="arrivalDate">
              <Translate contentKey="jhipsterApp.travelerhealthcard.arrivalDate">Arrival Date</Translate>
            </span>
          </dt>
          <dd>
            {travelerhealthcardEntity.arrivalDate ? (
              <TextFormat value={travelerhealthcardEntity.arrivalDate} type="date" format={APP_LOCAL_DATE_FORMAT} />
            ) : null}
          </dd>
          <dt>
            <span id="arrivalTime">
              <Translate contentKey="jhipsterApp.travelerhealthcard.arrivalTime">Arrival Time</Translate>
            </span>
          </dt>
          <dd>
            {travelerhealthcardEntity.arrivalTime ? (
              <TextFormat value={travelerhealthcardEntity.arrivalTime} type="date" format={APP_DATE_FORMAT} />
            ) : null}
          </dd>
          <dt>
            <span id="firstStopovercountry">
              <Translate contentKey="jhipsterApp.travelerhealthcard.firstStopovercountry">First Stopovercountry</Translate>
            </span>
          </dt>
          <dd>{travelerhealthcardEntity.firstStopovercountry}</dd>
          <dt>
            <span id="secondStopovercountry">
              <Translate contentKey="jhipsterApp.travelerhealthcard.secondStopovercountry">Second Stopovercountry</Translate>
            </span>
          </dt>
          <dd>{travelerhealthcardEntity.secondStopovercountry}</dd>
          <dt>
            <span id="thirdStopovercountry">
              <Translate contentKey="jhipsterApp.travelerhealthcard.thirdStopovercountry">Third Stopovercountry</Translate>
            </span>
          </dt>
          <dd>{travelerhealthcardEntity.thirdStopovercountry}</dd>
          <dt>
            <span id="firstDeparturedateCountry">
              <Translate contentKey="jhipsterApp.travelerhealthcard.firstDeparturedateCountry">First Departuredate Country</Translate>
            </span>
          </dt>
          <dd>
            {travelerhealthcardEntity.firstDeparturedateCountry ? (
              <TextFormat value={travelerhealthcardEntity.firstDeparturedateCountry} type="date" format={APP_LOCAL_DATE_FORMAT} />
            ) : null}
          </dd>
          <dt>
            <span id="secondDeparturedateCountry">
              <Translate contentKey="jhipsterApp.travelerhealthcard.secondDeparturedateCountry">Second Departuredate Country</Translate>
            </span>
          </dt>
          <dd>
            {travelerhealthcardEntity.secondDeparturedateCountry ? (
              <TextFormat value={travelerhealthcardEntity.secondDeparturedateCountry} type="date" format={APP_LOCAL_DATE_FORMAT} />
            ) : null}
          </dd>
          <dt>
            <span id="thirdDeparturedateCountry">
              <Translate contentKey="jhipsterApp.travelerhealthcard.thirdDeparturedateCountry">Third Departuredate Country</Translate>
            </span>
          </dt>
          <dd>
            {travelerhealthcardEntity.thirdDeparturedateCountry ? (
              <TextFormat value={travelerhealthcardEntity.thirdDeparturedateCountry} type="date" format={APP_LOCAL_DATE_FORMAT} />
            ) : null}
          </dd>
          <dt>
            <span id="firstDurationOfstayCountry">
              <Translate contentKey="jhipsterApp.travelerhealthcard.firstDurationOfstayCountry">First Duration Ofstay Country</Translate>
            </span>
          </dt>
          <dd>{travelerhealthcardEntity.firstDurationOfstayCountry}</dd>
          <dt>
            <span id="secondDurationOfstayCountry">
              <Translate contentKey="jhipsterApp.travelerhealthcard.secondDurationOfstayCountry">Second Duration Ofstay Country</Translate>
            </span>
          </dt>
          <dd>{travelerhealthcardEntity.secondDurationOfstayCountry}</dd>
          <dt>
            <span id="thirdDurationOfstayCountry">
              <Translate contentKey="jhipsterApp.travelerhealthcard.thirdDurationOfstayCountry">Third Duration Ofstay Country</Translate>
            </span>
          </dt>
          <dd>{travelerhealthcardEntity.thirdDurationOfstayCountry}</dd>
        </dl>
        <Button tag={Link} to="/travelerhealthcard" replace color="info">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/travelerhealthcard/${travelerhealthcardEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

const mapStateToProps = ({ travelerhealthcard }: IRootState) => ({
  travelerhealthcardEntity: travelerhealthcard.entity,
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(TravelerhealthcardDetail);
