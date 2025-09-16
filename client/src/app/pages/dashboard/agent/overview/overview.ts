import { Component,Input,Inject } from '@angular/core';


@Component({
  selector: 'app-overview',
  imports: [],
  templateUrl: './overview.html',
  styleUrl: './overview.css'
})
export class Overview {
  @Input() userName!: string;

  
    
}