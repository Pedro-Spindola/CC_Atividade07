import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../../services/auth-service';

@Component({
  selector: 'app-login',
  imports: [CommonModule, FormsModule],
  templateUrl: './login.page.html',
  styleUrl: './login.page.scss'
})
export class LoginPage {
  username: string = '';
  password: string = '';
  errorMessage: string = '';

  constructor(private authService: LoginService, private router: Router) {}

  login() {
    if (!this.username || !this.password) {
      this.errorMessage = 'Por favor, preencha todos os campos...';
      return;
    }
  
    const dadosLogin = {
      username: this.username,
      password: this.password,
    };
    
    console.log('Enviando login:', dadosLogin);
  
    this.authService.login({ username: this.username, password: this.password })
      .subscribe({
        next: (res) => {
          console.log('Resposta do backend:', res);
          if (res.success) {
            console.log('Login bem-sucedido');
            this.errorMessage = '';
            this.router.navigate(['']);
          } else {
            console.log('Login falhou');
            this.errorMessage = 'Usuário ou senha inválidos';
          }
        },
        error: (err) => {
          console.error('Erro na requisição:', err);
          this.errorMessage = 'Erro ao tentar fazer login. Tente novamente.';
        }
      });
  }
}
