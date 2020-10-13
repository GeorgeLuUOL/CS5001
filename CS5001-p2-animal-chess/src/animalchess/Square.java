package animalchess;

public class Square {
    public static void main(String args[]) {
        Game g = new Game(new Player("alice", 0), new Player("bob", 1));
        for (Square s : g.squareList) {
            System.out.println(s.row + " " + s.col);
            System.out.print(" " + s.getPiece());
            System.out.println();
        }
        //Player test=new Player("mic",0);
        // test.addPieceToHand(new Piece(test,null));
        // System.out.println(test.getHand().get(0).getOwner().name);

        Square square = new Square(null, 1, 2);  // no game (null)
        Square square2 = new Square(null, 3, 1);
        Player michael = new Player("Michael", 0);
        Dog gold = new Dog(michael, square);
        Cat silver = new Cat(michael, square2);

        // square.placePiece(silver);

    }

    Game game;
    int row;
    int col;
    Player promotesPlayer;
    Piece piece;

    public Square(Game game, int row, int col) {
        this.game = game;
        this.row = row;
        this.col = col;

    }

    public Square(Game game, int row, int col, Player promotesPlayer) {
        this.game = game;
        this.row = row;
        this.col = col;
        this.promotesPlayer = promotesPlayer;
    }

    public void placePiece(Piece piece) throws IllegalArgumentException {
        //if the square is empty
        if (this.piece == null) {
            this.piece = piece;
            piece.square = this;
        } else {
            throw new IllegalArgumentException("u");
        }


    }

    public Piece getPiece() {
        return this.piece;
    }

    public void removePiece() {
        this.piece.square = null;
        this.piece = null;
    }

    public Game getGame() {
        return this.game;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }
}
