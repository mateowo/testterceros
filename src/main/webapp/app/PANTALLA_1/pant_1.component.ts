import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Tipotercero} from 'app/model/tipotercero.model'
import {Clasificacion} from 'app/model/clasificacion.model'
import {Tercero} from 'app/model/tercero.model'
import {TipoTerceroService} from 'app/service/tipotercero.service'
import {ClasificacionService} from 'app/service/clasificacion.service'
import {TerceroService} from 'app/service/tercero.service'

@Component({
    moduleId: module.id,
    selector: 'PANTALLA_1',
    templateUrl: 'pant_1.component.html'
})
export class LaPantallaUno implements OnInit {
    tipoterceros : Array<TipoTercero> = [];
    selectedValue : Array<TipoTercero> = [];
    prueba : string;
    hayImagen=false;
    logo : any;
    selectedValueVendedor : Tercero;
    selectedValueClasUno: Clasificacion;
    selectedValueClasDos: Clasificacion;
    selectedValueClasTres: Clasificacion;
    clasificacionUno : Array<Clasificacion> = [];
    clasificacionDos : Array<Clasificacion> = [];
    clasificacionTres : Array<Clasificacion> = [];
    vendedores : Array<Tercero> = [];
    selecterRoute : string;
    errorMessage = '';
    cadena='';
    idTercero=1;
    
    constructor(
       private tipoterceroService :TipoTerceroService,
       private clasificacionService :ClasificacionService,
       private terceroService :TerceroService,
       private route: ActivatedRoute
       
    ) {}

    ngOnInit() {
        this.idTercero=this.route.snapshot.params['id'];
            
            
       this.tipoterceroService.findAll()
            .subscribe(
            retrievedtipos => this.tipoterceros = retrievedtipos,
            error => this.errorMessage = "Error"
            );
       this.clasificacionService.findClasifUno()
            .subscribe(
            retrievedclasi1 => this.clasificacionUno = retrievedclasi1,
            error => this.errorMessage = "Error"
            );
       this.clasificacionService.findClasifDos()
            .subscribe(
            retrievedclasi2 => this.clasificacionDos = retrievedclasi2,
            error => this.errorMessage = "Error"
            );
       this.clasificacionService.findClasifTres()
            .subscribe(
            retrievedclasi3 => this.clasificacionTres = retrievedclasi3,
            error => this.errorMessage = "Error"
            );
        this.terceroService.findVendedores()
            .subscribe(
            retrievedTerceros => this.vendedores = retrievedTerceros,
            error => this.errorMessage = "Error"
            );
       
    }
    cambiar(){
        this.cadena='';
        for(var i = 0; i < this.selectedValue.length; i++){
            this.cadena=this.cadena+((this.selectedValue[i]).tipotercero)+'\n';
        }
        console.log(this.selectedRoute);
        console.log((this.selectedValue[0]).tipotercero);
        
    }
    
    onChange(event) {
        let eventObj: MSInputMethodContext = <MSInputMethodContext> event;
        let target: HTMLInputElement = <HTMLInputElement> eventObj.target;
        let files: FileList = target.files;
        this.file = files[0].name;
        console.log(this.file);
    }
    
    onFileChange(fileInput: any){
        this.logo = fileInput.target.files[0];

        let reader = new FileReader();

        reader.onload = (e: any) => {
            this.logo = e.target.result;
        }

        reader.readAsDataURL(fileInput.target.files[0]);
        this.hayImagen=true;
    }

    upload(){
        
     this.terceroService.agregarInfo(this.selectedValue,this.idTercero, this.selectedValueClasUno.idclasificacion, this.selectedValueClasDos.idclasificacion, this.selectedValueClasTres.idclasificacion)
     .subscribe(
     error => this.errorMessage = "Error"
     );
        
        
    }
}
