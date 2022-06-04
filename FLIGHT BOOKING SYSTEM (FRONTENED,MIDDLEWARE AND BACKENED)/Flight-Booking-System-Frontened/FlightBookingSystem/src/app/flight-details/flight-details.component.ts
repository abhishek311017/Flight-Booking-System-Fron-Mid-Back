import { Component, OnInit } from '@angular/core';
import { FlightregistrationService } from '../flightregistration.service';

@Component({
  selector: 'app-flight-details',
  templateUrl: './flight-details.component.html',
  styleUrls: ['./flight-details.component.css']
})
export class FlightDetailsComponent implements OnInit {
  flights:any;
  flight_number!: string;

  constructor(private service:FlightregistrationService ) { }

  public deleteFlight(flight_number:string){
    let resp= this.service.deleteFlight(flight_number);
    resp.subscribe((data)=>this.flights=data);
  }

  public findFlightByFlight_Number(){
    let resp= this.service.getFlightByFlight_Number(this.flight_number);
    resp.subscribe((data)=>this.flights=data);
  }

  ngOnInit(){
    let resp=this.service.getFlights();
    resp.subscribe((data)=>this.flights=data);
  }
}
