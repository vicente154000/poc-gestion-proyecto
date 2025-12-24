import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TokenService } from '../../services/token.service';

@Component({
  selector: 'app-authorized',
  templateUrl: './authorized.component.html',
  styleUrl: './authorized.component.scss'
})
export class AuthorizedComponent implements OnInit {

  code = '';


  constructor(
    private activatedRoute: ActivatedRoute,
    private authService: AuthService,
    private tokenService: TokenService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(data => {
      this.code = data["code"];
      const codeVerifier = this.tokenService.getVerifier();
      this.tokenService.deleteVerifier();
      this.getToken(this.code, codeVerifier);
    });
  }

  getToken(code: string, codeVerifier: string): void {
    this.authService.getToken(code, codeVerifier).subscribe(
      data => {
        this.tokenService.setTokens(data.access_token, data.refresh_token);
        this.router.navigate(['']);
      },
      err => {
        console.log(err);
      })
  }

}
