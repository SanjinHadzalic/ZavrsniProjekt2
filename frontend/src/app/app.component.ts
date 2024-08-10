import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { NavigationEnd, Router, RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { HeaderComponent } from './partials/header/header.component';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { filter } from 'rxjs/operators';
import { FooterComponent } from './partials/footer/footer.component';
import { LeafletModule } from '@asymmetrik/ngx-leaflet';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule, HeaderComponent, RouterLink, RouterLinkActive, FooterComponent, LeafletModule,
     
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';

  showFooter: boolean = false;

  constructor(private router: Router) {
    this.router.events
      .pipe(filter(event => event instanceof NavigationEnd)) // Filter for NavigationEnd events
      .subscribe((event) => {
        if (event instanceof NavigationEnd) {
          // Define the routes where the footer should be displayed
          const routesWithFooter = ['/', '/login', '/register', '/profile'];
          this.showFooter = routesWithFooter.includes(event.urlAfterRedirects);
        }
      });
  }}
