import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjetManagementComponent } from './projet-management.component';

describe('ProjetManagementComponent', () => {
  let component: ProjetManagementComponent;
  let fixture: ComponentFixture<ProjetManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjetManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjetManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
