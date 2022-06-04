import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class PassangerregistrationService {

  constructor(private http:HttpClient ) { }

  public doRegistration(user: User){
    return this.http.post("http://localhost:8081/Passenger/create",user,{responseType:'text' as 'json'});
  }}
