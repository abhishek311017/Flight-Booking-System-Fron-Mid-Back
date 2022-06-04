import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PassengerregistrationComponent } from './passengerregistration.component';

describe('PassengerregistrationComponent', () => {
  let component: PassengerregistrationComponent;
  let fixture: ComponentFixture<PassengerregistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PassengerregistrationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PassengerregistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
