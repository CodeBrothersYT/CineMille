import {Component, Input, OnInit} from '@angular/core';
import {MovieDTO} from "../../classes/movie-dto";
import {Router} from "@angular/router";
import {MoviesService} from "../../services/movies.service";
import {tap} from "rxjs";

@Component({
  selector: 'app-movies-list',
  templateUrl: './movies-list.component.html',
  styleUrls: ['./movies-list.component.scss']
})
export class MoviesListComponent{
  @Input() history: boolean = false;
  @Input() movies: MovieDTO[] | null = [];
}
