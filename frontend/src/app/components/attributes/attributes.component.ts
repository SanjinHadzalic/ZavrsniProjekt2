import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';

@Component({
  selector: 'app-attributes',
  standalone: true,
  imports: [CommonModule, RouterModule, TranslateModule],
  templateUrl: './attributes.component.html',
  styleUrl: './attributes.component.css'
})
export class AttributesComponent {

constructor(private router: Router){}

return(){
  this.router.navigate(['/'])
}
}
