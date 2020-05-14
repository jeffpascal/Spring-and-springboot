import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: "root"
})
export class MyserviceService {
  constructor(private httpClient: HttpClient) {}
  private REST_API_SERVER = "http://localhost:8080/time";

  public sendGetRequest() {
    return this.httpClient.get(this.REST_API_SERVER);
  }
}
