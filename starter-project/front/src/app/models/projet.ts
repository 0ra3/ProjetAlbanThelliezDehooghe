import { User } from './user';
import { Category } from './category';
import { Don } from './don';
import { Url } from 'url';

export class Projet {
    id : number;
    nom : string;
    description : string;
    budget : number;
    don: Don[];
    ressource: number;
    user : User;
    category : Category;
    image : string;

}
