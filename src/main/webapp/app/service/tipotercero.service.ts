import {Http, Response} from '@angular/http';
import {Location} from '@angular/common';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import {RestClient} from './rest-client';
import {Tipotercero} from 'app/model/tipotercero.model';

@Injectable()
export class TipoTerceroService extends RestClient<Tipotercero> {
    baseURL = "http://localhost:8080/UniversityApp/webresources/tipotercero/";

    constructor(http: Http) {
        super(http);
    }

}
