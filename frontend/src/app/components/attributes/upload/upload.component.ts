import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-upload',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './upload.component.html',
  styleUrl: './upload.component.css'
})
export class UploadExcelComponent {
  uploadForm: FormGroup;
  message: string = '';

  constructor(private fb: FormBuilder, private http: HttpClient) {
    this.uploadForm = this.fb.group({
      file: [null]
    });
  }

  onFileChange(event: any) {
    const file = event.target.files[0];
    this.uploadForm.patchValue({
      file: file
    });
  }

  onSubmit() {
    const formData = new FormData();
    formData.append('file', this.uploadForm.get('file')?.value);

    this.http.post('http://localhost:8080/generate/upload', formData, { responseType: 'text' })
      .subscribe(response => {
        this.message = response;
      }, error => {
        this.message = 'Error uploading file';
      });
  }
}