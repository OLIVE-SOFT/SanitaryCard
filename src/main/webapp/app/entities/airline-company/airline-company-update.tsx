import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './airline-company.reducer';
import { IAirlineCompany } from 'app/shared/model/airline-company.model';
import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IAirlineCompanyUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const AirlineCompanyUpdate = (props: IAirlineCompanyUpdateProps) => {
  const [isNew, setIsNew] = useState(!props.match.params || !props.match.params.id);

  const { airlineCompanyEntity, loading, updating } = props;

  const handleClose = () => {
    props.history.push('/airline-company');
  };

  useEffect(() => {
    if (isNew) {
      props.reset();
    } else {
      props.getEntity(props.match.params.id);
    }
  }, []);

  useEffect(() => {
    if (props.updateSuccess) {
      handleClose();
    }
  }, [props.updateSuccess]);

  const saveEntity = (event, errors, values) => {
    if (errors.length === 0) {
      const entity = {
        ...airlineCompanyEntity,
        ...values,
      };

      if (isNew) {
        props.createEntity(entity);
      } else {
        props.updateEntity(entity);
      }
    }
  };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="jhipsterApp.airlineCompany.home.createOrEditLabel">
            <Translate contentKey="jhipsterApp.airlineCompany.home.createOrEditLabel">Create or edit a AirlineCompany</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <AvForm model={isNew ? {} : airlineCompanyEntity} onSubmit={saveEntity}>
              {!isNew ? (
                <AvGroup>
                  <Label for="airline-company-id">
                    <Translate contentKey="global.field.id">ID</Translate>
                  </Label>
                  <AvInput id="airline-company-id" type="text" className="form-control" name="id" required readOnly />
                </AvGroup>
              ) : null}
              <AvGroup>
                <Label id="nameLabel" for="airline-company-name">
                  <Translate contentKey="jhipsterApp.airlineCompany.name">Name</Translate>
                </Label>
                <AvField id="airline-company-name" type="text" name="name" />
              </AvGroup>
              <AvGroup>
                <Label id="iataLabel" for="airline-company-iata">
                  <Translate contentKey="jhipsterApp.airlineCompany.iata">Iata</Translate>
                </Label>
                <AvField id="airline-company-iata" type="text" name="iata" />
              </AvGroup>
              <AvGroup>
                <Label id="icaoLabel" for="airline-company-icao">
                  <Translate contentKey="jhipsterApp.airlineCompany.icao">Icao</Translate>
                </Label>
                <AvField id="airline-company-icao" type="text" name="icao" />
              </AvGroup>
              <AvGroup>
                <Label id="callsignLabel" for="airline-company-callsign">
                  <Translate contentKey="jhipsterApp.airlineCompany.callsign">Callsign</Translate>
                </Label>
                <AvField id="airline-company-callsign" type="text" name="callsign" />
              </AvGroup>
              <AvGroup>
                <Label id="countryLabel" for="airline-company-country">
                  <Translate contentKey="jhipsterApp.airlineCompany.country">Country</Translate>
                </Label>
                <AvField id="airline-company-country" type="text" name="country" />
              </AvGroup>
              <AvGroup>
                <Label id="alidLabel" for="airline-company-alid">
                  <Translate contentKey="jhipsterApp.airlineCompany.alid">Alid</Translate>
                </Label>
                <AvField id="airline-company-alid" type="string" className="form-control" name="alid" />
              </AvGroup>
              <AvGroup>
                <Label id="uidLabel" for="airline-company-uid">
                  <Translate contentKey="jhipsterApp.airlineCompany.uid">Uid</Translate>
                </Label>
                <AvField id="airline-company-uid" type="string" className="form-control" name="uid" />
              </AvGroup>
              <AvGroup>
                <Label id="aliasLabel" for="airline-company-alias">
                  <Translate contentKey="jhipsterApp.airlineCompany.alias">Alias</Translate>
                </Label>
                <AvField id="airline-company-alias" type="text" name="alias" />
              </AvGroup>
              <AvGroup>
                <Label id="modeLabel" for="airline-company-mode">
                  <Translate contentKey="jhipsterApp.airlineCompany.mode">Mode</Translate>
                </Label>
                <AvField id="airline-company-mode" type="text" name="mode" />
              </AvGroup>
              <AvGroup>
                <Label id="activeLabel" for="airline-company-active">
                  <Translate contentKey="jhipsterApp.airlineCompany.active">Active</Translate>
                </Label>
                <AvField id="airline-company-active" type="text" name="active" />
              </AvGroup>
              <Button tag={Link} id="cancel-save" to="/airline-company" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">
                  <Translate contentKey="entity.action.back">Back</Translate>
                </span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp;
                <Translate contentKey="entity.action.save">Save</Translate>
              </Button>
            </AvForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

const mapStateToProps = (storeState: IRootState) => ({
  airlineCompanyEntity: storeState.airlineCompany.entity,
  loading: storeState.airlineCompany.loading,
  updating: storeState.airlineCompany.updating,
  updateSuccess: storeState.airlineCompany.updateSuccess,
});

const mapDispatchToProps = {
  getEntity,
  updateEntity,
  createEntity,
  reset,
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(AirlineCompanyUpdate);
