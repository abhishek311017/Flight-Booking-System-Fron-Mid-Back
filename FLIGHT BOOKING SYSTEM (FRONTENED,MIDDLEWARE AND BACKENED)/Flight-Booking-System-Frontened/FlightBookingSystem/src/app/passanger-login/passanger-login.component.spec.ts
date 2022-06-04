import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PassangerLoginComponent } from './passanger-login.component';

describe('PassangerLoginComponent', () => {
  let component: PassangerLoginComponent;
  let fixture: ComponentFixture<PassangerLoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PassangerLoginComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PassangerLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
