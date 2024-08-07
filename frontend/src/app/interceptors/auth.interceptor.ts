import { HttpInterceptorFn } from '@angular/common/http';
import { Token } from '@angular/compiler';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  const jwtToken = localStorage.getItem('accessToken')

  if(jwtToken) {
    try{
      const authReq = req.clone({
        headers: req.headers.set('Authorization', `Bearer ${jwtToken}`)
      });
      return next(authReq);
    } catch(error) {
      console.error('Error in JWT Interceptor!', error);
    }
  } 
  
  return next(req);
};
