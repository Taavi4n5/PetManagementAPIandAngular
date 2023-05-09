import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {catchError, map, Observable, of, tap} from 'rxjs';


interface Token {
  token: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  apiUrl = 'http://localhost:8080/api';
  private token = '';

  constructor(private http: HttpClient) { }

  login(name: string, password: string): Observable<boolean> {
    const authRequest = { name, password };
    return this.http.post<Response>(`${this.apiUrl}/login`, authRequest).pipe(

      tap((response: any) => {
        // Set the JWT token and user info in local storage
        this.token = response.message;
        localStorage.setItem('currentUser', JSON.stringify({ username: name, token: this.token }));
      }),
      map((response: any) => {
        // Return true if login successful, false otherwise
        return response.status === 200;
      }),
      catchError((error: any) => {
        console.log(error);
        return of(false);
      })
    );
  }

  isLoggedIn(): boolean {
    const currentUserString = localStorage.getItem('currentUser');
    const currentUser = currentUserString ? JSON.parse(currentUserString) : null;
    return currentUser && currentUser.token && this.token === currentUser.token;
  }

  logout(): void {
    this.token = '';
    localStorage.removeItem('currentUser');
  }
}
