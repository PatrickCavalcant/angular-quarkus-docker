import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DepartamentosService {

  url = 'http://localhost:8080/departamentos';

  constructor(private http: HttpClient) { }

  getAllDepartamentos(){ return this.http.get("http://localhost:8080/departamentos");}

  newDepartamentos(body){return this.http.post("http://localhost:8080/departamentos/criar", body)}

  deleteUser(id) { return this.http.delete(this.url + '/' + id) }

}

