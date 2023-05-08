import {Component, OnInit} from '@angular/core';
import {Pet} from '../petInterfaces';
import {PetService} from '../pet.service';

@Component({
  selector: 'app-petlist',
  templateUrl: `./petlist.component.html`,
})
export class PetlistComponent implements OnInit {
  pets!: Pet[];
  selectedPetId!: number;
  sortColumn: string = 'name';
  sortDirection: string = 'asc';

  constructor(private PetService: PetService) {}

  ngOnInit() {
    this.getPetList();
  }

  getPetList(): void {
    this.PetService.getPetsService().subscribe((pets) => (this.pets = pets));
  };


  public sortBy: string = 'name';

  onSort(sortBy: string) {
  this.sortBy = sortBy;
}

sortPets(column: string): void {
  if (this.sortColumn === column) {
    this.sortDirection = this.sortDirection === 'asc' ? 'desc' : 'asc';
  } else {
    this.sortColumn = column;
    this.sortDirection = 'asc';
  }
}

  deletePet(id: number): void {
    this.PetService.deletePetService(id).subscribe(() => {
      // update the list of pets
      this.getPetList();
    });
  }
}
