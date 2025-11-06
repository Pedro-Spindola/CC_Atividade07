import { Routes } from '@angular/router';
import { LoginPage } from './pages/login/login.page';
import { HomePage } from './pages/home/home.page';
import { ProdutoPage } from './pages/produto/produto.page';
import { GerenciarProdutoPage } from './components/gerenciar-produto/gerenciar-produto.page';

export const routes: Routes = [
    { path: '', component: LoginPage},
    { path: 'login', component: LoginPage},
    { path: 'home', component: HomePage},
    { path: 'produto', component: ProdutoPage},
    { path: 'gerenciarProduto', component: GerenciarProdutoPage}
];
