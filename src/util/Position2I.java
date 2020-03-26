package util;

public class Position2I {

    private int x;
    private int y;

    /**
     * initialize object
     */
    public Position2I(){
        //do nothing
    }

    /**
     * initialize object in given position
     * @param x position
     * @param y position
     */
    public Position2I(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * @return x position
     */
    public int getX() {
        return x;
    }

    /**
     * set a new position in X
     * @param x position
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return y position
     */
    public int getY() {
        return y;
    }

    /**
     * set a new position in Y
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }
}
