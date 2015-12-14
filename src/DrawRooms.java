import java.awt.Graphics2D;

/**
 * Created by Jacob on 12/8/15.
 */
public class DrawRooms{

    int x,y,width,height;

    public DrawRooms() {
        x = 0;
        y = 0;
        width = 0;
        height= 0;
    }

    public DrawRooms(int x, int y, int w, int h){
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }

    public void draw(Graphics2D g2d) {
        g2d.drawRect(x, y, width, height);
    }


    //sets x coordinate
    public void setX(int x) {
        this.x = x;
    }

    //sets y coordinate
    public void setY(int y) {
        this.y = y;
    }

    //sets width
    public void setWidth(int w) {
        this.width = w;
    }

    //sets height
    public void setHeight(int h) {
        this.height = h;
    }

    //gets x
    public int getX() {
        return x;
    }

    //gets y
    public int getY() {
        return y;
    }

    //gets width
    public int getWidth() {
        return width;
    }

    //gets height
    public int getHeight() {
        return height;
    }

    //toString to report values
    @Override
    public String toString(){
        String s = "\nX-Coordinate: " + getX() +
                "\nY-Coordinate: " + getY() +
                "Width: " + getWidth() +
                 "Height : " + getHeight();
        return s;
    }
}

