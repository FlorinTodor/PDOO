package Irrgarten;

import java.util.*;

public class Labyrinth {

	private Collection<MonsterSquare> monsters;
	private Collection<LabyrinthSquare> labyrinth;
	private Collection<PlayerSquare> players;
	private char BLOCK_CHAR = 'X';
	private char EMPTY_CHAR = '-';
	private char MONSTER_CHAR = 'M';
	private char COMBAT_CHAR = 'C';
	private char EXIT_CHAR = 'C';
	private int ROW = 0;
	private int COL = 1;
	private int nRows;
	private int nCols;
	private int exitRow;
	private int exitCol;

	public Labyrinth(int nRows, int nCols, int exitRow, int exitCol) {
		throw new UnsupportedOperationException();
	}

	public void spreadPlayers(Player[] players) {
		throw new UnsupportedOperationException();
	}

	public boolean haveAWinner() {
		throw new UnsupportedOperationException();
	}

	public String toString() {
		throw new UnsupportedOperationException();
	}

	public void addMonster(int row, int col, Monster monster) {
		throw new UnsupportedOperationException();
	}

	public Monster putPlayer(Directions direction, Player player) {
		throw new UnsupportedOperationException();
	}

	public void addBlock(Orientation orientation, int startRow, int startCol, int length) {
		throw new UnsupportedOperationException();
	}

	public Directions[] validMoves(int row, int col) {
		throw new UnsupportedOperationException();
	}

	private boolean posOK(int row, int col) {
		throw new UnsupportedOperationException();
	}

	private boolean emptyPos(int row, int col) {
		throw new UnsupportedOperationException();
	}

	private boolean monsterPos(int row, int col) {
		throw new UnsupportedOperationException();
	}

	private boolean exitPos(int row, int col) {
		throw new UnsupportedOperationException();
	}

	private boolean combatPos(int row, int col) {
		throw new UnsupportedOperationException();
	}

	private boolean canStepOn(int row, int col) {
		throw new UnsupportedOperationException();
	}

	private void updateOldPos(int row, int col) {
		throw new UnsupportedOperationException();
	}

	private int[] dir2Pos(int row, int col, Directions direction) {
		throw new UnsupportedOperationException();
	}

	private int[] randomEmptyPos() {
		throw new UnsupportedOperationException();
	}

	private Monster putPlayer2D(int oldRow, int oldCol, int row, int col, Player player) {
		throw new UnsupportedOperationException();
	}
}
