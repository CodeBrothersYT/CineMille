import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {MovieDTO} from "../classes/movie-dto";

@Injectable({
  providedIn: 'root'
})
export class MoviesService {

  private baseURL = "http://localhost:8080/api/v1/movies"
  constructor(private httpClient: HttpClient) { }

  getMovies(): Observable<MovieDTO[]>{
    return this.httpClient.get<MovieDTO[]>(`${this.baseURL}`)
  }

  createMovie(movieDTO: MovieDTO): Observable<MovieDTO>{
    return this.httpClient.post<MovieDTO>(`${this.baseURL}`, movieDTO)
  }
}
