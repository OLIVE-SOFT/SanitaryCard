import './home.scss';
import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './travelerhealthcard.reducer';
import { ITravelerhealthcard } from 'app/shared/model/travelerhealthcard.model';
import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface ITravelerhealthcardUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> { }

export const TravelerhealthcardUpdate = (props: ITravelerhealthcardUpdateProps) => {
	const [isNew, setIsNew] = useState(!props.match.params || !props.match.params.id);

	const { travelerhealthcardEntity, loading, updating } = props;

	const handleClose = () => {
		props.history.push('/home');
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
		values.arrivalTime = convertDateTimeToServer(values.arrivalTime);

		if (errors.length === 0) {
			const entity = {
				...travelerhealthcardEntity,
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
					<h2 id="jhipsterApp.travelerhealthcard.home.createOrEditLabel">
						<Translate contentKey="jhipsterApp.travelerhealthcard.home.createOrEditLabel"> Traveler health card</Translate>
					</h2>
				</Col>
			</Row>
			<Row className="justify-content-center">
				<Col md="8">
					{loading ? (
						<p>Loading...</p>
					) : (
							<AvForm model={isNew ? {} : travelerhealthcardEntity} onSubmit={saveEntity}>
								{!isNew ? (
									<AvGroup>
										<Label for="travelerhealthcard-id">
											<Translate contentKey="global.field.id">ID</Translate>
										</Label>
										<AvInput id="travelerhealthcard-id" type="text" className="form-control" name="id" required readOnly />
									</AvGroup>
								) : null}
								<AvGroup>
									<Label id="firstNameLabel" for="travelerhealthcard-firstName">
										<Translate contentKey="jhipsterApp.travelerhealthcard.firstName"></Translate>
									</Label>
									<AvField id="travelerhealthcard-firstName" type="text" name="firstName"


										placeholder={translate('settings.form.firstname.placeholder')}
										validate={{
											required: { value: true, errorMessage: translate('register.messages.validate.login.required') },
											pattern: {
												value: '^[a-zA-Z0-9!$&*+=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$|^[_.@A-Za-z0-9-]+$',
												errorMessage: translate('register.messages.validate.login.pattern'),
											},
											minLength: { value: 1, errorMessage: translate('register.messages.validate.login.minlength') },
											maxLength: { value: 200, errorMessage: translate('register.messages.validate.login.maxlength') },
										}}
									/>


								</AvGroup>
								<AvGroup>
									<Label id="lastNameLabel" for="travelerhealthcard-lastName">
										<Translate contentKey="jhipsterApp.travelerhealthcard.lastName">Last Name</Translate>
									</Label>
									<AvField id="travelerhealthcard-lastName" type="text" name="lastName" placeholder={translate('settings.form.lastname.placeholder')}
										validate={{
											required: { value: true, errorMessage: translate('register.messages.validate.login.required') },
											pattern: {
												value: '^[a-zA-Z0-9!$&*+=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$|^[_.@A-Za-z0-9-]+$',
												errorMessage: translate('register.messages.validate.login.pattern'),
											},
											minLength: { value: 1, errorMessage: translate('register.messages.validate.login.minlength') },
											maxLength: { value: 200, errorMessage: translate('register.messages.validate.login.maxlength') },
										}} />
								</AvGroup>
								<AvGroup>
									<Label id="emailLabel" for="travelerhealthcard-email">
										
									</Label>
									<AvField id="travelerhealthcard-email"
										name="email"
										label={translate('global.form.email.label')}
										placeholder={translate('global.form.email.placeholder')}
										type="email"
										validate={{
											required: { value: true, errorMessage: translate('global.messages.validate.email.required') },
											minLength: { value: 5, errorMessage: translate('global.messages.validate.email.minlength') },
											maxLength: { value: 200, errorMessage: translate('global.messages.validate.email.maxlength') },
										}} />
								</AvGroup>
								<AvGroup>
									<Label id="phoneNumberLabel" for="travelerhealthcard-phoneNumber">
										<Translate contentKey="jhipsterApp.travelerhealthcard.phoneNumber">Phone Number</Translate>
									</Label>
									<AvField id="travelerhealthcard-phoneNumber" type="text" name="phoneNumber"
									
							placeholder={translate('settings.form.phonenumber.placeholder')}
										validate={{
											required: { value: true, errorMessage: translate('register.messages.validate.login.required') },
											pattern: {
												value: '^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-/0-9]*$',
												errorMessage: translate('register.messages.validate.login.pattern'),
											},
											minLength: { value: 1, errorMessage: translate('register.messages.validate.login.minlength') },
											maxLength: { value: 15, errorMessage: translate('register.messages.validate.login.maxlength') },
										}}		 />
								</AvGroup>
								<AvGroup>
									<Label id="dateOfBirthLabel" for="travelerhealthcard-dateOfBirth">
										<Translate contentKey="jhipsterApp.travelerhealthcard.dateOfBirth">Date Of Birth</Translate>
									</Label>
									<AvField id="travelerhealthcard-dateOfBirth" type="date" className="form-control" name="dateOfBirth" validate={{
											required: { value: true, errorMessage: translate('register.messages.validate.login.required') }, }}/>
								</AvGroup>
								<Row>
									<Col xs="15" sm="5">
								<AvGroup>
									<Label id="streetAddressLabel" for="travelerhealthcard-streetAddress">
										<Translate contentKey="jhipsterApp.travelerhealthcard.streetAddress">Street Address</Translate>
									</Label>
							
									<AvField id="travelerhealthcard-streetAddress" type="text" name="streetAddress"
										validate={{
											required: { value: true, errorMessage: translate('register.messages.validate.login.required') },}} />
											
								</AvGroup>
								</Col>
								<AvGroup>
								 <Col xs="15" sm="10">
									<Label id="cityLabel" for="travelerhealthcard-city">
										<Translate contentKey="jhipsterApp.travelerhealthcard.city">City</Translate>
									</Label>
									            
 
									<AvField id="travelerhealthcard-city" type="text" name="city" 
									validate={{
											required: { value: true, errorMessage: translate('register.messages.validate.login.required') },}}	 />
								            </Col >
 </AvGroup>
								<AvGroup>
								 <Col xs="12" sm="8">
									<Label id="postalCodeLabel" for="travelerhealthcard-postalCode">
										<Translate contentKey="jhipsterApp.travelerhealthcard.postalCode">Postal Code</Translate>
									</Label>
								
 
									<AvField id="travelerhealthcard-postalCode" type="text" name="postalCode" 	validate={{
											required: { value: true, errorMessage: translate('register.messages.validate.login.required') },
											pattern: {
												value: '^([0-9]{2}|(2A)|2B)[[0-9]{2}',
												errorMessage: translate('register.messages.validate.login.pattern'),
											}, }}  />
											</Col >
 
								</AvGroup>
								</Row>
								<AvGroup>
									<Label id="flightNumberLabel" for="travelerhealthcard-flightNumber">
										<Translate contentKey="jhipsterApp.travelerhealthcard.flightNumber">Flight Number</Translate>
									</Label>
									<AvField id="travelerhealthcard-flightNumber" type="text" name="flightNumber" 			validate={{
											required: { value: true, errorMessage: translate('register.messages.validate.login.required') },
											
										}}	 />
								</AvGroup>
								<AvGroup>
									<Label id="planeSeatNumberLabel" for="travelerhealthcard-planeSeatNumber">
										<Translate contentKey="jhipsterApp.travelerhealthcard.planeSeatNumber">Plane Seat Number</Translate>
									</Label>
									<AvField id="travelerhealthcard-planeSeatNumber" type="text" name="planeSeatNumber" 
									validate={{
											required: { value: true, errorMessage: translate('register.messages.validate.login.required') },
											pattern: {
												value: '^[0-9]{2}[A-B-C-D-E-F-H-J-K]+$' ,
												errorMessage: translate('register.messages.validate.login.pattern'),
											},
											minLength: { value: 3, errorMessage: translate('register.messages.validate.login.minlength') },
											maxLength: { value: 3, errorMessage: translate('register.messages.validate.login.maxlength') },
										}}	 />
								</AvGroup>
						
								
								<AvGroup>
									<Label id="bodyTemperatureLabel" for="travelerhealthcard-bodyTemperature">
										<Translate contentKey="jhipsterApp.travelerhealthcard.bodyTemperature">Body Temperature</Translate>
									</Label>
									<AvField id="travelerhealthcard-bodyTemperature" type="select" className="form-control" name="bodyTemperature" >
									<option></option>
									<option>35</option>
									<option>36</option>
									<option>37</option>
									<option>38</option>
									<option>39</option>
									<option>40</option>
									<option>41</option>
									<option>42</option>
									
									
									</AvField>
								</AvGroup>
								
								<AvGroup>
									<Label id="arrivalDateLabel" for="travelerhealthcard-arrivalDate">
										<Translate contentKey="jhipsterApp.travelerhealthcard.arrivalDate">Arrival Date</Translate>
									</Label>
									<AvField id="travelerhealthcard-arrivalDate" type="date" className="form-control" name="arrivalDate" />
								</AvGroup>
								<AvGroup>
									<Label id="arrivalTimeLabel" for="travelerhealthcard-arrivalTime">
										<Translate contentKey="jhipsterApp.travelerhealthcard.arrivalTime">Arrival Time</Translate>
									</Label>
									<AvInput
										id="travelerhealthcard-arrivalTime"
										type="datetime-local"
										className="form-control"
										name="arrivalTime"
										placeholder={'YYYY-MM-DD HH:mm'}
										value={isNew ? displayDefaultDateTime() : convertDateTimeFromServer(props.travelerhealthcardEntity.arrivalTime)}
									/>
								</AvGroup>
								<AvGroup>
									<Label id="firstStopovercountryLabel" for="travelerhealthcard-firstStopovercountry">
										<Translate contentKey="jhipsterApp.travelerhealthcard.firstStopovercountry">First Stopovercountry</Translate>
									</Label>
									<AvField id="travelerhealthcard-firstStopovercountry" type="text" name="firstStopovercountry" />
								</AvGroup>
								<AvGroup>
									<Label id="secondStopovercountryLabel" for="travelerhealthcard-secondStopovercountry">
										<Translate contentKey="jhipsterApp.travelerhealthcard.secondStopovercountry">Second Stopovercountry</Translate>
									</Label>
									<AvField id="travelerhealthcard-secondStopovercountry" type="text" name="secondStopovercountry" />
								</AvGroup>
								<AvGroup>
									<Label id="thirdStopovercountryLabel" for="travelerhealthcard-thirdStopovercountry">
										<Translate contentKey="jhipsterApp.travelerhealthcard.thirdStopovercountry">Third Stopovercountry</Translate>
									</Label>
									<AvField id="travelerhealthcard-thirdStopovercountry" type="text" name="thirdStopovercountry" />
								</AvGroup>
								<AvGroup>
									<Label id="firstDeparturedateCountryLabel" for="travelerhealthcard-firstDeparturedateCountry">
										<Translate contentKey="jhipsterApp.travelerhealthcard.firstDeparturedateCountry">First Departuredate Country</Translate>
									</Label>
									<AvField
										id="travelerhealthcard-firstDeparturedateCountry"
										type="date"
										className="form-control"
										name="firstDeparturedateCountry"
									/>
								</AvGroup>
								<AvGroup>
									<Label id="secondDeparturedateCountryLabel" for="travelerhealthcard-secondDeparturedateCountry">
										<Translate contentKey="jhipsterApp.travelerhealthcard.secondDeparturedateCountry">Second Departuredate Country</Translate>
									</Label>
									<AvField
										id="travelerhealthcard-secondDeparturedateCountry"
										type="date"
										className="form-control"
										name="secondDeparturedateCountry"
									/>
								</AvGroup>
								<AvGroup>
									<Label id="thirdDeparturedateCountryLabel" for="travelerhealthcard-thirdDeparturedateCountry">
										<Translate contentKey="jhipsterApp.travelerhealthcard.thirdDeparturedateCountry">Third Departuredate Country</Translate>
									</Label>
									<AvField
										id="travelerhealthcard-thirdDeparturedateCountry"
										type="date"
										className="form-control"
										name="thirdDeparturedateCountry"
									/>
								</AvGroup>
								<AvGroup>
									<Label id="firstDurationOfstayCountryLabel" for="travelerhealthcard-firstDurationOfstayCountry">
										<Translate contentKey="jhipsterApp.travelerhealthcard.firstDurationOfstayCountry">
											First Duration Ofstay Country
                  </Translate>
									</Label>
									<AvField id="travelerhealthcard-firstDurationOfstayCountry" type="text" name="firstDurationOfstayCountry" />
								</AvGroup>
								<AvGroup>
									<Label id="secondDurationOfstayCountryLabel" for="travelerhealthcard-secondDurationOfstayCountry">
										<Translate contentKey="jhipsterApp.travelerhealthcard.secondDurationOfstayCountry">
											Second Duration Ofstay Country
                  </Translate>
									</Label>
									<AvField id="travelerhealthcard-secondDurationOfstayCountry" type="text" name="secondDurationOfstayCountry" />
								</AvGroup>
								<AvGroup>
									<Label id="thirdDurationOfstayCountryLabel" for="travelerhealthcard-thirdDurationOfstayCountry">
										<Translate contentKey="jhipsterApp.travelerhealthcard.thirdDurationOfstayCountry">
											Third Duration Ofstay Country
                  </Translate>
									</Label>
									<AvField id="travelerhealthcard-thirdDurationOfstayCountry" type="text" name="thirdDurationOfstayCountry" />
								</AvGroup>
								<Button tag={Link} id="cancel-save" to="/travelerhealthcard" replace color="info">
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
	travelerhealthcardEntity: storeState.travelerhealthcard.entity,
	loading: storeState.travelerhealthcard.loading,
	updating: storeState.travelerhealthcard.updating,
	updateSuccess: storeState.travelerhealthcard.updateSuccess,
});

const mapDispatchToProps = {
	getEntity,
	updateEntity,
	createEntity,
	reset,
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(TravelerhealthcardUpdate);
