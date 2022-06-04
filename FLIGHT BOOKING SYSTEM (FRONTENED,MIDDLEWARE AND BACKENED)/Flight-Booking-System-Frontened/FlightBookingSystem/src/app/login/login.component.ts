import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestApiService } from '../rest-api.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username!: string ;
  password!:string ;
  message:any;
  constructor(private service:RestApiService,private router:Router) {
  }

  ngOnInit(): void {
  }


  doLogin(){
   let resp= this.service.login(this.username,this.password);
   resp.subscribe(data=>{
     this.message=data;
     console.log(data);
     this.router.navigateByUrl('/admin/dashboard');
     
   })
  }
}
