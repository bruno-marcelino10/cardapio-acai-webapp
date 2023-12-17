import { NgModule } from '@angular/core';
import { Routes, RouterModule} from '@angular/router';

import { ContatoComponent } from './contato/contato.component';
import { UnidadesComponent } from './unidades/unidades.component';
import { ProdutosComponent } from './produtos/produtos.component';
import { LoginComponent } from './login/login.component';

export const routes: Routes = [
  {
    path: "",
    redirectTo: "/produtos",
    pathMatch: "full"
  },{  
    path: "contato",
    component: ContatoComponent,
  },{  
    path: "unidades",
    component: UnidadesComponent,
  },{
    path: "produtos",
    component: ProdutosComponent,  
  },{
    path: "login",
    component: LoginComponent,
  } 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
