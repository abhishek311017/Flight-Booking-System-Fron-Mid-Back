export class Ticket{

    name:string;
    dob:string;
    gender:string;
    city:string;
    flight_number:string;
    traveling_from:string;
    traveling_to:string;
    date_of_travel:string;
    
constructor(
    _name:string,
    _dob:string,
    _gender:string,
    _city:string,
    _flight_number:string,
    _traveling_from:string,
    _traveling_to:string,
    _date_of_travel:string

){
    this.name=_name;
    this.dob=_dob;
    this.gender=_gender;
    this.city=_city
    this.flight_number=_flight_number;
    this.traveling_from=_flight_number;
    this.traveling_to=_traveling_to;
    this.date_of_travel=_date_of_travel;
}

}