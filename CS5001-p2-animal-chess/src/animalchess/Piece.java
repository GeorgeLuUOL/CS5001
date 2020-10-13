package animalchess;

import java.util.ArrayList;

public class Piece {

    Square square;
    Player owner;
    ArrayList<Square> validMoves;

    public Piece(Player owner, Square square) {
        this.owner = owner;
        this.square = square;
        this.square.piece = this;
        validMoves=new ArrayList<Square>();
    }

    public ArrayList<Square> getLegalMoves() {

        return validMoves;
    }

    public void move(Square toSquare) throws IllegalArgumentException {
        //judge if the move is valid
        if(!validMoves.contains(toSquare)){
            throw new IllegalArgumentException();
        }
        if(toSquare.getPiece().getOwner().equals(this.owner)){
            throw new IllegalArgumentException();
        }
        //test whether to capture
        if(toSquare.getPiece()!=null){
            toSquare.getPiece().beCaptured(this.owner);
        }
        this.square=toSquare;
        this.square.piece=this;
        updatePos(toSquare);

    }
    public void updatePos(Square s){
        if(this.owner.playerNumber==0){

        }
    }

    public void beCaptured(Player capturer) {
        this.square.piece = null;
        this.square = null;
        this.owner = capturer;
        this.owner.addPieceToHand(this);

    }

    public Square getSquare() {
        return this.square;
    }

    public Player getOwner() {
        return this.owner;
    }
}
