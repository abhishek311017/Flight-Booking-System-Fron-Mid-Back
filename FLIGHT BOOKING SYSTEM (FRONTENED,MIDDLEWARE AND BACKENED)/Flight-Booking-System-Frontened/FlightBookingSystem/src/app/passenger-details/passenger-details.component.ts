import { Component, OnInit } from '@angular/core';
import { PassengerDetailsService } from '../passenger-details.service';

@Component({
  selector: 'app-passenger-details',
  templateUrl: './passenger-details.component.html',
  styleUrls: ['./passenger-details.component.css']
})
export class PassengerDetailsComponent implements OnInit {

  users:any;

  constructor(private service:PassengerDetailsService) { }

  ngOnInit(){
    let resp=this.service.getUsers();
    resp.subscribe((data)=>this.users=data);

  }

}
