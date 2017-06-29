import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpModule, JsonpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {HashLocationStrategy, LocationStrategy} from '@angular/common';

import {UniversityAppComponent} from './university-app.component'
import {UniversityAppRoutingModule} from './university-app-routing';

import {StudentService} from './service/student.service';
import {CourseService} from './service/course.service';
import {SectionService} from './service/section.service';
import {CiudadService} from './service/ciudad.service';
import {TipoIdentificacionService} from './service/tipoIdentificacion.service';
import {TerceroService} from './service/tercero.service';
import {TipoTerceroService} from './service/tipotercero.service';
import {ClasificacionService} from './service/clasificacion.service';
import {ContactoService} from './service/contacto.service';

import {CourseComponent} from './course/course.component';
import {SectionComponent} from './section/section.component';
import {StudentComponent} from './student/student.component';
import {StudentListComponent} from './student/student-list.component';
import {StudentEditComponent} from './student/student-edit.component';
import {CourseListComponent} from './course/course-list.component';
import {EncabezadoComponent} from './terceros/encabezado.component';
import {LaPantallaUno} from './PANTALLA_1/pant_1.component';
import {ContactoListComponent} from './contacto/contacto-list.component';
import {ContactoFormComponent} from './contacto/contacto-form.component';


@NgModule({
    imports: [
        BrowserModule,
        HttpModule,
        JsonpModule,
        FormsModule,
        UniversityAppRoutingModule
    ],
    declarations: [
        UniversityAppComponent,
        CourseComponent,
        CourseListComponent,
        SectionComponent,
        StudentComponent,
        StudentListComponent,
        StudentEditComponent,
        EncabezadoComponent,
        LaPantallaUno,
        ContactoListComponent,
        ContactoFormComponent
    ],
    providers: [
        StudentService,
        CourseService,
        SectionService,
        CiudadService,
        TipoIdentificacionService,
        TerceroService,
        TipoTerceroService,
        ClasificacionService,
        ContactoService
    ],
    bootstrap: [UniversityAppComponent]
})
export class UniversityAppModule {}
