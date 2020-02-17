package com.mercadolibre.mutants.service.impl;

import com.mercadolibre.mutants.dto.StatDTO;
import com.mercadolibre.mutants.repository.HumanRepository;
import com.mercadolibre.mutants.repository.MutantRepository;
import com.mercadolibre.mutants.service.StatService;
import com.mercadolibre.mutants.util.StatUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatServiceImpl implements StatService {

	private static final Logger LOGGER = LogManager.getLogger(MutantServiceImpl.class);

	private final MutantRepository mutantRepository;

	private final HumanRepository humanRepository;

	@Autowired
	public StatServiceImpl(MutantRepository mutantRepository, HumanRepository humanRepository) {
		this.mutantRepository = mutantRepository;
		this.humanRepository = humanRepository;
	}

	@Override
	public StatDTO stats() {
		long mutantCount = mutantRepository.count();
		long humanCount = humanRepository.count();

		StatDTO stats = new StatDTO(mutantCount, humanCount, StatUtil.calculateRatioWithBigDecimal(mutantCount, humanCount));
		LOGGER.info("Statistics collected: {}", stats);
		LOGGER.debug("Statistics collected: {}", stats);
		return stats;
	}
}
