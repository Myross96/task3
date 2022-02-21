package task3.sudoku.validator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidatorTest {

	private Validator validator;

	@BeforeEach
	void setUp() {
		validator = new Validator();
	}

	@Test
	void givenSudoku_whenValidate_thenValidate() {
		List<List<Integer>> sudoku = new ArrayList<>();
		sudoku.add(List.of(7, 8, 4, 1, 5, 9, 3, 2, 6));
		sudoku.add(List.of(5, 3, 9, 6, 7, 2, 8, 4, 1));
		sudoku.add(List.of(6, 1, 2, 4, 3, 8, 7, 5, 9));
		sudoku.add(List.of(9, 2, 8, 7, 1, 5, 4, 6, 3));
		sudoku.add(List.of(3, 5, 7, 8, 4, 6, 1, 9, 2));
		sudoku.add(List.of(4, 6, 1, 9, 2, 3, 5, 8, 7));
		sudoku.add(List.of(8, 7, 6, 3, 9, 4, 2, 1, 5));
		sudoku.add(List.of(2, 4, 3, 5, 6, 1, 9, 7, 8));
		sudoku.add(List.of(1, 9, 5, 2, 8, 7, 6, 3, 4));
		boolean expected = true;

		boolean actual = validator.isValid(sudoku);

		assertEquals(expected, actual);
	}

	@Test
	void givenWrongSudoku_whenValidate_thenNotValidate() {
		List<List<Integer>> sudoku = new ArrayList<>();
		sudoku.add(List.of(7, 8, 4, 1, 5, 9, 3, 2, 6));
		sudoku.add(List.of(5, 3, 9, 6, 7, 2, 8, 4, 1));
		sudoku.add(List.of(6, 1, 2, 4, 3, 8, 7, 5, 9));
		sudoku.add(List.of(9, 2, 8, 3, 1, 5, 4, 6, 3));
		sudoku.add(List.of(3, 5, 7, 8, 4, 6, 1, 9, 2));
		sudoku.add(List.of(4, 6, 1, 9, 2, 3, 5, 8, 7));
		sudoku.add(List.of(8, 7, 6, 3, 9, 4, 2, 1, 5));
		sudoku.add(List.of(2, 4, 3, 5, 6, 1, 9, 7, 8));
		sudoku.add(List.of(1, 9, 5, 2, 8, 7, 6, 3, 4));
		boolean expected = false;

		boolean actual = validator.isValid(sudoku);

		assertEquals(expected, actual);
	}
}
