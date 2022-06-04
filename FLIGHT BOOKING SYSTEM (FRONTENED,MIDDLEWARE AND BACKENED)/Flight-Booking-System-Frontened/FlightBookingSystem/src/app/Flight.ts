export class Flight{

    flight_number: string;
    flight_name: string;
    traveling_from:string;
    traveling_to:string;
    flight_fare_in_rupees:any;
    departure_time:string;
    arrival_time:string;
    distance_in_km:any;
    number_of_available_seats:any;
    date_of_travel:string;  
constructor(
    flight_number: string,
    flight_name: string,
    traveling_from:string,
    traveling_to:string,
    flight_fare_in_rupees:any,
    departure_time:string,
    arrival_time:string,
    distance_in_km:any,
    number_of_available_seats:any,
    date_of_travel:string,
){
    this.flight_number=flight_number;
    this.flight_name=flight_name;
    this.traveling_from=traveling_from;
    this.traveling_to=traveling_to;
    this.flight_fare_in_rupees=flight_fare_in_rupees
    this.departure_time=departure_time;
    this.arrival_time=arrival_time;
    this.distance_in_km=distance_in_km;
    this.number_of_available_seats=number_of_available_seats;
    this.date_of_travel=date_of_travel;
}

}