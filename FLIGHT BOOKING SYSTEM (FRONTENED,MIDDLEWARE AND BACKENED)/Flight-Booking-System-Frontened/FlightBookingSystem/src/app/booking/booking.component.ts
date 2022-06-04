import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookingService } from '../booking.service';
import { Ticket } from '../ticket';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  ticket: Ticket=new Ticket("","","","","","","","");
  message:any;

  constructor( private service:BookingService,private router:Router) { }

  ngOnInit() {
  }

  public bookNow(){
    let resp=this.service.doBooking(this.ticket);
    resp.subscribe((data)=>this.message=data);
    //this.snackBar.open(resp.toString(),' Successfully Added!!!',{
      //duration:5000,
      //verticalPosition:'top'
    }//)
  //}
}
