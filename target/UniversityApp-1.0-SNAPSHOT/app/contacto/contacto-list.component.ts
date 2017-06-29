import {Component, OnInit} from '@angular/core';
import {Contacto} from 'app/model/contacto.model';
import {ContactoService} from 'app/service/contacto.service';
import {ActivatedRoute} from '@angular/router';
@Component({
    moduleId: module.id,
    selector: 'contacto',
    templateUrl: 'contacto-list.component.html'
})
export class ContactoListComponent implements OnInit {
    idTercero: number = 1;
    contactos: Array<Contacto> = [];
    currentContact:Contacto = new Contacto(0, "", "", "");
    message: string = "";
    
    constructor(
        private service: ContactoService,
        private route: ActivatedRoute
        ){
        
    }
    
    ngOnInit() {
        this.idTercero = this.route.snapshot.params['id'];
        console.log("Inicia: "+this.idTercero);
        this.service.getContactosByTerceros(this.idTercero)
            .subscribe(
                result => this.contactos = result,
                error => this.message = "Error get contactos by terc1"
            );
    }
    
    editContact(contacto:Contacto){
        this.currentContact = contacto;
    }
    
    removeContact(id: number) {
        this.service.remove(id)
            .subscribe(
                success => {
                    let pos = this.contactos.map(c => c.idContacto).indexOf(id);
                    this.contactos.splice(pos,1);
                },
                error => this.message = "Error"
            );
            
        this.message = 'Contacto eliminado';
    }
    
    onNotify(contact: Contacto):void {
        console.log("Actualiza: "+this.idTercero);
          this.service.getContactosByTerceros(this.idTercero)
            .subscribe(
                result => this.contactos = result,
                error => this.message = "Error get contactos by terc2"
            );
        
        this.currentContact = new Contacto(0, "", "", "", this.idTercero);
    }
}