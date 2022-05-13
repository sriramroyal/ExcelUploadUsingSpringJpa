package com.example.engagementKpi.Controller;

import com.example.engagementKpi.Entity.*;
import com.example.engagementKpi.Helper.GovernanceKpiHelper;
import com.example.engagementKpi.Helper.KpiHelper;
import com.example.engagementKpi.Service.KpiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class KpiController {

    @Autowired
    KpiService kpiService;


    @PostMapping("/fileUploadKpi")
    public ResponseEntity<?> uploadKpi(@RequestParam("file") MultipartFile file)throws IOException {

        if (KpiHelper.CheckFile(file)){

            this.kpiService.saveKpi(file);

            return ResponseEntity.ok(Map.of("Message","The given file is Excel"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Upload Excel File only!!");
    }

    @PostMapping("/fileUploadInnovationKpi")
    public ResponseEntity<?> uploadInnovationKpi(@RequestParam("file") MultipartFile file)throws IOException {
        if (KpiHelper.CheckFile(file)){

            this.kpiService.saveInnovationKpi(file);

            return ResponseEntity.ok(Map.of("Message","The given file is Excel"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Upload Excel File only!!");
    }
    @PostMapping("/fileUploadExecutionExcellance")
    public ResponseEntity<?> uploadExcecutionExcellanceKpi(@RequestParam("file") MultipartFile file)throws IOException {
        if (KpiHelper.CheckFile(file)){

            this.kpiService.saveExcecutionExellance(file);

            return ResponseEntity.ok(Map.of("Message","The given file is Excel"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Upload Excel File only!!");
    }

    @PostMapping("/fileUploadGovernanceKpi")
    public ResponseEntity<?> uploadGovarnanceKpi(@RequestParam("file") MultipartFile file)throws IOException {
        if (GovernanceKpiHelper.CheckFile(file)){

            this.kpiService.saveGovarnanceKpi(file);

            return ResponseEntity.ok(Map.of("Message","The given file is Excel"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Upload Excel File only!!");
    }
    @PostMapping("/fileUploadResourceKpi")
    public ResponseEntity<?> uploadResourceKpi(@RequestParam("file") MultipartFile file)throws IOException {
        if (GovernanceKpiHelper.CheckFile(file)){

            this.kpiService.saveResourceKpi(file);

            return ResponseEntity.ok(Map.of("Message","The given file is Excel"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Upload Excel File only!!");
    }
    @GetMapping("/kpi")
    public List<Kpi> getkpiData(){
        return this.kpiService.getkpiData();
    }
    @GetMapping("/innovationKpi")
    public List<InnovationKpi>getInnovationData(){
        return this.kpiService.getInnovationData();
    }

    @GetMapping("/ExecutionExcellance")
    public List<ExecutionExcellance>getExecutionExcellance(){
        return this.kpiService.getExecutionExcellance();
    }

    @GetMapping("/GovarnanceKpi")
    public List<GovernanceKpi>getGovarnanceKpi(){
        return this.kpiService.getGovarnanceKpi();
    }
    @GetMapping("/ResourceKpi")
    public List<ResourceFulfillmentKpi>getResourceKpi(){
        return this.kpiService.getResourceKpi();
    }
}
