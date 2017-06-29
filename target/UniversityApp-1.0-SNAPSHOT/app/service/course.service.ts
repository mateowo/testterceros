import {Http, Response} from '@angular/http';
import {Location} from '@angular/common';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import {RestClient} from './rest-client';
import {Course} from 'app/model/course.model';

@Injectable()
export class CourseService extends RestClient<Course> {
    baseURL = "http://localhost:8080/UniversityApp/webresources/course/";

    constructor(http: Http) {
        super(http);
    }

    findSections(courseId: number) {
        let url = this.baseURL + courseId + '/sections';
        return this.http.get(url)
            .map((res: Response) => res.json());
    }
}


