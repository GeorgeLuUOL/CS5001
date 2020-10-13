package animalchess;

public class PromotablePiece extends Piece {
    public Boolean promoted=false;
    public PromotablePiece(Player owner, Square square) {
        super(owner, square);
    }

    public Boolean getIsPromoted() {
        return this.promoted;
    }

    public void promote() {
        this.promoted = true;
    }

    @Override
    public void move(Square toSquare) {
        //basic move function
        super.move(toSquare);
        //test if promoted
        if(this.square.promotesPlayer.equals(this.owner)){
            this.promote();
        }

    }

    @Override
    public void beCaptured(Player capyurer) {

    }
}
