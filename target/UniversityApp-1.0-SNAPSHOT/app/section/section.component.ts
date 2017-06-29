import {Component, OnInit} from '@angular/core';
import {Course} from 'app/model/course.model';
import {Section} from 'app/model/section.model';
import {Student} from 'app/model/student.model';
import {SectionService} from 'app/service/section.service';
import {ActivatedRoute} from '@angular/router';

@Component({
    moduleId: module.id,
    selector: 'section',
    templateUrl: 'section.component.html'
})
export class SectionComponent implements OnInit {

    section: Section = new Section(0, 0)
    students: Array<Student> = [];
    errorMessage = '';

    constructor(
        private service: SectionService,
        private route: ActivatedRoute
    ) {}

    ngOnInit() {
        this.service.find(+this.route.snapshot.params['id'])
            .subscribe(
            retrievedSection => this.section = retrievedSection,
            error => this.errorMessage = error
            );
        this.service.findStudents(+this.route.snapshot.params['id'])
            .subscribe(
            retrievedStudents => this.students = retrievedStudents,
            error => this.errorMessage = error
            );
    }
}