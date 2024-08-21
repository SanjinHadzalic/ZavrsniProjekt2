import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { ApplicationUser } from '../../interfaces/application-user';
import { UserRole } from '../../interfaces/user-role';
import { AuthService } from '../../services/auth.service';
import { NotificationService } from '../../services/notification.service';
import { Router } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule, TranslateModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent implements OnInit{
  newUser!: ApplicationUser
  newRole: UserRole = {id:1, name: 'USER'}
  submitted: boolean = false;

  constructor(
    private authService: AuthService,
    private notificationService: NotificationService,
    private router: Router
  ) {}

  registerForm = new FormGroup({
    username: new FormControl('', [Validators.required]),
    firstname: new FormControl('', [Validators.required]),
    lastname: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', Validators.required)
  });

  ngOnInit(): void {
    this.newUser = {
      id: 3, // pazi!!!
      username: '',
      firstname: '',
      lastname: '',
      email: '',
      password: '',
      roles: Array.of(this.newRole)
    }
  }

  register() {
    this.submitted = true;

    if(this.registerForm.valid) {
      const formValue = this.registerForm.value

      this.newUser.username = formValue.username!;
      this.newUser.password = formValue.password!;
      this.newUser.email = formValue.email!;
      this.newUser.firstname = formValue.firstname!;
      this.newUser.lastname = formValue.lastname!;

      console.log(this.newUser)

      this.authService.register(this.newUser).subscribe({
        next: (data) => {
          this.notificationService.successNotificationRegisterWithRedirection('Registration successful', 'Now get out of here!')
        },
        error: (e) => {
          console.log('error when registering new user', e);
        }
      })
    }
  }

  return() {
    this.router.navigate(['/login'])
  }
}
