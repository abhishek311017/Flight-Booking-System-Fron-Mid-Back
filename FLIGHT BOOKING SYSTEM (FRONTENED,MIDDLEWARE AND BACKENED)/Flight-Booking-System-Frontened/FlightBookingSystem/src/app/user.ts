export class User{

    name:string;
    email:string;
    gender:string;
    dob:string;
    city:string;
    password:string;

    constructor(
        _name:string,
        _email:string,
        _gender:string,
        dob:string,
        city:string,
        _password:string
    ){
        this.name=_name;
        this.email=_email;
        this.gender=_gender;
        this.dob=dob;
        this.city=city;
        this.password=_password;
    }
}