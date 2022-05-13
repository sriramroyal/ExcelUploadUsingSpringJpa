package com.example.engagementKpi.Repository;

import com.example.engagementKpi.Entity.ExecutionExcellance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExecutionRepository extends JpaRepository<ExecutionExcellance,Long> {
}
