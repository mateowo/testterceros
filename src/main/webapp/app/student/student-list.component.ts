import {Component, OnInit} from '@angular/core';
import {Student} from 'app/model/student.model';
import {StudentService} from 'app/service/student.service';
import {ActivatedRoute} from '@angular/router';

@Component({
    moduleId: module.id,
    selector: 'student-list',
    templateUrl: 'student-list.component.html'
})
export class StudentListComponent implements OnInit {
    student: Student = new Student(0, '', '');
    students: Array<Student> = [];
    message = '';

    constructor(
        private service: StudentService,
        private route: ActivatedRoute
    ) {}

    ngOnInit() {
        this.service.findAll()
            .subscribe(
            retrievedStudents => this.students = retrievedStudents,
            error => this.message = "Error"
            );
    }

    deleteStudent(pos: number) {
        console.log("delete student " + pos);
        this.service.remove(this.students[pos].id)
            .subscribe(
            success => this.students.splice(pos, 1), // removes student from array
            error => this.message = "Error"
            );
        this.message = 'Student deleted';
    }
}

