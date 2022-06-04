import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PassengerDetailsService {

  constructor(private http:HttpClient) { }
  public getUsers(){
    return this.http.get("http://localhost:8085/Admin/findAllPassenger");
  }
}
