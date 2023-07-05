import {Component, OnInit} from '@angular/core';
import {MoviesService} from "../services/movies.service";
import {Observable} from "rxjs";
import {MovieDTO} from "../classes/movie-dto";
import {MenuItem} from "primeng/api";
import {Router} from "@angular/router";

@Component({
  selector: 'app-movies-history',
  templateUrl: './movies-history.component.html',
  styleUrls: ['./movies-history.component.scss']
})
export class MoviesHistoryComponent implements OnInit{

  constructor(private moviesService: MoviesService, private router: Router) {
  }
  items: MenuItem[] = [];
  movies: Observable<MovieDTO[]> = this.moviesService.getMovies()

  ngOnInit(): void {
    this.items = [
      {label: 'Home', icon: 'pi pi-fw pi-home', command: () => this.navigateToHome()}
    ]
  }

  private navigateToHome() {
    this.router.navigate(['home'])
  }
}
