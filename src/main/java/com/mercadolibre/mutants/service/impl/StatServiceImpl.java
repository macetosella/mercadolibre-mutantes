package com.mercadolibre.mutants.service.impl;

import com.mercadolibre.mutants.dto.StatDTO;
import com.mercadolibre.mutants.repository.HumanRepository;
import com.mercadolibre.mutants.repository.MutantRepository;
import com.mercadolibre.mutants.service.StatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class StatServiceImpl implements StatService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MutantServiceImpl.class);

	@Autowired
	private MutantRepository mutantRepository;

	@Autowired
	private HumanRepository humanRepository;

	@Override
	public StatDTO stats() {
		long mutantCount = mutantRepository.count();
		long humanCount = humanRepository.count();
		String sRatio = "0.00";
		DecimalFormat df = new DecimalFormat("#.##");
		if (humanCount > 0) {
			sRatio = df.format((mutantCount / humanCount));
		}
		double ratio = Double.parseDouble(sRatio);
		StatDTO stats = new StatDTO(mutantCount, humanCount, ratio);
		LOGGER.info("Statistics collected: {}", stats);
		return stats;
	}
}
