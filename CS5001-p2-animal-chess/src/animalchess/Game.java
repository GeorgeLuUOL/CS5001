package animalchess;

import java.util.ArrayList;

public class Game {
    static final int HIGHT = 5;
    static final int WIDTH = 6;
    public Player p0;
    public Player p1;

    public ArrayList<Square> squareList;

    public Game(Player p0, Player p1) {
        this.p0 = p0;
        this.p1 = p1;

        this.squareList = new ArrayList<Square>();
        //initialize rows for square
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                squareList.add(new Square(this, i, j, p1));
            }
        }
        for (int i = 2; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                squareList.add(new Square(this, i, j));
            }
        }
        for (int i = 4; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                squareList.add(new Square(this, i, j, p0));
            }
        }
        Piece cat0 = new Cat(p0, squareList.get(0));
        Piece dog0 = new Dog(p0, squareList.get(1));
        Piece lion0 = new Lion(p0, squareList.get(2));
        Piece dog0_b = new Dog(p0, squareList.get(3));
        Piece cat0_b = new Cat(p0, squareList.get(4));
        Piece chick0 = new Chick(p0, squareList.get(11));
        Piece chick0_b = new Chick(p0, squareList.get(12));
        Piece chick0_c = new Chick(p0, squareList.get(13));
        Piece chick1 = new Chick(p0, squareList.get(16));
        Piece chick1_b = new Chick(p0, squareList.get(17));
        Piece chick1_c = new Chick(p0, squareList.get(18));
        Piece cat1 = new Cat(p0, squareList.get(25));
        Piece dog1 = new Dog(p0, squareList.get(26));
        Piece lion1 = new Lion(p0, squareList.get(27));
        Piece dog1_b = new Dog(p0, squareList.get(28));
        Piece cat1_b = new Cat(p0, squareList.get(29));

        p1.winGame();

    }

    public Player getPlayer(int playerNumber) throws IllegalArgumentException {

        if (playerNumber != 0 && playerNumber != 1) {
            throw new IllegalArgumentException();
        }
        return (playerNumber == 0 ? p0 : p1);
    }

    public Player getWinner() {

        if (p0.hasWon() == true) {
            return p0;
        } else if (p1.hasWon() == true) {
            return p1;
        } else {
            return null;
        }

    }

    public Square getSquare(int row, int col) {

        for (Square sqr : squareList) {
            if (sqr.col == col && sqr.row == row) {
                return sqr;
            }
        }

        return null;
    }
}
