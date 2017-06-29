import {Http, Response} from '@angular/http';
import {Location} from '@angular/common';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import {RestClient} from './rest-client';
import {Clasificacion} from 'app/model/clasificacion.model';

@Injectable()
export class ClasificacionService extends RestClient<Clasificacion> {
    baseURL = "http://localhost:8080/UniversityApp/webresources/clasificacion/";

    constructor(http: Http) {
        super(http);
    }
    
    findClasifUno() {
        let url = this.baseURL+ 'clasi1';
        return this.http.get(url)
            .map((res: Response) => res.json());
    }
    
    findClasifDos() {
        let url = this.baseURL+ 'clasi2';
        return this.http.get(url)
            .map((res: Response) => res.json());
    }
    
    findClasifTres() {
        let url = this.baseURL+ 'clasi3';
        return this.http.get(url)
            .map((res: Response) => res.json());
    }
    
}
