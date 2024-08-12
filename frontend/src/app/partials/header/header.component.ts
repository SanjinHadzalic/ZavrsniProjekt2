import { Component, OnInit } from '@angular/core';
import {
  Router,
  RouterLink,
  RouterLinkActive,
  RouterOutlet,
} from '@angular/router';
import { NotificationService } from '../../services/notification.service';
import { CommonModule } from '@angular/common';
import { TranslateModule, TranslateService } from '@ngx-translate/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [
    RouterOutlet,
    RouterLink,
    RouterLinkActive,
    CommonModule,
    TranslateModule,
    FormsModule,
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css',
})
export class HeaderComponent implements OnInit {
  isDarkMode = false;
  selectedLanguage = 'hr';

  constructor(private notificationService: NotificationService, private translateService: TranslateService) {}

  ngOnInit(): void {
    const savedTheme = localStorage.getItem('theme');
    this.isDarkMode = savedTheme === 'dark';
    this.applyTheme();
  }

  toggleDarkMode(): void {
    this.isDarkMode = !this.isDarkMode;
    localStorage.setItem('theme', this.isDarkMode ? 'dark' : 'light');
    this.applyTheme();
  }

  applyTheme(): void {
    const htmlElement = document.documentElement;
    htmlElement.setAttribute(
      'data-bs-theme',
      this.isDarkMode ? 'dark' : 'light'
    );
  }

  logout(): void {
    localStorage.clear();
    this.notificationService.logoutMessageSuccess(
      'Logged out!',
      'You have been successfully logged out.'
    );
  }

  onLanguageChange() {
    this.translateService.use(this.selectedLanguage)
  }
}
