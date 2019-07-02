import { Component, OnInit } from '@angular/core';

import { TokenStorageService } from '../auth/token-storage.service';
import { UserService } from '../services/user.service';
import { User } from '../models/user';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  info: any;
  user: User;

  constructor(private token: TokenStorageService,
              private us :UserService,
              private tokenStorage : TokenStorageService) { }

  ngOnInit() {

    this.info = {
      token: this.token.getToken(),
      username: this.token.getUsername(),
      authorities: this.token.getAuthorities()
      
    };

    let un = this.tokenStorage.getUsername();
    if(un){
      console.log("trouvé", un)
      this.findByUsername(un);
      console.log("trouvé", un)



    /*console.log("1", this.info.user);
    console.log("2", this.token.getUsername());
    this.us.findByUsername(this.token.getUsername()).subscribe( res =>{
      console.log("test user", res);
    }); */
    }
  }

  logout() {
    this.token.signOut();
    window.location.reload();
  }

  findByUsername(username : string){
    this.us.findByUsername(username).subscribe(res =>{
      this.user = res;
      });
  }
}
