import { Component } from '@angular/core';
import { FormArray, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-client-register-dependents',
  imports: [],
  templateUrl: './client-register-dependents.html',
  styleUrl: './client-register-dependents.css'
})
export class ClientRegisterDependents {
  registerDependentForm;
  constructor(private fb: FormBuilder, private router: Router) {
    this.registerDependentForm= this.fb.group({
    dependents: this.fb.array([])
    });
  } 

  get dependents() {
    return this.registerDependentForm.get('dependents') as FormArray;
  }

  addDependent() {
    this.dependents.push(this.fb.group({
      name: ['', Validators.required],
      dob: ['', Validators.required],
      contact: ['', [Validators.required, Validators.pattern('^[0-9]{10}$')]],
      address: ['', Validators.required],
      relationshipTypeId: ['', Validators.required],
      gender: ['', Validators.required]
    }));
  }
}
