import java.util.Set;

public class Main {
    public static void main(String[] args) {
       Board board = new Board();
       board.setupDefaulPiecesPositions();

    //    BoardConsoleRenderer render = new BoardConsoleRenderer();
    //    render.render(board);

    //    Piece piece = board.getPiece(new Coordinates(File.B, 1));
    //    Set<Coordinates> availableMoveSquare = piece.getAvailableMoveSquares(board);
    //    int x = 3;

        Game game = new Game(board);
        game.gameLoop();
       
    }
}
