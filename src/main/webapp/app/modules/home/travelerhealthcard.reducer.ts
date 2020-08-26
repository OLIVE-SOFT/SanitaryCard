import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { ITravelerhealthcard, defaultValue } from 'app/shared/model/travelerhealthcard.model';

export const ACTION_TYPES = {
  FETCH_TRAVELERHEALTHCARD_LIST: 'travelerhealthcard/FETCH_TRAVELERHEALTHCARD_LIST',
  FETCH_TRAVELERHEALTHCARD: 'travelerhealthcard/FETCH_TRAVELERHEALTHCARD',
  CREATE_TRAVELERHEALTHCARD: 'travelerhealthcard/CREATE_TRAVELERHEALTHCARD',
  UPDATE_TRAVELERHEALTHCARD: 'travelerhealthcard/UPDATE_TRAVELERHEALTHCARD',
  DELETE_TRAVELERHEALTHCARD: 'travelerhealthcard/DELETE_TRAVELERHEALTHCARD',
  RESET: 'travelerhealthcard/RESET',
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<ITravelerhealthcard>,
  entity: defaultValue,
  updating: false,
  updateSuccess: false,
};

export type TravelerhealthcardState = Readonly<typeof initialState>;

// Reducer

export default (state: TravelerhealthcardState = initialState, action): TravelerhealthcardState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_TRAVELERHEALTHCARD_LIST):
    case REQUEST(ACTION_TYPES.FETCH_TRAVELERHEALTHCARD):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true,
      };
    case REQUEST(ACTION_TYPES.CREATE_TRAVELERHEALTHCARD):
    case REQUEST(ACTION_TYPES.UPDATE_TRAVELERHEALTHCARD):
    case REQUEST(ACTION_TYPES.DELETE_TRAVELERHEALTHCARD):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true,
      };
    case FAILURE(ACTION_TYPES.FETCH_TRAVELERHEALTHCARD_LIST):
    case FAILURE(ACTION_TYPES.FETCH_TRAVELERHEALTHCARD):
    case FAILURE(ACTION_TYPES.CREATE_TRAVELERHEALTHCARD):
    case FAILURE(ACTION_TYPES.UPDATE_TRAVELERHEALTHCARD):
    case FAILURE(ACTION_TYPES.DELETE_TRAVELERHEALTHCARD):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload,
      };
    case SUCCESS(ACTION_TYPES.FETCH_TRAVELERHEALTHCARD_LIST):
      return {
        ...state,
        loading: false,
        entities: action.payload.data,
      };
    case SUCCESS(ACTION_TYPES.FETCH_TRAVELERHEALTHCARD):
      return {
        ...state,
        loading: false,
        entity: action.payload.data,
      };
    case SUCCESS(ACTION_TYPES.CREATE_TRAVELERHEALTHCARD):
    case SUCCESS(ACTION_TYPES.UPDATE_TRAVELERHEALTHCARD):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data,
      };
    case SUCCESS(ACTION_TYPES.DELETE_TRAVELERHEALTHCARD):
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

const apiUrl = 'api/travelerhealthcards';

// Actions

export const getEntities: ICrudGetAllAction<ITravelerhealthcard> = (page, size, sort) => ({
  type: ACTION_TYPES.FETCH_TRAVELERHEALTHCARD_LIST,
  payload: axios.get<ITravelerhealthcard>(`${apiUrl}?cacheBuster=${new Date().getTime()}`),
});

export const getEntity: ICrudGetAction<ITravelerhealthcard> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_TRAVELERHEALTHCARD,
    payload: axios.get<ITravelerhealthcard>(requestUrl),
  };
};

export const createEntity: ICrudPutAction<ITravelerhealthcard> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_TRAVELERHEALTHCARD,
    payload: axios.post(apiUrl, cleanEntity(entity)),
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<ITravelerhealthcard> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_TRAVELERHEALTHCARD,
    payload: axios.put(apiUrl, cleanEntity(entity)),
  });
  return result;
};

export const deleteEntity: ICrudDeleteAction<ITravelerhealthcard> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_TRAVELERHEALTHCARD,
    payload: axios.delete(requestUrl),
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET,
});
