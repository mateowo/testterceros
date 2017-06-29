import {Component, OnInit} from '@angular/core';
import {StudentService} from 'app/service/student.service';
import {Student} from 'app/model/student.model';
import {ActivatedRoute} from '@angular/router';


@Component({
    moduleId: module.id,
    selector: 'student',
    templateUrl: 'student.component.html'
})
export class StudentComponent implements OnInit {
    
    student : Student = {id: 2, firstName: "Student1", lastName: "#55"};
    errorMessage="";
    
    constructor(private service: StudentService,private route: ActivatedRoute) {}
    
    ngOnInit() {
        this.service.find(+this.route.snapshot.params['id'])
            .subscribe(
                student => this.student = student,
                error => this.errorMessage = "Error: " + JSON.stringify(error)
            );

    }
    
}

