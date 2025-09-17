import { Component } from '@angular/core';

@Component({
  selector: 'app-claim-approval',
  imports: [],
  templateUrl: './claim-approval.html',
  styleUrl: './claim-approval.css'
})

type Claim = {
  claimId: string;           // UUID as string
  policyId: string;          // UUID as string
  openDate: string;          // ISO 8601 format (e.g., "2025-09-16T18:03:00")
  procedureNotes: string;
  claimType: string;
  status: string;
  claimAmount: number;       // Assuming it's a long integer
};

export class ClaimApproval {

   


}
