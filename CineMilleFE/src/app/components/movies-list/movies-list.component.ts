import {Component, Input} from '@angular/core';
import {MovieDTO} from "../../classes/movie-dto";

@Component({
  selector: 'app-movies-list',
  templateUrl: './movies-list.component.html',
  styleUrls: ['./movies-list.component.scss']
})
export class MoviesListComponent{
  @Input() movies: MovieDTO[] | null = [];
}
