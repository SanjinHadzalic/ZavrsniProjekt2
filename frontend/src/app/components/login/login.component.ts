import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { NotificationService } from '../../services/notification.service';
import { JwtDecoderService } from '../../services/jwt-decoder.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
  providers: [AuthService]
})
export class LoginComponent implements OnInit{
  loginForm!: FormGroup;
  loginError: string = '';
  decodedToken: any;

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
      password: ['', Validators.required]
    })
  }

  login(){
    const username = this.loginForm.value.username;
    const password = this.loginForm.value.password;

    this.authService.login(username, password).subscribe((response) => {
      if(response.accessToken){
        this.notificationService.authentificationMessageSuccess("Logged in!", "Successfully logged in redirecting to home...")
        const jwtToken = response.accessToken
        localStorage.setItem('token', jwtToken)

        this.decodedToken = this.jwtDecoderService.decodeToken(jwtToken)
        
        console.log(this.decodedToken.sub)

        this.router.navigate(['/'])
      } 
    })
}
}
