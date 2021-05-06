package com.devsuperior.devvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.devvendas.dto.SaleSucessDTO;
import com.devsuperior.devvendas.dto.SaleSumDTO;
import com.devsuperior.devvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

	@Query("SELECT new com.devsuperior.devvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ " FROM Sale AS obj Group BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();


	@Query("SELECT new com.devsuperior.devvendas.dto.SaleSucessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ " FROM Sale AS obj Group BY obj.seller")
	List<SaleSucessDTO> sucessGroupedBySeller();
}

