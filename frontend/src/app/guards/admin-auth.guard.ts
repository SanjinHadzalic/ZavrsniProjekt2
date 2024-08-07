import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { JwtDecoderService } from '../services/jwt-decoder.service';

export const adminAuthGuard: CanActivateFn = (route, state) => {
  const router = inject(Router)
  const decoder = inject(JwtDecoderService)
  const jwtToken = localStorage.getItem('JWT')

  if(jwtToken) {
    if(decoder.decodeToken(jwtToken).sub == 'admin') {
      return true;
    } else {
      router.navigate(['/forbidden'])
      return false;
    }
  } else {
    router.navigate(['/login']);
    return false;
  }};
