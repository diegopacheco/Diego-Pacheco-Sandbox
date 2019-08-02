import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AttemptsComponent } from './attempts.component';

describe('AttemptsComponent', () => {
  let component: AttemptsComponent;
  let fixture: ComponentFixture<AttemptsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AttemptsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AttemptsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
