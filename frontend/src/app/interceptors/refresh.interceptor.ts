import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';

import { catchError, switchMap } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { HttpRequest, HttpHandler, HttpEvent, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from '../services/auth.service';

export const refreshInterceptor: HttpInterceptorFn = (req, next) => {
  const authService = inject(AuthService);
  const jwtToken = localStorage.getItem('token');

  if (jwtToken) {
    const authReq = req.clone({
      headers: req.headers.set('Authorization', `Bearer ${jwtToken}`)
    });

    return next(authReq).pipe(
      catchError((error: HttpErrorResponse) => {
        if (error.status === 401 || error.status === 403) {
          // Token might be expired, try to refresh it
          return authService.refreshToken().pipe(
            switchMap((tokenResponse: any) => {
              localStorage.setItem('accessToken', tokenResponse.tokens.accessToken);
              const newAuthReq = req.clone({
                headers: req.headers.set('Authorization', `Bearer ${tokenResponse.tokens.accessToken}`)
              });
              return next(newAuthReq);
            }),
            catchError(refreshError => {
              console.error('Error refreshing token', refreshError);
              authService.logout();
              return throwError(() => new Error('Token refresh failed!'));
            })
          );
        } else {
          return throwError(() => error);
        }
      })
    );
  }

  return next(req);
};
