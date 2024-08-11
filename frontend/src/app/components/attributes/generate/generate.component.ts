import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { JwtDecoderService } from '../../../services/jwt-decoder.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-generate',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './generate.component.html',
  styleUrl: './generate.component.css'
})
export class GenerateComponent {
  username: string = '';
  token: any;
  accessToken: any;
  isAdmin: boolean = false; // New property to check admin role

  constructor(private http: HttpClient, private decoderService: JwtDecoderService) {
    this.checkUserRole(); // Check user role on component initialization
  }

  checkUserRole() {
    this.accessToken = localStorage.getItem('accessToken');

    if (this.accessToken) {
      this.token = this.decoderService.decodeToken(this.accessToken);
      this.isAdmin = this.token.roles.some((role: { name: string }) => role.name === 'ADMIN'); // Check if the user has the ADMIN role
      this.username = this.token.sub; // Set username from token
    }
  }

  downloadPdf() {
    this.http.get('http://localhost:8080/generate/pdf', { responseType: 'blob' }).subscribe(blob => {
      const link = document.createElement('a');
      link.href = window.URL.createObjectURL(blob);
      link.download = 'ringed_birds_report.pdf';
      link.click();
    });
  }

  downloadPdfByUsername() {
    if (this.username.trim() === '') {
      alert('Please enter a username');
      return;
    }

    this.http.get(`http://localhost:8080/generate/pdf/${this.username}`, { responseType: 'blob' }).subscribe(blob => {
      const link = document.createElement('a');
      link.href = window.URL.createObjectURL(blob);
      link.download = `Report_${this.username}.pdf`;
      link.click();
    }, error => {
      console.error('Error downloading PDF:', error);
      alert('Failed to generate PDF for the specified username');
    });
  }

  downloadExcel() {
    this.http.get('http://localhost:8080/generate/excel', { responseType: 'blob' }).subscribe(blob => {
      const link = document.createElement('a');
      link.href = window.URL.createObjectURL(blob);
      link.download = 'RingedBirdsReport.xlsx';
      link.click();
    }, error => {
      console.error('Error downloading Excel:', error);
      alert('Failed to generate Excel report');
    });
  }

  downloadExcelByUsername() {
    if (this.username.trim() === '') {
      alert('Please enter a username');
      return;
    }

    this.http.get(`http://localhost:8080/generate/excel/${this.username}`, { responseType: 'blob' }).subscribe(blob => {
      const link = document.createElement('a');
      link.href = window.URL.createObjectURL(blob);
      link.download = `RingedBirdsReport_${this.username}.xlsx`;
      link.click();
    }, error => {
      console.error('Error downloading Excel:', error);
      alert('Failed to generate Excel report for the specified username');
    });
  }
}