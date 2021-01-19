import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {BlockchainConfig} from '../model/blockchain-config';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  private blockChainConfig: BlockchainConfig;

  constructor(private http: HttpClient) {
  }

  public init(): Promise<void> {
    return this.getBlockChainConfig()
      .toPromise()
      .then(config => {
        this.blockChainConfig = config;
        console.log('Blockchain config', config);
      });
  }

  public getBlockChainConfig(): Observable<BlockchainConfig> {
    return this.http.get<BlockchainConfig>(environment.dataFilterAddress + '/config/blockchain');
  }
}
