import {ComponentFixture, TestBed} from '@angular/core/testing';

import {PetlistComponent} from './petlist.component';

describe('PetlistComponent', () => {
  let component: PetlistComponent;
  let fixture: ComponentFixture<PetlistComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PetlistComponent]
    });
    fixture = TestBed.createComponent(PetlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
