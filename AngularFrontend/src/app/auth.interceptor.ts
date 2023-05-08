import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const currentUser = localStorage.getItem('currentUser');
    const authToken = currentUser ? JSON.parse(currentUser).token : null;
   console.log(request.headers.set('Authorization', 'Bearer ' + authToken));
    const authReq = request.clone({
      headers: request.headers.set('Authorization', 'Bearer ' + authToken)
    });
    return next.handle(authReq);
  }
}
