import {Component, OnInit} from '@angular/core';
import {Course} from 'app/model/course.model';
import {Section} from 'app/model/section.model';
import {CourseService} from 'app/service/course.service';
import {ActivatedRoute} from '@angular/router';

@Component({
    moduleId: module.id,
    selector: 'course',
    templateUrl: 'course.component.html'
})
export class CourseComponent implements OnInit {
    course: Course = new Course(0, '', 0);
    sections: Array<Section> = [];
    errorMessage = '';

    constructor(
        private service: CourseService,
        private route: ActivatedRoute
    ) {}

    ngOnInit() {
        console.log("*** Course ***");
        this.service.find(+this.route.snapshot.params['id'])
            .subscribe(
            retrievedCourse => this.course = retrievedCourse,
            error => this.errorMessage = "Error"
            );
        this.service.findSections(+this.route.snapshot.params['id'])
            .subscribe(
            retrievedSections => this.sections = retrievedSections,
            error => this.errorMessage = "Error"
            );


        //Observable.forkJoin([ someObservable, someOtherObservable ])
        //  .subscribe(results => {
        //    let result1 = results[0];
        //    let result2 = results[1];
        //  });
    }
}

