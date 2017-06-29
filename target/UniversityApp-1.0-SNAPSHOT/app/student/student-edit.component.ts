import {Component, OnInit} from '@angular/core';
import {StudentService} from 'app/service/student.service';
import {Student} from 'app/model/student.model';
import {ActivatedRoute, Router} from '@angular/router';


@Component({
    moduleId: module.id,
    selector: 'student-edit',
    templateUrl: 'student-edit.component.html'
})
export class StudentEditComponent implements OnInit {

    student: Student = {id: undefined, firstName: "", lastName: ""};
    errorMessage = "";

    constructor(
        private service: StudentService,
        private route: ActivatedRoute,
        private router: Router
    ) {}

    ngOnInit() {
        let id = this.route.snapshot.params['id'];
        if (id) {
            this.service.find(+id)
                .subscribe(
                student => this.student = student,
                error => this.errorMessage = "Error: " + JSON.stringify(error)
                );
        }

    }

    saveStudent() {
        if (this.student.id) {
            this.service.edit(this.student)
                .subscribe(
                success => this.router.navigate(['/student/list']),
                error => this.errorMessage = 'Error: ' + error
                );
        } else {
            console.log("save " + " " + JSON.stringify(this.student));
            this.service.create(this.student)
                .subscribe(
                success => this.router.navigate(['/student/list']),
                error => this.errorMessage = 'Error: ' + error
                );
        }
    }

}

