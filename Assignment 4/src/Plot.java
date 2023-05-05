public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;

    public Plot() {
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.depth = 1;
    }

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public boolean encompasses(Plot plot) {
        if (this.x <= plot.x && this.y <= plot.y && this.x + this.width >= plot.x + plot.width
                && this.y + this.depth >= plot.y + plot.depth) {
            return true;
        }
        return false;
    }

    public boolean overlaps(Plot plot) {
        if (plot.x >= this.x + this.width || plot.x + plot.width <= this.x || plot.y >= this.y + this.depth
                || plot.y + plot.depth <= this.y) {
            return false;
        }
        return true;
    }

    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}
