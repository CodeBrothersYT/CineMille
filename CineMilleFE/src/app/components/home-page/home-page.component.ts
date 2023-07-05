import {Component, OnInit} from '@angular/core';
import {MovieDTO} from "../../classes/movie-dto";
import {MoviesService} from "../../services/movies.service";
import {Observable} from "rxjs";
import {MenuItem} from "primeng/api";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit{

  items: MenuItem[] = [];
  constructor(private moviesService: MoviesService, private router: Router) {
  }

  movies: Observable<MovieDTO[]> = this.moviesService.getMovies()

  ngOnInit(): void {
    this.items = [
      {label: 'Movies History', icon: 'pi pi-fw pi-history', command: () => this.navigateToMoviesHistory()}
    ]
  }

  private navigateToMoviesHistory() {
    this.router.navigate(['movies-history'])
  }
}
