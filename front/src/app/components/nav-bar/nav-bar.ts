import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-nav-bar',
  imports: [CommonModule, RouterLink],
  templateUrl: './nav-bar.html',
  styleUrl: './nav-bar.scss',
})
export class NavBar {
  userName: string = 'Pedro Spíndola';
  valorCaixa: number = 0;

  logout() {
    console.log('Usuário saiu do sistema');
  }
}
