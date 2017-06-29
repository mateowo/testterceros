import {Http, Response} from '@angular/http';
import {Location} from '@angular/common';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import {RestClient} from './rest-client';
import {TipoIdentificacion} from 'app/model/tipoIdentificacion.model';

@Injectable()
export class TipoIdentificacionService extends RestClient<TipoIdentificacion> {
    baseURL = "http://localhost:8080/UniversityApp/webresources/tipoidentificacion/";

    constructor(http: Http) {
        super(http);
    }

}


