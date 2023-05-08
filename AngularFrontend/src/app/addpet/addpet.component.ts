import {Component, OnInit} from '@angular/core';
import {PetWithoutId} from '../petInterfaces';
import {PetService} from 'src/app/pet.service';
import {Router} from '@angular/router';


@Component({
  selector: 'app-addpet',
  templateUrl: './addpet.component.html',
})

export class AddpetComponent implements OnInit{
  title:string = 'Add Pet';
  error:boolean = false;
  success:boolean = false;
  name: string = '';
  code: number | null = null;
  type: string ='';
  furColour:string = '';
  country:string = '';
  petTypes: any[] = [];
  petColours: any[] = [];
  petCountries: any[] = [];
  // Create an empty AddPet object
  pets: PetWithoutId = {
    name: '',
    code: 0,
    type: '',
    furColour: '',
    country: ''
  };

  constructor(private PetService: PetService, private router: Router) {}
  ngOnInit() {
    // load the pet types, colours and countries to populate sele
    this.PetService.getPetTypesService()
      .subscribe(data => this.petTypes = data, );
    this.PetService.getPetColoursService()
      .subscribe(data => this.petColours = data, );
    this.PetService.getPetCountriesService()
      .subscribe(data => this.petCountries = data, );
  }


  onSubmit() {
    if (
      !this.name ||
      !this.code ||
      !this.type ||
      !this.furColour ||
      !this.country
    ) {
      this.error = true;
      console.log('error');
    } else {
      // bind the form values to the AddPet object
      this.pets = {
        name: this.name,
        code: this.code,
        type: this.type,
        furColour: this.furColour,
        country: this.country,
      };
      console.log(this.pets);
      // call the addPet method in the addpetService and post the AddPet object
      this.PetService.addPetService(this.pets).subscribe(() => {
        // teel user that the pet has been added
        this.success = true;
        // redirect to the petlist page after 3 seconds
        setTimeout(() => {
          this.router.navigate(['/petlist']);
        }, 3000);
      });
    }
  }
}
