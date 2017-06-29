import {Component, OnInit} from '@angular/core';
import {Ciudad} from 'app/model/ciudad.model';
import {Tercero} from 'app/model/tercero.model';
import {TipoIdentificacion} from 'app/model/tipoIdentificacion.model';
import {CiudadService} from 'app/service/ciudad.service';
import {TerceroService} from 'app/service/tercero.service';
import {TipoIdentificacionService} from 'app/service/tipoIdentificacion.service';
import {ActivatedRoute} from '@angular/router';

@Component({
    moduleId: module.id,
    selector: 'terceros',
    templateUrl: 'encabezado.component.html'
})
export class EncabezadoComponent implements OnInit {
    
    ciudades: Array<Ciudad> = [];
    identificaciones: Array<TipoIdentificacion> = [];
    terc: Tercero= new Tercero(0, '', '', '', '', '', '', '', 0, '', '', 0,0);
    ciudad="";
    message = '';
    numero:number;
    tipo="";
    esUser=false;
    cupo=false;
    activo=false;
    fecha='';
    files='';
    idaux=0;
    habilitar=false;
    constructor(
       private serviceCiudad: CiudadService,
       private serviceTipoIden: TipoIdentificacionService,
       private serviceTercero:TerceroService,
       
       private route: ActivatedRoute
    ) {}

    ngOnInit() {

        console.log("*** Lista de Ciudades ***");
        this.serviceCiudad.findAll()
            .subscribe(
            retrievedCiudades => this.ciudades = retrievedCiudades,
            error => this.errorMessage = "Error"
            );
            
        console.log("*** Lista de Tipos de Identificacion ***");
        
        this.serviceTipoIden.findAll()
            .subscribe(
            retrievedTipoIden => this.identificaciones = retrievedTipoIden,
            error => this.errorMessage = "Error"
            );
            
        this.serviceTercero.getId()
            .subscribe(
            id => this.idaux = id,
            error => this.errorMessage = "Error"
            ); 

    }
    
    save()
    {   this.terc.idtercero=this.idaux;
        console.log(this.terc.fechaCreacion);
        if(this.activo){
            this.terc.activo=1;
        }
        else
        {
            this.terc.activo=0;
        }
        if(!this.cupo){
            this.terc.cupo=0;
        } 
        
        console.log(this.terc.idtercero);
            
        this.serviceTercero.create(this.terc)
            .subscribe(
            success => this.message='EXITO',
            error => this.message = 'Error: ' + error
            );    
            
        this.serviceTercero.asociarTerceroTipo(this.terc.idtercero,this.tipo.idtipo)
            .subscribe(
            success => this.habilitar=true,
            error => this.habilitar=false
            );    
      
        this.serviceTercero.asociarTerceroCiudad(this.terc.idtercero,this.ciudad.idciudad)
            .subscribe(
            success => this.habilitar=true,
            error =>  this.habilitar=false
            );  
            
        this.serviceTercero.asociarTerceroFecha(this.terc.idtercero,this.terc.fechaCreacion)
            .subscribe(
            success => this.habilitar=true,
            error =>  this.habilitar=false
            );  
           
        this.serviceTercero.getId()
            .subscribe(
            id => this.idaux = id,
            error => this.errorMessage = "Error"
            );   
    }
    
    cambiarTipo(){
      
         if(this.tipo.tipo!="NIT"){
             this.esUser=true;
         }
         else
         {
             this.esUser=false;
         }
    }
}

