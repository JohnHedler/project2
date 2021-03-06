import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  model: any = {};
  sessionId: any = "";
  model2: any = {};

  constructor(
    private router: Router,
    private http: HttpClient,
    private titleService: Title
  ) { }

  ngOnInit(): void {
    this.titleService.setTitle('Login');
  }

  loginHtml() {
    let url = 'api/login';
    this.http.post<any>(url, {
      username: this.model.username,
      password: this.model.password
    }).subscribe(res => {
        if (res) {
        let session = res;
        this.sessionId = session.session_id;
        this.model2 = session.sessionUser;

        sessionStorage.setItem(
          'token',
          this.sessionId
        );

        localStorage.setItem('userId', this.model2.userId);
        localStorage.setItem('user-username', this.model2.username);
        localStorage.setItem('user-password', this.model2.password);
        localStorage.setItem('user-role', this.model2.role.role_name);
        localStorage.setItem('user-email', this.model2.email);
        localStorage.setItem('user-availability', this.model2.timeAvailable);

        // if(this.model2.role.role_name == 'MENTOR') {
        //   let url = 'api/techstacks/user/' + this.model2.userId;
        //   this.http.get<any>(url, {}).subscribe(res => {
        //     localStorage.setItem('techStackArray', res);
        //     let techStackArray:any = res;
        //     for(let x = 0; x < techStackArray.length; x++) {
        //       console.log(techStackArray[x]);
        //     }
        //   })
        // }

        sessionStorage.setItem(
          'username',
          this.model.username
        );
        this.router.navigate(['']);
      } else {
        alert("Authentication failed.");
      }
   }, err => {
      if (err) {
        let errorElement:any = document.getElementById('errorMsg');
        errorElement.innerHTML = "Invalid Username and Password";
      }
    });
  }
}