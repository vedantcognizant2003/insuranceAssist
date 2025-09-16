import { HttpInterceptorFn } from '@angular/common/http';

export const tokenInterceptor: HttpInterceptorFn = (req, next) => {
  // debugger;
  if (req.url.includes('/api/v1/public/login')) {
    return next(req);
  }
  debugger;
  const token = localStorage.getItem('token');
  debugger;
  // const newReq = req.clone({
  //   setHeaders: {
  //     Authorization: `Bearer ${token}`
  //   }

  const newReq = req.clone({
     headers: req.headers.set('Authorization', `Bearer ${token}`),
  
  })
  debugger;
  ;
  return next(newReq) ;
};
