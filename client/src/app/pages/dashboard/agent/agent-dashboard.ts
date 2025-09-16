import { Component } from '@angular/core';
import { Overview } from './overview/overview';

@Component({
  selector: 'app-agent',
  imports: [Overview],
  templateUrl: './agent.html',
  styleUrl: './agent.css'
})
export class AgentDashboard {
  activeTab: 'overview' | 'claim-approval' | 'claim-history' | 'claim-status-log' = 'overview';
  setTab(tab: 'overview' | 'claim-approval' | 'claim-history' | 'claim-status-log') {
    this.activeTab = tab;
  }
}
