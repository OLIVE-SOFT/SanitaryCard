import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import AirlineCompany from './airline-company';
import AirlineCompanyDetail from './airline-company-detail';
import AirlineCompanyUpdate from './airline-company-update';
import AirlineCompanyDeleteDialog from './airline-company-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={AirlineCompanyUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={AirlineCompanyUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={AirlineCompanyDetail} />
      <ErrorBoundaryRoute path={match.url} component={AirlineCompany} />
    </Switch>
    <ErrorBoundaryRoute exact path={`${match.url}/:id/delete`} component={AirlineCompanyDeleteDialog} />
  </>
);

export default Routes;
