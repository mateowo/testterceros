import {Component, OnInit} from '@angular/core';
import {Course} from 'app/model/course.model';
import {Section} from 'app/model/section.model';
import {CourseService} from 'app/service/course.service';
import {ActivatedRoute} from '@angular/router';

@Component({
    moduleId: module.id,
    selector: 'course-list',
    templateUrl: 'course-list.component.html'
})
export class CourseListComponent implements OnInit {
    course: Course = new Course(0, '', 0);
    courses: Array<Section> = [];
    errorMessage = '';

    constructor(
        private service: CourseService,
        private route: ActivatedRoute
    ) {}

    ngOnInit() {
        console.log("*** Course list ***");
        this.service.findAll()
            .subscribe(
            retrievedCourses => this.courses = retrievedCourses,
            error => this.errorMessage = "Error"
            );
    }
}

