import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PassangerregistrationService } from '../passangerregistration.service';
import { User } from '../user';

@Component({
  selector: 'app-passengerregistration',
  templateUrl: './passengerregistration.component.html',
  styleUrls: ['./passengerregistration.component.css']
})
export class PassengerregistrationComponent implements OnInit {

  user: User=new User("","","","","","");
  message:any;

  constructor( private service:PassangerregistrationService,private router:Router) { }

  ngOnInit() {
  }

  public userRegister(){
    let resp=this.service.doRegistration(this.user);
    resp.subscribe((data)=>this.message=data);
    this.router.navigateByUrl('/passenger/login');

  }
}
