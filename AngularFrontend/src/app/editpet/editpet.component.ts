import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Pet} from '../petInterfaces';
import {PetService} from '../pet.service';

@Component({
  selector: 'app-editpet',
  templateUrl: './editpet.component.html',
})
export class EditpetComponent implements OnInit {
  petData!: Pet;
  error: boolean = false;
  success: boolean = false;
  name?: string = '';
  code?: number = 0;
  type?: string = '';
  furColour?: string = '';
  country?: string = '';
  petTypes: any[] = [];
  petColours: any[] = [];
  petCountries: any[] = [];

  constructor(private PetService: PetService, private route: ActivatedRoute ,private router: Router) {}

  id: number = this.route.snapshot.params['id'];
  ngOnInit() {
    this.getPetData();
    this.PetService.getPetTypesService()
      .subscribe(data => this.petTypes = data, );
    this.PetService.getPetColoursService()
      .subscribe(data => this.petColours = data, );
    this.PetService.getPetCountriesService()
      .subscribe(data => this.petCountries = data, );
  }

  getPetData(): any {
    this.PetService.getPetByIdService(this.id)
      .subscribe(pet => {
        this.petData = pet;
        this.name = this.petData.name;
        this.code = this.petData.code;
        this.type = this.petData.type;
        this.furColour = this.petData.furColour;
        this.country = this.petData.country;
      });
  }



   onSubmit() {
     if (
       !this.petData.name ||
       !this.petData.code ||
       !this.petData.type ||
       !this.petData.furColour ||
       !this.petData.country
     ) {
       this.error = true;
       console.log('error');
     } else {
       // bind the form values to the AddPet object
       this.petData = {
         id: this.id,
         name: this.name,
         code: this.code,
         type: this.type,
         furColour: this.furColour,
         country: this.country,

       };
       // call the addPet method in the addpetService and post the AddPet object
       this.PetService.editPetService(this.petData, this.id).subscribe(() => {
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
