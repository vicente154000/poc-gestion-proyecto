package com.aghairsalon.resourceserver.services;

import com.aghairsalon.resourceserver.model.PruebaRsrc;
import com.aghairsalon.resourceserver.repository.PruebaRsrcRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PruebaRsrcService {

    private final PruebaRsrcRepository pruebaRsrcRepository;

    @Cacheable("recursos")
    public List<PruebaRsrc> findAll() {
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        return pruebaRsrcRepository.findAll();
    }

}
