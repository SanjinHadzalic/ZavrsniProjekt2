import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { NotificationService } from '../../services/notification.service';
import { JwtDecoderService } from '../../services/jwt-decoder.service';
import { ApplicationUser } from '../../interfaces/application-user';
import { TranslateModule } from '@ngx-translate/core';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule, TranslateModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
  providers: [AuthService],
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  loginError: string = '';
  decodedToken: any;
  user: ApplicationUser | null = null;

  constructor(
    private authService: AuthService,
    private formBuilder: FormBuilder,
    private router: Router,
    private notificationService: NotificationService,
    private jwtDecoderService: JwtDecoderService
  ) {}

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  login() {
    const username = this.loginForm.value.username;
    const password = this.loginForm.value.password;

    this.authService.login(username, password).subscribe((response) => {
      if (response.accessToken) {
        this.notificationService.authenticationMessageSuccess(
          'Logged in!',
          'Successfully logged in redirecting to home...'
        );
        const accessToken = response.accessToken;
        const jwtToken = response.token;
        localStorage.setItem('accessToken', accessToken);
        localStorage.setItem('jwtToken', jwtToken);

        this.decodedToken = this.jwtDecoderService.decodeToken(accessToken);

        localStorage.setItem('activeUser', this.decodedToken.email);

        console.log(this.decodedToken.sub);

        this.router.navigate(['/']);
      }
    });
  }

  registerUser() {
    this.router.navigate(['/register']);
  }
}
