import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import{Flight} from './Flight';
@Injectable({
  providedIn: 'root'
})
export class FlightregistrationService {

  constructor(private http:HttpClient) { }

  public doRegistration(flight:Flight){
    return this.http.post("http://localhost:8085/Admin/addFlight",flight,{responseType:'text' as 'json'});
  }

  public getFlights(){
    return this.http.get("http://localhost:8085/Admin/findAllFlight");
  }
  public getFlight(){
    return this.http.get("http://localhost:8081/Passenger/findAllFlight");
  }

  public getFlightByFlight_Number(flight_number: string){
    return this.http.get("http://localhost:8085/Admin/findAllTrain/"+flight_number);
  }

  public deleteFlight(flight_number: string){
    return this.http.delete("http://localhost:8085/Admin/delete/"+flight_number);
  }
}
