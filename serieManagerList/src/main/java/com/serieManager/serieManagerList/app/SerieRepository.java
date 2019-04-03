package com.serieManager.serieManagerList.app;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {
	List<Serie> findByNom(String nom);
}