import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Ticket } from './ticket';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  constructor(private http:HttpClient) { }

  public doBooking(ticket: Ticket){
    return this.http.post("http://localhost:8081/Passenger/addbooking",ticket,{responseType:'text' as 'json'});
  }}
