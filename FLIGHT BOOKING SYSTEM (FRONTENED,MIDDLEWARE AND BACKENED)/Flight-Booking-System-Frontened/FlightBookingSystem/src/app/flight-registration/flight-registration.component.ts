import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Flight } from '../Flight';
import { FlightregistrationService } from '../flightregistration.service';
@Component({
  selector: 'app-flight-registration',
  templateUrl: './flight-registration.component.html',
  styleUrls: ['./flight-registration.component.css']
})
export class FlightRegistrationComponent implements OnInit {
 flight:Flight= new Flight("","","","",0,"","",0,0,"");
 message:any;
  constructor(private service:FlightregistrationService,private router:Router) { }

  ngOnInit(): void {
  }
  public registerNow(){
    let resp=this.service.doRegistration(this.flight);
    resp.subscribe((data)=>{this.message=data;
      this.router.navigateByUrl('/admin/dashboard');});
  }

}
