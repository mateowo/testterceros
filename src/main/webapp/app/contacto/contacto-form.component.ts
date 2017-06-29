import {Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import {Contacto} from 'app/model/contacto.model';
import {ContactoService} from 'app/service/contacto.service';

@Component({
    moduleId: module.id,
    selector: 'contacto-form',
    templateUrl: 'contacto-form.component.html'
})
export class ContactoFormComponent implements OnInit {
    @Output() notify: EventEmitter<Contacto> = new EventEmitter<Contacto>();
    @Input() contacto: Contacto;
    @Input() tercero: number;
    message: string = "";
    errors = {nameContact: false, phone: false, relation: false};
    idaux=0;
    constructor(
        private service: ContactoService
    ) {}

    ngOnInit() {
        this.service.getId()
            .subscribe(
            id => this.idaux = id,
            error => this.errorMessage = "Error"
            );  
    }
    
    validContact(): boolean {
        this.errors.nameContact = !(this.contacto.nombrecontacto);
        this.errors.phone = !(this.contacto.telefonocontacto);
        this.errors.relation = !(this.contacto.relacion);
        
        return !this.errors.nameContact && !this.errors.phone && !this.errors.relation;
    }

    saveContact() {
        if(!this.validContact())
            return;
            
        if (this.contacto.idcontacto) {
            console.log("EDITANDO");
            console.log(this.contacto.idcontacto);
            this.contacto.id=this.contacto.idcontacto;
            this.service.edit(this.contacto)
                .subscribe(
                    success => {
                        this.message = 'Contacto modificado exitosamente.';
                        this.notify.emit(this.contacto);
                    },
                    error => this.message = 'Error al modificiar: ' + error
                );
        } else {
            console.log("creando");
            console.log("tecero"+this.tercero);
            this.contacto.idcontacto = this.idaux;
            
            
            this.service.create(this.contacto)
                .subscribe(
                    success => {
                        this.message = 'Contacto agregado exitosamente.';
                        this.notify.emit(success);
                    },
                    error => this.message = 'Error al crear: ' + error
                );
                console.log("contacto"+this.contacto.idcontacto);
            this.service.asociarTerceroContacto(this.tercero,this.contacto.idcontacto)
                .subscribe(
                success => this.message='EXITOterccontacto',
                error => this.message = 'Error: ' + error
                ); 
                
            this.service.getId()
                .subscribe(
                id => this.idaux = id,
                error => this.errorMessage = "Error"
                );  
        }
    }
    
    clearForm(){
        this.errors.nameContact = false;
        this.errors.phone = false;
        this.errors.relation = false;
        this.notify.emit(null);
    }
}