import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import Swal from "sweetalert2";

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(private router: Router) { }

  successNotification(title: string, message: string) {
    Swal.fire(title, message, 'success')
  }

  errorNotification(title: string, message: string){
    Swal.fire(title, message, 'error')
  }

  warningNotification(title: string, message: string) {
    Swal.fire({
      icon: 'warning',
      title: title,
      text: message
    })
  }

  authenticationMessageSuccess(title: string, text: string){
    Swal.fire({
      title: title,
      text: text,
      icon: 'success',
      timer: 2000,
      timerProgressBar: true,
      showConfirmButton: false
    }).then(()=>{
      this.router.navigate(['/'])
    })
  }

  logoutMessageSuccess(title: string, text: string) {
    Swal.fire({
      title: title,
      text: text,
      icon: 'success',
      timer: 2000,
      timerProgressBar: true,
      showConfirmButton: false
    }).then(()=>{
      this.router.navigate(['/login']);
    })
  }

  successNotificationRegisterWithRedirection(title: string, message: string) {
    Swal.fire({
      title: title,
      text: message + ' redirecting to login...',
      icon: 'success',
      timer: 2000,
      timerProgressBar: true,
      showConfirmButton: false
    }).then(()=> {
      this.router.navigate(['/login'])
    })
  }
}
