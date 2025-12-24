package com.aghairsalon.resourceserver.repository;

import com.aghairsalon.resourceserver.model.PruebaRsrc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PruebaRsrcRepository extends JpaRepository<PruebaRsrc, Integer> {
}
