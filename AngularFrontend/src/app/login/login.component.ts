import {Component} from '@angular/core';
import {AuthService} from '../auth.service';
import {Router} from '@angular/router';
import {catchError, EMPTY, switchMap, tap,} from 'rxjs';
import {User} from '../userInterfaces';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
})
export class LoginComponent {
  name = '';
  password = '';
  showError = false;
  errorMessage = '';
  user: User = {
    name: '',
    password: ''
  };

  constructor(private authService: AuthService, private router: Router) { }

  onSubmit(): void {
    this.authService.login(this.name, this.password).pipe(
      switchMap((response) => {
        if (response.status === 200) {
          const user = { name: this.name, password: this.password };
          return this.authService.authenticate(user).pipe(
            tap(() => {
              // Authentication successful, navigate to petlist
              this.router.navigate(['/petlist']);
            }),
            catchError((error) => {
              // Authentication failed
              console.log(error);
              this.showError = true;
              this.errorMessage = 'Authentication failed';
              return EMPTY;
            })
          );
        } else {
          // Authentication failed
          this.showError = true;
          this.errorMessage = 'Authentication failed';
          return EMPTY;
        }
      }),
      catchError((error) => {
        console.log(error);
        this.showError = true;
        this.errorMessage = 'Something went wrong, please try again later.';
        return EMPTY;
      })
    ).subscribe();
  }
}
