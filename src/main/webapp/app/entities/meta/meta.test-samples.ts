import { IMeta, NewMeta } from './meta.model';

export const sampleWithRequiredData: IMeta = {
  id: 17187,
  area: 'CIENCIAS_HUMANAS',
  pontuacao: 8277,
};

export const sampleWithPartialData: IMeta = {
  id: 15622,
  area: 'CIENCIAS_NATUREZA',
  pontuacao: 14505,
};

export const sampleWithFullData: IMeta = {
  id: 32703,
  area: 'LINGUAGENS_CODIGOS',
  pontuacao: 406,
};

export const sampleWithNewData: NewMeta = {
  area: 'CIENCIAS_HUMANAS',
  pontuacao: 27853,
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
