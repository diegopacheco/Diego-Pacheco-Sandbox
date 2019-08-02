import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-attempts',
  templateUrl: './attempts.component.html',
  styleUrls: ['./attempts.component.scss']
})
export class AttemptsComponent implements OnInit {

  public fullLife  = 'assets/empty_hearth.png';
  public emptyLife = 'assets/full_hearth.png';

  constructor() { }

  ngOnInit() {
  }

}
