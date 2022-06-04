import { Input } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PassengerloginService } from '../passengerlogin.service';

@Component({
  selector: 'app-passanger-login',
  templateUrl: './passanger-login.component.html',
  styleUrls: ['./passanger-login.component.css']
})
export class PassangerLoginComponent implements OnInit {
  email!: '';
  password!:'' ;
  invalidLogin = false
 // message:any;
  constructor(private service:PassengerloginService, private router:Router) { }
  @Input() error: string | null | undefined;
  ngOnInit(): void {
  }
  doLogin() {
    (this.service.authenticate(this.email, this.password).subscribe(
      data => {
        this.router.navigateByUrl('/passenger/dashboard');
        this.invalidLogin = false
      },
      error => {
        this.invalidLogin = true
        this.error = error.message;

      }
    )
    );

  }

}
