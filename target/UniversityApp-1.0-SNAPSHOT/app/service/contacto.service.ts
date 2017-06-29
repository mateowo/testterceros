import {Http, Response} from '@angular/http';
import {Location} from '@angular/common';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import {RestClient} from './rest-client';
import {Contacto} from 'app/model/contacto.model';

@Injectable()
export class ContactoService extends RestClient<Contacto> {
    baseURL = "http://localhost:8080/UniversityApp/webresources/contacto/";


    constructor(http: Http) {
        super(http);
    }
    
    asociarTerceroContacto( idTercero: number,idContacto: number) {
        let url = this.baseURL +'asociarTerceroContacto/'+idTercero+'/'+idContacto;
        return this.http.get(url)
            .map((res: Response) => res.json());
    }
    
        getId() {
        let url = this.baseURL +'getId';
        return this.http.get(url)
            .map((res: Response) => res.json());
    }
     getContactosByTerceros( idTercero: number) {
        let url = this.baseURL +'getContactosByTerceros/'+idTercero;
        return this.http.get(url)
            .map((res: Response) => res.json());
    }

}
