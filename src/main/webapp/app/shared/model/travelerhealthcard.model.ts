import { Moment } from 'moment';

export interface ITravelerhealthcard {
  id?: number;
  firstName?: string;
  lastName?: string;
  email?: string;
  phoneNumber?: string;
  dateOfBirth?: string;
  streetAddress?: string;
  city?: string;
  postalCode?: string;
  flightNumber?: string;
  planeSeatNumber?: string;
  airlineCompany?: string;
  temperatureMonitoring?: number;
  bodyTemperature?: number;
  arrivalDate?: string;
  arrivalTime?: string;
  firstStopovercountry?: string;
  secondStopovercountry?: string;
  thirdStopovercountry?: string;
  firstDeparturedateCountry?: string;
  secondDeparturedateCountry?: string;
  thirdDeparturedateCountry?: string;
  firstDurationOfstayCountry?: number;
  secondDurationOfstayCountry?: number;
  thirdDurationOfstayCountry?: number;
}

export const defaultValue: Readonly<ITravelerhealthcard> = {};
