import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RestApiService } from './rest-api.service';
import { HttpClientModule } from '@angular/common/http';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { BookingComponent } from './booking/booking.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LogoutComponent } from './logout/logout.component';
import { PaymentComponent } from './payment/payment.component';
import { SearchComponent } from './search/search.component';
import { CheckinComponent } from './checkin/checkin.component';
import { FlightDetailsComponent } from './flight-details/flight-details.component';
import { PassangerDashboardComponent } from './passanger-dashboard/passanger-dashboard.component';
import { PassangerLoginComponent } from './passanger-login/passanger-login.component';
import { FlightRegistrationComponent } from './flight-registration/flight-registration.component';
import { PassengerregistrationComponent } from './passengerregistration/passengerregistration.component';
import { PassengerloginService } from './passengerlogin.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavComponent } from './nav/nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { PassengerDetailsComponent } from './passenger-details/passenger-details.component';
import { FlightViewComponent } from './flight-view/flight-view.component';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    AdminDashboardComponent,
    BookingComponent,
    ContactUsComponent,
    HeaderComponent,
    FooterComponent,
    LogoutComponent,
    PaymentComponent,
    SearchComponent,
    CheckinComponent,
    FlightDetailsComponent,
    PassangerDashboardComponent,
    PassangerLoginComponent,
    FlightRegistrationComponent,
    PassengerregistrationComponent,
    NavComponent,
    PassengerDetailsComponent,
    FlightViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule
  ],
  providers: [ RestApiService,PassengerloginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
