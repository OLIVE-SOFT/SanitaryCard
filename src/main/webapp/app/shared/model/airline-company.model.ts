export interface IAirlineCompany {
  id?: number;
  name?: string;
  iata?: string;
  icao?: string;
  callsign?: string;
  country?: string;
  alid?: number;
  uid?: number;
  alias?: string;
  mode?: string;
  active?: string;
}

export const defaultValue: Readonly<IAirlineCompany> = {};
