import {Http, Response} from '@angular/http';
import {Location} from '@angular/common';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import {RestClient} from './rest-client';
import {Tercero} from 'app/model/tercero.model';

@Injectable()
export class TerceroService extends RestClient<Tercero> {
    baseURL = "http://localhost:8080/UniversityApp/webresources/tercero/";

    constructor(http: Http) {
        super(http);
    }
    
    getId() {
        let url = this.baseURL +'getId';
        return this.http.get(url)
            .map((res: Response) => res.json());
    }
    asociarTerceroTipo( idTercero: number,idTipo: number) {
        let url = this.baseURL +'asociarTerceroTipo/'+idTercero+'/'+idTipo;
        return this.http.get(url)
            .map((res: Response) => res.json());
    }
    asociarTerceroCiudad( idTercero: number,idCiudad: number) {
        let url = this.baseURL +'asociarTerceroCiudad/'+idTercero+'/'+idCiudad;
        return this.http.get(url)
            .map((res: Response) => res.json());
    }
    
    asociarTerceroFecha( idTercero: number,fecha: string) {
        let url = this.baseURL +'asociarTerceroFecha/'+idTercero+'/'+fecha;
        return this.http.get(url)
            .map((res: Response) => res.json());
    }
    findVendedores() {
        let url = this.baseURL+ 'vendedor';
        return this.http.get(url)
            .map((res: Response) => res.json());
    }
    
    agregarInfo(selectedValues: Array<TipoTercero> , idTercero: Integer, clasificacionUno: Integer, clasificacionDos: Integer, clasificacionTres: Integer) {
        console.log("clasif1: "+clasificacionUno); 
        //console.log("post " + this.baseURL + " " + JSON.stringify(selectedValues) );
        console.log("post "+ this.baseURL+"asociarTerceroPropiedad/"+idTercero+"/"+clasificacionUno+"/"+clasificacionDos+"/"+clasificacionTres +JSON.stringify(selectedValues) );
        return this.http.post(this.baseURL+"asociarTerceroPropiedad/"+idTercero+"/"+clasificacionUno+"/"+clasificacionDos+"/"+clasificacionTres, selectedValues)
            .map((res: Response) => res.json());
    }


}


