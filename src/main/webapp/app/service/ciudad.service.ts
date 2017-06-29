import {Http, Response} from '@angular/http';
import {Location} from '@angular/common';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import {RestClient} from './rest-client';
import {Ciudad} from 'app/model/ciudad.model';

@Injectable()
export class CiudadService extends RestClient<Ciudad> {
    baseURL = "http://localhost:8080/UniversityApp/webresources/ciudad/";

    constructor(http: Http) {
        super(http);
    }

}


