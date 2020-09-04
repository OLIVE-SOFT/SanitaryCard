import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
import { Translate, ICrudGetAllAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './airline-company.reducer';
import { IAirlineCompany } from 'app/shared/model/airline-company.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IAirlineCompanyProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export const AirlineCompany = (props: IAirlineCompanyProps) => {
  useEffect(() => {
    props.getEntities();
  }, []);

  const { airlineCompanyList, match, loading } = props;
  return (
    <div>
      <h2 id="airline-company-heading">
        <Translate contentKey="jhipsterApp.airlineCompany.home.title">Airline Companies</Translate>
        <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
          <FontAwesomeIcon icon="plus" />
          &nbsp;
          <Translate contentKey="jhipsterApp.airlineCompany.home.createLabel">Create new Airline Company</Translate>
        </Link>
      </h2>
      <div className="table-responsive">
        {airlineCompanyList && airlineCompanyList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th>
                  <Translate contentKey="global.field.id">ID</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.airlineCompany.name">Name</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.airlineCompany.iata">Iata</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.airlineCompany.icao">Icao</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.airlineCompany.callsign">Callsign</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.airlineCompany.country">Country</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.airlineCompany.alid">Alid</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.airlineCompany.uid">Uid</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.airlineCompany.alias">Alias</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.airlineCompany.mode">Mode</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.airlineCompany.active">Active</Translate>
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {airlineCompanyList.map((airlineCompany, i) => (
                <tr key={`entity-${i}`}>
                  <td>
                    <Button tag={Link} to={`${match.url}/${airlineCompany.id}`} color="link" size="sm">
                      {airlineCompany.id}
                    </Button>
                  </td>
                  <td>{airlineCompany.name}</td>
                  <td>{airlineCompany.iata}</td>
                  <td>{airlineCompany.icao}</td>
                  <td>{airlineCompany.callsign}</td>
                  <td>{airlineCompany.country}</td>
                  <td>{airlineCompany.alid}</td>
                  <td>{airlineCompany.uid}</td>
                  <td>{airlineCompany.alias}</td>
                  <td>{airlineCompany.mode}</td>
                  <td>{airlineCompany.active}</td>
                  <td className="text-right">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`${match.url}/${airlineCompany.id}`} color="info" size="sm">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${airlineCompany.id}/edit`} color="primary" size="sm">
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${airlineCompany.id}/delete`} color="danger" size="sm">
                        <FontAwesomeIcon icon="trash" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.delete">Delete</Translate>
                        </span>
                      </Button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        ) : (
          !loading && (
            <div className="alert alert-warning">
              <Translate contentKey="jhipsterApp.airlineCompany.home.notFound">No Airline Companies found</Translate>
            </div>
          )
        )}
      </div>
    </div>
  );
};

const mapStateToProps = ({ airlineCompany }: IRootState) => ({
  airlineCompanyList: airlineCompany.entities,
  loading: airlineCompany.loading,
});

const mapDispatchToProps = {
  getEntities,
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(AirlineCompany);
