import { Component, OnInit } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { MyserviceService } from "./service/myservice.service";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent implements OnInit {
  title = "font-app5";

  constructor(private dataService: MyserviceService) {}

  ngOnInit() {
    this.dataService.sendGetRequest().subscribe((data: string) => {
      console.log(data);
      this.title = data + "hotreloaded2";
    });
  }
}
