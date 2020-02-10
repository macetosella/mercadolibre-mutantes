package com.mercadolibre.mutants.service.impl;

import com.mercadolibre.mutants.service.FindDnaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FindDnaAlgorithmServiceImpl implements FindDnaService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FindDnaAlgorithmServiceImpl.class);

	private static final String[] MUTANT_DNA_SEQUENCES = {"AAAA", "CCCC", "GGGG", "TTTT"};
	private static final int[] X_AXIS_DIRECTIONS = {-1, -1, -1, 0, 0, 1, 1, 1};
	private static final int[] Y_AXIS_DIRECTIONS = {-1, 0, 1, -1, 1, -1, 0, 1};

	private boolean isWithinRangeDnaSequence(int rowDirection, int colDirection, int dnaLength) {
		return rowDirection >= 0
				&& rowDirection <= (dnaLength - 1)
				&& colDirection >= 0
				&& colDirection <= dnaLength - 1;
	}

	public Boolean dnaAnalyzer(String[] dna) throws Exception {
		int dnaLength = dna.length;
		int repeatedSequenceCounter = 0;

		for (String mutantDnaSequence : MUTANT_DNA_SEQUENCES) {
			for (int x = 0; x < dnaLength; x++) {
				for (int y = 0; y < dnaLength; y++) {
					repeatedSequenceCounter = countDnaSequence(dna, x, y, mutantDnaSequence, repeatedSequenceCounter);

					if (repeatedSequenceCounter >= 4) {
						LOGGER.info("The DNA sequence belongs to a mutant!");
						return Boolean.TRUE;
					}
				}
			}
		}
		LOGGER.info("The DNA sequence does not belong to a mutant!");
		return Boolean.FALSE;
	}

	private int countDnaSequence(String[] dna, int row, int column, String mutantDnaSequence, int repeatedSequenceCounter) {
		int dnaLength = dna.length;
		if (dna[row].charAt(column) != mutantDnaSequence.charAt(0)) {
			return repeatedSequenceCounter;
		}

		int possibleMutantDnaSeqLength = mutantDnaSequence.length();

		for (int directionIndex = 0; directionIndex < 8; directionIndex++) {
			int rowDirection = row + X_AXIS_DIRECTIONS[directionIndex];
			int colDirection = column + Y_AXIS_DIRECTIONS[directionIndex];
			int possibleMutantDnaSeqCount;

			for (possibleMutantDnaSeqCount = 1; possibleMutantDnaSeqCount <= possibleMutantDnaSeqLength - 1; possibleMutantDnaSeqCount++) {

				if (!isWithinRangeDnaSequence(rowDirection, colDirection, dnaLength)) {
					break;
				}

				if (dna[rowDirection].charAt(colDirection) != mutantDnaSequence.charAt(possibleMutantDnaSeqCount)) {
					break;
				}

				rowDirection = rowDirection + X_AXIS_DIRECTIONS[directionIndex];
				colDirection = colDirection + Y_AXIS_DIRECTIONS[directionIndex];
			}

			if (possibleMutantDnaSeqCount == possibleMutantDnaSeqLength) {
				repeatedSequenceCounter++;

				if (repeatedSequenceCounter >= 4) {
					return repeatedSequenceCounter;
				}
			}
		}
		return repeatedSequenceCounter;
	}
}
