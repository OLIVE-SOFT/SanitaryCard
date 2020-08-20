import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Travelerhealthcard from './travelerhealthcard';
import TravelerhealthcardDetail from './travelerhealthcard-detail';
import TravelerhealthcardUpdate from './travelerhealthcard-update';
import TravelerhealthcardDeleteDialog from './travelerhealthcard-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={TravelerhealthcardUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={TravelerhealthcardUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={TravelerhealthcardDetail} />
      <ErrorBoundaryRoute path={match.url} component={Travelerhealthcard} />
    </Switch>
    <ErrorBoundaryRoute exact path={`${match.url}/:id/delete`} component={TravelerhealthcardDeleteDialog} />
  </>
);

export default Routes;
