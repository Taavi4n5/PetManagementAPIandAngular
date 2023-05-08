import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Pet, PetWithoutId} from './petInterfaces';

@Injectable({
  providedIn: 'root',
})
export class PetService {
  private apiUrl = 'http://localhost:8080/api';


  constructor(private http: HttpClient) {}

  getPetsService(): Observable<Pet[]> {
    return this.http.get<Pet[]>(`http://localhost:8080/api/pets`);
  }

  getPetByIdService(id: number): Observable<Pet> {
    return this.http.get<Pet>(`${this.apiUrl}/pets/${id}`);
  }

  addPetService(pet: PetWithoutId): Observable<PetWithoutId> {
    return this.http.post<PetWithoutId>(`${this.apiUrl}/pets`, pet);
  }

  editPetService(pet: Pet, id: number): Observable<Pet> {
    return this.http.put<Pet>(`${this.apiUrl}/pets/${id}`, pet,);
  }

  deletePetService(id: number): Observable<Pet> {
    return this.http.delete<Pet>(`${this.apiUrl}/pets/${id}`);
  }

  getPetTypesService() {
    return this.http.get<any[]>(`${this.apiUrl}/pets/pet-types`);
  }

  getPetColoursService() {
    return this.http.get<any[]>(`${this.apiUrl}/pets/pet-colours`);
  }

  getPetCountriesService() {
    return this.http.get<any[]>(`${this.apiUrl}/pets/pet-countries`);
  }
}
