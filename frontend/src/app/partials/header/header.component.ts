import { Component } from '@angular/core';
import { Router, RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { NotificationService } from '../../services/notification.service';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterOutlet, RouterLink, RouterLinkActive],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css',
})
export class HeaderComponent {
  constructor(
    private router: Router,
    private notificationService: NotificationService
  ) {}

  logout() {
    localStorage.clear(); 
    // this.router.navigate(['/login']); 
    this.notificationService.logoutMessageSuccess(
      'Logged out!',
      'You have been successfully logged out.'
    );
  }
}
