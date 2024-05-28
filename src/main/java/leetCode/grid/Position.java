package leetCode.grid;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Position {
    int x;
    int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    Position moveTo(Direction direction){
        if(direction.equals(Direction.TOP)){
            return new Position(this.getX(), this.getY() - 1);
        }
        if(direction.equals(Direction.LEFT)){
            return new Position(this.getX()-1, this.getY());
        }

        if(direction.equals(Direction.BOTTOM)){
            return new Position(this.getX(), this.getY() + 1);
        }

        if(direction.equals(Direction.TOP)){
            return new Position(this.getX()+1, this.getY());
        }

        return this;
    }
}
