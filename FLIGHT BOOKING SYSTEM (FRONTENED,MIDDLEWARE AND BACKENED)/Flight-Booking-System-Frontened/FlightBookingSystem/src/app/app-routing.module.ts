import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { BookingComponent } from './booking/booking.component';
import { CheckinComponent } from './checkin/checkin.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { FlightDetailsComponent } from './flight-details/flight-details.component';
import { FlightRegistrationComponent } from './flight-registration/flight-registration.component';
import { FlightViewComponent } from './flight-view/flight-view.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { PassangerDashboardComponent } from './passanger-dashboard/passanger-dashboard.component';
import { PassangerLoginComponent } from './passanger-login/passanger-login.component';
import { PassengerDetailsComponent } from './passenger-details/passenger-details.component';
import { PassengerregistrationComponent } from './passengerregistration/passengerregistration.component';
import { PaymentComponent } from './payment/payment.component';
import { SearchComponent } from './search/search.component';

const routes: Routes = [
  {path:"flight/add",component:FlightRegistrationComponent},
  {path:"admin/login",component:LoginComponent},
  {path:"admin/dashboard",component:AdminDashboardComponent},
  {path:"passenger/login",component:PassangerLoginComponent},
  {path:"passenger/dashboard",component:PassangerDashboardComponent},
  {path:"passenger/registration",component:PassengerregistrationComponent},
  {path:"passenger/list",component:PassengerDetailsComponent},
  {path:"logout",component:LogoutComponent},
  {path:"flight/search",component:SearchComponent},
  {path:"header",component:HeaderComponent},
  {path:"footer",component:FooterComponent},
  {path:"contactus",component:ContactUsComponent},
  {path:"checkin",component:CheckinComponent},
  {path:"passenger/booking",component:BookingComponent},
  {path:"payment",component:PaymentComponent},
  {path:"flight/check",component:FlightDetailsComponent},
  {path:"flight/list", component:FlightViewComponent},
  {path:"",redirectTo:"home",pathMatch:"full"},
  {path:"home",component:HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
