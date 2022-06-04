
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookingService } from '../booking.service';
import { FlightregistrationService } from '../flightregistration.service';
import { Ticket } from '../ticket';

@Component({
  selector: 'app-flight-view',
  templateUrl: './flight-view.component.html',
  styleUrls: ['./flight-view.component.css']
})
export class FlightViewComponent implements OnInit {

  flights:any;

  ticket: Ticket=new Ticket("","","","","","","","");
  message:any;


  constructor(private service:FlightregistrationService,private router:Router ) { }

  ngOnInit(){
    let resp=this.service.getFlight();
    resp.subscribe((data)=>this.flights=data);
  }

  public bookNow(){
    this.router.navigateByUrl('/passenger/booking');
  }
  
}
