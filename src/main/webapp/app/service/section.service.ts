import {Http, Response} from '@angular/http';
import {Injectable} from '@angular/core';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import {RestClient} from './rest-client';
import {Section} from 'app/model/section.model';

@Injectable()
export class SectionService extends RestClient<Section> {
    baseURL = "http://localhost:8080/UniversityApp/webresources/section/";

    constructor(http: Http) {
        super(http);
    }

    findStudents(sectionId: number) {
        let url = this.baseURL + sectionId + '/students';
        return this.http.get(url)
            .map((res: Response) => res.json());
    }
}


