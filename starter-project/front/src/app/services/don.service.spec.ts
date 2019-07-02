import { TestBed, inject } from '@angular/core/testing';

import { donService } from './don.service';

describe('Service', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [donService]
    });
  });

  it('should be created', inject([donService], (service: donService) => {
    expect(service).toBeTruthy();
  }));
});
