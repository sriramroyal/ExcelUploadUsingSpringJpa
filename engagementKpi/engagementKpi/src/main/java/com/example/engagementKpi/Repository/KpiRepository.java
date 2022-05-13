package com.example.engagementKpi.Repository;

import com.example.engagementKpi.Entity.Kpi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KpiRepository extends JpaRepository<Kpi,Long> {
}
