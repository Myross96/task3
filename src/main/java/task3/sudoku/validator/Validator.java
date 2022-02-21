package task3.sudoku.validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Validator {

	public boolean isValid(List<List<Integer>> sudoku) {
		for (int i = 0; i < sudoku.size(); i++) {
			if (hasDuplicates(sudoku, i, i + 1, 0, sudoku.size())) {
				return false;
			}
		}

		for (int i = 0; i < sudoku.size(); i++) {
			if (hasDuplicates(sudoku, 0, sudoku.size(), i, i + 1)) {
				System.out.println("did" + i);
				return false;
			}
		}

		int regionSize = (int) Math.sqrt(sudoku.size());
		for (int i = 0; i < regionSize; i++) {
			for (int j = 0; j < regionSize; j++) {
				if (hasDuplicates(sudoku, regionSize * i, regionSize * (i + 1), regionSize * j, regionSize * (j + 1))) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean hasDuplicates(List<List<Integer>> sudoku, int startRow, int endRow, int startCol, int endCol) {
		List<Boolean> isPresent = new ArrayList<>(Collections.nCopies(sudoku.size() + 1, false));

		for (int i = startRow; i < endRow; i++) {
			for (int j = startCol; j < endCol; j++) {
				int value = sudoku.get(i).get(j);
				if (value != 0) {
					if (isPresent.get(value)) {
						return true;
					} else {
						isPresent.set(value, true);
					}
				}
			}
		}
		return false;
	}
}
