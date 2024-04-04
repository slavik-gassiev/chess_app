import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Knight extends Piece{

    public Knight(Color color, Coordinates coordinates) {
        super(color, coordinates);
        //TODO Auto-generated constructor stub
    }

    @Override
    public Set<CoordinatesShift> getPieceMoves() {
        // TODO Auto-generated method stub
        return new HashSet<>(Arrays.asList(
            new CoordinatesShift(1, 2),
            new CoordinatesShift(2, 1),

            new CoordinatesShift(2, -1),
            new CoordinatesShift(1, -2),

            new CoordinatesShift(-2, -1),
            new CoordinatesShift(-1, -2),

            new CoordinatesShift(-2, 1),
            new CoordinatesShift(-1, 2)
            )
            
            );
        }
        
    }
    