import {Http, Response} from '@angular/http';
import {Injectable} from '@angular/core';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import {RestClient} from './rest-client';
import {Student} from 'app/model/student.model';

@Injectable()
export class StudentService extends RestClient<Student> {
    baseURL = "http://localhost:8080/UniversityApp/webresources/student/";

    constructor(http: Http) {
        super(http);
    }

}


