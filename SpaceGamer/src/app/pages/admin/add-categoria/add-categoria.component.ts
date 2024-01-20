import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { CategoriaService } from 'src/app/services/categoria.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-categoria',
  templateUrl: './add-categoria.component.html',
  styleUrls: ['./add-categoria.component.css']
})
export class AddCategoriaComponent implements OnInit {

  categoria = {
    titulo: '',
    descripcion: '',
    imagen: ''
  };

  constructor(private categoriaService: CategoriaService, private snack: MatSnackBar, private router: Router) { }

  ngOnInit(): void {
  }

  formSubmit() {
    if (this.categoria.titulo.trim() == '' || this.categoria.titulo == null) {
      this.snack.open("El título es requerido !!", '', {
        duration: 3000
      });
      return;
    }

    if (this.categoria.imagen.trim() == '' || this.categoria.imagen == null) {
      this.snack.open("La URL de la imagen es requerida !!", '', {
        duration: 3000
      });
      return;
    }

    this.categoriaService.agregarCategoria(this.categoria).subscribe(
      (dato: any) => {
        this.categoria.titulo = '';
        this.categoria.descripcion = '';
        this.categoria.imagen = '';
        Swal.fire('Categoría agregada', 'El curso ha sido agregado con éxito', 'success');
        this.router.navigate(['/admin/categorias']);
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!', 'Error al guardar el curso', 'error');
      }
    );
  }
}