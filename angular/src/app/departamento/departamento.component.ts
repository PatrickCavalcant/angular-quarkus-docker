import {Component, Injectable, OnInit} from '@angular/core';
import { Departamento } from '../model/Departamento';
import { DepartamentosService } from '../services/departamentos.service';
import {HttpClient, HttpErrorResponse, HttpHeaders, HttpParams} from '@angular/common/http';


@Component({
  selector: 'app-departamento',
  templateUrl: './departamento.component.html',
  styleUrls: ['./departamento.component.css']
})


@Injectable()
export class DepartamentoComponent implements OnInit {


  isloading: boolean;
  exibeModal: boolean;


  deptoList: Departamento[];



  // Headers
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }


  private body: string;
  httpClient: any;


  constructor(private srv: DepartamentosService) {

  }
  ngOnInit() {
    this.isloading = false;
    this.exibeModal = true;

    this.srv.getAllDepartamentos().subscribe(
     (res: Departamento[]) => {
      this.deptoList = res;
        this.isloading = false;
        this.exibeModal = false;
       },
       (err) => {
         alert("Erro ao recuperar")
       }

     );
  }

  create(nome, descricao) {
    this.body = JSON.parse('{' +
      '"nome":"' + nome + '",' +
      '"descricao":"' + descricao + '",' +
      '}')

    this.srv.newDepartamentos(this.body).subscribe(
      data  => { console.log('POST Request is successful ', data); },
      error  => { console.log('Error ', error); }
    );
    // window.location.reload();
  };


}
