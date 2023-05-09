import {Component} from '@angular/core';
import {AuthService} from '../auth.service';
import {Router} from '@angular/router';
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
    this.authService.login(this.name, this.password).subscribe({
      next: (successful) => {
        if (successful) {
          // Authentication successful, navigate to petlist
          this.router.navigate(['/petlist']);
        } else {
          // Authentication failed
          this.showError = true;
          this.errorMessage = 'Authentication failed';
        }
      },
      error: (error) => {
        console.log(error);
        this.showError = true;
        this.errorMessage = 'Something went wrong, please try again later.';
      }
    });
  }
}
