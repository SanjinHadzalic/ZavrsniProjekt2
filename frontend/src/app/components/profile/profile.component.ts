import { Component, OnInit } from '@angular/core';
import { Application, response } from 'express';
import { ApplicationUser } from '../../interfaces/application-user';
import { JwtDecoderService } from '../../services/jwt-decoder.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css',
})
export class ProfileComponent implements OnInit {
  user: ApplicationUser | null = null;

  constructor(private jwtDecoderService: JwtDecoderService) {}

  ngOnInit(): void {


    const accessToken = localStorage.getItem('accessToken');
    if (accessToken) {
      this.user = this.getUserFromToken(accessToken);
    }
  }

  private getUserFromToken(token: string): ApplicationUser | null {
    const decodedToken = this.jwtDecoderService.decodeToken(token);
    if (decodedToken) {
      return {
        id: 0,
        username: decodedToken.sub,
        firstname: decodedToken.firstname,
        lastname: decodedToken.lastname,
        email: decodedToken.email,
        password: '',
        roles: decodedToken.roles
      };
    }
    return null;
  }
}
