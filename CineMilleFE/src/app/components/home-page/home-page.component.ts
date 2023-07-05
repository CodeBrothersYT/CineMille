import { Component } from '@angular/core';
import {MovieDTO} from "../../classes/movie-dto";
import {MoviesService} from "../../services/movies.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent {

  constructor(private moviesService: MoviesService) {
  }

  movies: Observable<MovieDTO[]> = this.moviesService.getMovies()

}
