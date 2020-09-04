import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, ICrudGetAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './airline-company.reducer';
import { IAirlineCompany } from 'app/shared/model/airline-company.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IAirlineCompanyDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const AirlineCompanyDetail = (props: IAirlineCompanyDetailProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const { airlineCompanyEntity } = props;
  return (
    <Row>
      <Col md="8">
        <h2>
          <Translate contentKey="jhipsterApp.airlineCompany.detail.title">AirlineCompany</Translate> [<b>{airlineCompanyEntity.id}</b>]
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="name">
              <Translate contentKey="jhipsterApp.airlineCompany.name">Name</Translate>
            </span>
          </dt>
          <dd>{airlineCompanyEntity.name}</dd>
          <dt>
            <span id="iata">
              <Translate contentKey="jhipsterApp.airlineCompany.iata">Iata</Translate>
            </span>
          </dt>
          <dd>{airlineCompanyEntity.iata}</dd>
          <dt>
            <span id="icao">
              <Translate contentKey="jhipsterApp.airlineCompany.icao">Icao</Translate>
            </span>
          </dt>
          <dd>{airlineCompanyEntity.icao}</dd>
          <dt>
            <span id="callsign">
              <Translate contentKey="jhipsterApp.airlineCompany.callsign">Callsign</Translate>
            </span>
          </dt>
          <dd>{airlineCompanyEntity.callsign}</dd>
          <dt>
            <span id="country">
              <Translate contentKey="jhipsterApp.airlineCompany.country">Country</Translate>
            </span>
          </dt>
          <dd>{airlineCompanyEntity.country}</dd>
          <dt>
            <span id="alid">
              <Translate contentKey="jhipsterApp.airlineCompany.alid">Alid</Translate>
            </span>
          </dt>
          <dd>{airlineCompanyEntity.alid}</dd>
          <dt>
            <span id="uid">
              <Translate contentKey="jhipsterApp.airlineCompany.uid">Uid</Translate>
            </span>
          </dt>
          <dd>{airlineCompanyEntity.uid}</dd>
          <dt>
            <span id="alias">
              <Translate contentKey="jhipsterApp.airlineCompany.alias">Alias</Translate>
            </span>
          </dt>
          <dd>{airlineCompanyEntity.alias}</dd>
          <dt>
            <span id="mode">
              <Translate contentKey="jhipsterApp.airlineCompany.mode">Mode</Translate>
            </span>
          </dt>
          <dd>{airlineCompanyEntity.mode}</dd>
          <dt>
            <span id="active">
              <Translate contentKey="jhipsterApp.airlineCompany.active">Active</Translate>
            </span>
          </dt>
          <dd>{airlineCompanyEntity.active}</dd>
        </dl>
        <Button tag={Link} to="/airline-company" replace color="info">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/airline-company/${airlineCompanyEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

const mapStateToProps = ({ airlineCompany }: IRootState) => ({
  airlineCompanyEntity: airlineCompany.entity,
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(AirlineCompanyDetail);
