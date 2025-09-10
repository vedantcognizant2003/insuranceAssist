import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { environment } from '../../../../environments/environment.development';
import { ClientOverview } from "./overview/client-overview/client-overview";
import { CommonModule } from '@angular/common';
import { ClientNewClaim } from './new-claim/client-new-claim/client-new-claim';
import { ClientClaimHistory } from './claim-history/client-claim-history/client-claim-history';
import { NetworkHospitals } from './network-hospitals/network-hospitals/network-hospitals';

@Component({
  selector: 'app-client-dashboard',
  imports: [CommonModule, ClientOverview, ClientNewClaim, ClientClaimHistory, NetworkHospitals],
  templateUrl: './client.html',
  styleUrl: './client.css'
})
export class ClientDashboard {

  http = inject(HttpClient);
  
  activeTab: 'overview' | 'new-claim' | 'history' | 'hospitals' = 'overview';

  setTab(tab: 'overview' | 'new-claim' | 'history' | 'hospitals') {
    this.activeTab = tab;
  }
}
