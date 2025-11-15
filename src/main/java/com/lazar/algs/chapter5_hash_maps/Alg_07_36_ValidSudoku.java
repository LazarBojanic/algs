package com.lazar.algs.chapter5_hash_maps;

import java.util.HashSet;

public class Alg_07_36_ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			HashSet<Character> rowSet = new HashSet<>();
			HashSet<Character> colSet = new HashSet<>();
			HashSet<Character> boxSet = new HashSet<>();

			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && !rowSet.add(board[i][j])) {
					return false;
				}
				if (board[j][i] != '.' && !colSet.add(board[j][i])) {
					return false;
				}
				int rowIndex = 3 * (i / 3) + j / 3;
				int colIndex = 3 * (i % 3) + j % 3;
				if (board[rowIndex][colIndex] != '.' && !boxSet.add(board[rowIndex][colIndex])) {
					return false;
				}
			}
		}
		return true;
	}

	public void run() {
		char[][] board1 = {
			{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
			{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
			{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
			{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
			{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
			{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
			{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
			{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
			{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
		};
		char[][] board2 = {
			{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
			{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
			{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
			{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
			{'4', '.', '.', '8', '.', '3', '.', '.', '6'},
			{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
			{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
			{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
			{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
		};
		System.out.println(isValidSudoku(board1));
		System.out.println(isValidSudoku(board2));
	}
}
