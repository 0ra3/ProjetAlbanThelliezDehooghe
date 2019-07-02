import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../auth/token-storage.service';
import { UserService } from '../services/user.service';
import { User } from '../models/user';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  private roles: string[];
  private authority: string;
  user : User;
  info: any;

  constructor(private tokenStorage: TokenStorageService,
              private userService: UserService) { }
              
  ngOnInit() {
    let un = this.tokenStorage.getUsername();
    if(un){
      console.log("found", un)
      this.findByUsername(un);
    }
    
    if (this.tokenStorage.getToken()) {
      this.roles = this.tokenStorage.getAuthorities();
      this.roles.every(role => {
        if (role === 'ROLE_ADMIN') {
          this.authority = 'admin';
          return false;
        } else if (role === 'ROLE_PM') {
          this.authority = 'pm';
          return false;
        }
        this.authority = 'user';
        return true;
      });
    }
  }
  
  findByUsername(username : string){
    console.log("outside");
    this.userService.findByUsername(username).subscribe(res =>{
      console.log("inside");
      console.log("current user", res)
      this.user = res;
      })
  }
}
