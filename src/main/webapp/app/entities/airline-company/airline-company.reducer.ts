import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { IAirlineCompany, defaultValue } from 'app/shared/model/airline-company.model';

export const ACTION_TYPES = {
  FETCH_AIRLINECOMPANY_LIST: 'airlineCompany/FETCH_AIRLINECOMPANY_LIST',
  FETCH_AIRLINECOMPANY: 'airlineCompany/FETCH_AIRLINECOMPANY',
  CREATE_AIRLINECOMPANY: 'airlineCompany/CREATE_AIRLINECOMPANY',
  UPDATE_AIRLINECOMPANY: 'airlineCompany/UPDATE_AIRLINECOMPANY',
  DELETE_AIRLINECOMPANY: 'airlineCompany/DELETE_AIRLINECOMPANY',
  RESET: 'airlineCompany/RESET',
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<IAirlineCompany>,
  entity: defaultValue,
  updating: false,
  updateSuccess: false,
};

export type AirlineCompanyState = Readonly<typeof initialState>;

// Reducer

export default (state: AirlineCompanyState = initialState, action): AirlineCompanyState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_AIRLINECOMPANY_LIST):
    case REQUEST(ACTION_TYPES.FETCH_AIRLINECOMPANY):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true,
      };
    case REQUEST(ACTION_TYPES.CREATE_AIRLINECOMPANY):
    case REQUEST(ACTION_TYPES.UPDATE_AIRLINECOMPANY):
    case REQUEST(ACTION_TYPES.DELETE_AIRLINECOMPANY):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true,
      };
    case FAILURE(ACTION_TYPES.FETCH_AIRLINECOMPANY_LIST):
    case FAILURE(ACTION_TYPES.FETCH_AIRLINECOMPANY):
    case FAILURE(ACTION_TYPES.CREATE_AIRLINECOMPANY):
    case FAILURE(ACTION_TYPES.UPDATE_AIRLINECOMPANY):
    case FAILURE(ACTION_TYPES.DELETE_AIRLINECOMPANY):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload,
      };
    case SUCCESS(ACTION_TYPES.FETCH_AIRLINECOMPANY_LIST):
      return {
        ...state,
        loading: false,
        entities: action.payload.data,
      };
    case SUCCESS(ACTION_TYPES.FETCH_AIRLINECOMPANY):
      return {
        ...state,
        loading: false,
        entity: action.payload.data,
      };
    case SUCCESS(ACTION_TYPES.CREATE_AIRLINECOMPANY):
    case SUCCESS(ACTION_TYPES.UPDATE_AIRLINECOMPANY):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data,
      };
    case SUCCESS(ACTION_TYPES.DELETE_AIRLINECOMPANY):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: {},
      };
    case ACTION_TYPES.RESET:
      return {
        ...initialState,
      };
    default:
      return state;
  }
};

const apiUrl = 'api/airline-companies';

// Actions

export const getEntities: ICrudGetAllAction<IAirlineCompany> = (page, size, sort) => ({
  type: ACTION_TYPES.FETCH_AIRLINECOMPANY_LIST,
  payload: axios.get<IAirlineCompany>(`${apiUrl}?cacheBuster=${new Date().getTime()}`),
});

export const getEntity: ICrudGetAction<IAirlineCompany> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_AIRLINECOMPANY,
    payload: axios.get<IAirlineCompany>(requestUrl),
  };
};

export const createEntity: ICrudPutAction<IAirlineCompany> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_AIRLINECOMPANY,
    payload: axios.post(apiUrl, cleanEntity(entity)),
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<IAirlineCompany> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_AIRLINECOMPANY,
    payload: axios.put(apiUrl, cleanEntity(entity)),
  });
  return result;
};

export const deleteEntity: ICrudDeleteAction<IAirlineCompany> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_AIRLINECOMPANY,
    payload: axios.delete(requestUrl),
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET,
});
