import { IAluno } from 'app/entities/aluno/aluno.model';
import { AreaEnem } from 'app/entities/enumerations/area-enem.model';

export interface IMeta {
  id: number;
  area?: keyof typeof AreaEnem | null;
  pontuacao?: number | null;
  aluno?: IAluno | null;
}

export type NewMeta = Omit<IMeta, 'id'> & { id: null };
