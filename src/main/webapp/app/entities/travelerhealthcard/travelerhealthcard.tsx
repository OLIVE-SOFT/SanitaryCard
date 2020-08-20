import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
import { Translate, ICrudGetAllAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './travelerhealthcard.reducer';
import { ITravelerhealthcard } from 'app/shared/model/travelerhealthcard.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ITravelerhealthcardProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export const Travelerhealthcard = (props: ITravelerhealthcardProps) => {
  useEffect(() => {
    props.getEntities();
  }, []);

  const { travelerhealthcardList, match, loading } = props;
  return (
    <div>
      <h2 id="travelerhealthcard-heading">
        <Translate contentKey="jhipsterApp.travelerhealthcard.home.title">Travelerhealthcards</Translate>
        <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
          <FontAwesomeIcon icon="plus" />
          &nbsp;
          <Translate contentKey="jhipsterApp.travelerhealthcard.home.createLabel">Create new Travelerhealthcard</Translate>
        </Link>
      </h2>
      <div className="table-responsive">
        {travelerhealthcardList && travelerhealthcardList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th>
                  <Translate contentKey="global.field.id">ID</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.travelerhealthcard.firstName">First Name</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.travelerhealthcard.lastName">Last Name</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.travelerhealthcard.email">Email</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.travelerhealthcard.phoneNumber">Phone Number</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.travelerhealthcard.dateOfBirth">Date Of Birth</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.travelerhealthcard.streetAddress">Street Address</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.travelerhealthcard.city">City</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.travelerhealthcard.postalCode">Postal Code</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.travelerhealthcard.flightNumber">Flight Number</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.travelerhealthcard.planeSeatNumber">Plane Seat Number</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.travelerhealthcard.airlineCompany">Airline Company</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.travelerhealthcard.temperatureMonitoring">Temperature Monitoring</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.travelerhealthcard.bodyTemperature">Body Temperature</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.travelerhealthcard.arrivalDate">Arrival Date</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.travelerhealthcard.arrivalTime">Arrival Time</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.travelerhealthcard.firstStopovercountry">First Stopovercountry</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.travelerhealthcard.secondStopovercountry">Second Stopovercountry</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.travelerhealthcard.thirdStopovercountry">Third Stopovercountry</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.travelerhealthcard.firstDeparturedateCountry">First Departuredate Country</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.travelerhealthcard.secondDeparturedateCountry">Second Departuredate Country</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.travelerhealthcard.thirdDeparturedateCountry">Third Departuredate Country</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.travelerhealthcard.firstDurationOfstayCountry">
                    First Duration Ofstay Country
                  </Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.travelerhealthcard.secondDurationOfstayCountry">
                    Second Duration Ofstay Country
                  </Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterApp.travelerhealthcard.thirdDurationOfstayCountry">
                    Third Duration Ofstay Country
                  </Translate>
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {travelerhealthcardList.map((travelerhealthcard, i) => (
                <tr key={`entity-${i}`}>
                  <td>
                    <Button tag={Link} to={`${match.url}/${travelerhealthcard.id}`} color="link" size="sm">
                      {travelerhealthcard.id}
                    </Button>
                  </td>
                  <td>{travelerhealthcard.firstName}</td>
                  <td>{travelerhealthcard.lastName}</td>
                  <td>{travelerhealthcard.email}</td>
                  <td>{travelerhealthcard.phoneNumber}</td>
                  <td>
                    {travelerhealthcard.dateOfBirth ? (
                      <TextFormat type="date" value={travelerhealthcard.dateOfBirth} format={APP_LOCAL_DATE_FORMAT} />
                    ) : null}
                  </td>
                  <td>{travelerhealthcard.streetAddress}</td>
                  <td>{travelerhealthcard.city}</td>
                  <td>{travelerhealthcard.postalCode}</td>
                  <td>{travelerhealthcard.flightNumber}</td>
                  <td>{travelerhealthcard.planeSeatNumber}</td>
                  <td>{travelerhealthcard.airlineCompany}</td>
                  <td>{travelerhealthcard.temperatureMonitoring}</td>
                  <td>{travelerhealthcard.bodyTemperature}</td>
                  <td>
                    {travelerhealthcard.arrivalDate ? (
                      <TextFormat type="date" value={travelerhealthcard.arrivalDate} format={APP_LOCAL_DATE_FORMAT} />
                    ) : null}
                  </td>
                  <td>
                    {travelerhealthcard.arrivalTime ? (
                      <TextFormat type="date" value={travelerhealthcard.arrivalTime} format={APP_DATE_FORMAT} />
                    ) : null}
                  </td>
                  <td>{travelerhealthcard.firstStopovercountry}</td>
                  <td>{travelerhealthcard.secondStopovercountry}</td>
                  <td>{travelerhealthcard.thirdStopovercountry}</td>
                  <td>
                    {travelerhealthcard.firstDeparturedateCountry ? (
                      <TextFormat type="date" value={travelerhealthcard.firstDeparturedateCountry} format={APP_LOCAL_DATE_FORMAT} />
                    ) : null}
                  </td>
                  <td>
                    {travelerhealthcard.secondDeparturedateCountry ? (
                      <TextFormat type="date" value={travelerhealthcard.secondDeparturedateCountry} format={APP_LOCAL_DATE_FORMAT} />
                    ) : null}
                  </td>
                  <td>
                    {travelerhealthcard.thirdDeparturedateCountry ? (
                      <TextFormat type="date" value={travelerhealthcard.thirdDeparturedateCountry} format={APP_LOCAL_DATE_FORMAT} />
                    ) : null}
                  </td>
                  <td>{travelerhealthcard.firstDurationOfstayCountry}</td>
                  <td>{travelerhealthcard.secondDurationOfstayCountry}</td>
                  <td>{travelerhealthcard.thirdDurationOfstayCountry}</td>
                  <td className="text-right">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`${match.url}/${travelerhealthcard.id}`} color="info" size="sm">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${travelerhealthcard.id}/edit`} color="primary" size="sm">
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${travelerhealthcard.id}/delete`} color="danger" size="sm">
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
              <Translate contentKey="jhipsterApp.travelerhealthcard.home.notFound">No Travelerhealthcards found</Translate>
            </div>
          )
        )}
      </div>
    </div>
  );
};

const mapStateToProps = ({ travelerhealthcard }: IRootState) => ({
  travelerhealthcardList: travelerhealthcard.entities,
  loading: travelerhealthcard.loading,
});

const mapDispatchToProps = {
  getEntities,
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(Travelerhealthcard);
