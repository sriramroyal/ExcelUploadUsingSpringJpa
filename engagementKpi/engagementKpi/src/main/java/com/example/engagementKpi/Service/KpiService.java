package com.example.engagementKpi.Service;

import com.example.engagementKpi.Entity.*;
import com.example.engagementKpi.Helper.*;
import com.example.engagementKpi.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class KpiService {

    @Autowired
    private KpiRepository kpiRepository;
    @Autowired
    private InnovationRepository innovationRepository;
    @Autowired
    private ExecutionRepository exectionRepository;
    @Autowired
    private GovernanceKpiRepository governanceKpiRepository;
    @Autowired
    private ResourceFulfillmentRepository resourceFulfillmentRepository;

    public void saveKpi(MultipartFile file)throws IOException {
        List<Kpi> kpi = KpiHelper.ExcelToList(file.getInputStream());

        this.kpiRepository.saveAll(kpi);
    }
    public void saveInnovationKpi(MultipartFile file)throws IOException {
        List<InnovationKpi> innovationKpis=InnovationHelper.ExcelToList(file.getInputStream());
        this.innovationRepository.saveAll(innovationKpis);
    }
    public void saveExcecutionExellance(MultipartFile file)throws IOException {
        List<ExecutionExcellance> executionExcellances= ExecutionHelper.ExcelToList(file.getInputStream());
        this.exectionRepository.saveAll(executionExcellances);
    }
    public List<Kpi> getkpiData() {
        return this.kpiRepository.findAll();
    }

    public List<InnovationKpi>getInnovationData(){
        return this.innovationRepository.findAll();
    }
    public List<ExecutionExcellance> getExecutionExcellance() {
        return this.exectionRepository.findAll();
    }

    public void saveGovarnanceKpi(MultipartFile file)throws IOException{
        List<GovernanceKpi> governanceKpis= GovernanceKpiHelper.ExcelToList(file.getInputStream());
        this.governanceKpiRepository.saveAll(governanceKpis);
    }
    public List<GovernanceKpi> getGovarnanceKpi() {
        return this.governanceKpiRepository.findAll();
    }

    public void saveResourceKpi(MultipartFile file) throws IOException{
        List<ResourceFulfillmentKpi> resourceFulfillmentKpis= ResourceHelper.ExcelToList(file.getInputStream());
        this.resourceFulfillmentRepository.saveAll(resourceFulfillmentKpis);
    }
    public List<ResourceFulfillmentKpi> getResourceKpi() {
        return this.resourceFulfillmentRepository.findAll();
    }
}
