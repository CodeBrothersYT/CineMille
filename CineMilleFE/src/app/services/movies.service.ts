import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {MovieDTO} from "../classes/movie-dto";

@Injectable({
  providedIn: 'root'
})
export class MoviesService {

  private baseURL = "/api/v1/movies"
  constructor(private httpClient: HttpClient) { }

  getHistory(): Observable<MovieDTO[]>{
    return this.httpClient.get<MovieDTO[]>(`${this.baseURL}/history`)
  }

  getAvailable(): Observable<MovieDTO[]>{
    return this.httpClient.get<MovieDTO[]>(`${this.baseURL}`)
  }
}
