package animalchess;

import java.util.ArrayList;

public class Player {
    String name;
    int playerNumber;
    ArrayList<Piece> pieceArray;
    Boolean won = false;

    public Player(String name, int playerNumber) {
        this.name = name;
        this.playerNumber = playerNumber;
        this.pieceArray = new ArrayList<Piece>();

    }

    public String getName() {
        return this.name;

    }

    public int getPlayerNumber() {
        return this.playerNumber;
    }

    public ArrayList<Piece> getHand() {

        return this.pieceArray;
    }

    public void addPieceToHand(Piece piece) {

        pieceArray.add(piece);

    }

    public void dropPiece(Piece piece, Square square) {
        try {
            square.placePiece(piece);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        this.pieceArray.remove(piece);

    }

    public void winGame() {
        this.won = true;
    }

    public Boolean hasWon() {
        return this.won;
    }

}
