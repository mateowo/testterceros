import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CourseComponent} from './course/course.component';
import {SectionComponent} from './section/section.component';
import {StudentComponent} from './student/student.component';
import {CourseListComponent} from './course/course-list.component';
import {StudentEditComponent} from './student/student-edit.component';
import {StudentListComponent} from './student/student-list.component';
import {EncabezadoComponent} from './terceros/encabezado.component';
import {LaPantallaUno} from './PANTALLA_1/pant_1.component';
import {ContactoListComponent} from './contacto/contacto-list.component';

const routes: Routes = [
    {path: 'course/view/:id', component: CourseComponent},
    {path: 'course/list', component: CourseListComponent},
    {path: 'section/view/:id', component: SectionComponent},
    {path: 'student/view/:id', component: StudentComponent},
    {path: 'student/edit/:id', component: StudentEditComponent},
    {path: 'student/create', component: StudentEditComponent},
    {path: 'student/list', component: StudentListComponent},
    {path: 'terceros/encabezado', component: EncabezadoComponent},
    {path: 'PANTALLA_1/propiedades/:id', component: LaPantallaUno},
    {path: 'contacto/list/:id', component: ContactoListComponent},
    {path: '', redirectTo: '/terceros/encabezado', pathMatch: 'full'}
    
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class UniversityAppRoutingModule {}