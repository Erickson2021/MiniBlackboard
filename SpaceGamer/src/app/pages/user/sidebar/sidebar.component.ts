import { Component,OnInit} from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CategoriaService } from 'src/app/services/categoria.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-sidebar-user',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  isLoggedIn = false;
  user:any = null;
  categorias:any;

  constructor(
    public login:LoginService,
    private categoriaService:CategoriaService,
    private snack:MatSnackBar
  ) { }

  ngOnInit(): void {
    this.categoriaService.listarCategorias().subscribe(
      (data:any) => {
        this.categorias = data;
      },
      (error) => {
        this.snack.open('Error al cargar las categorías','',{
          duration:3000
        })
        console.log(error);
      }
    )
    this.isLoggedIn = this.login.isLoggedIn();
    this.user = this.login.getUser();
    this.login.loginStatusSubjec.asObservable().subscribe(
      data => {
        this.isLoggedIn = this.login.isLoggedIn();
        this.user = this.login.getUser();
      }
    )

  }

  public logout(){
    this.login.logout();
    window.location.reload();
  }


}