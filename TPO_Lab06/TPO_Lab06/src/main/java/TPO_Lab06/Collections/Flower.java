package TPO_Lab06.Collections;

class Flower implements Comparable<Flower> {
    private String name;
    private String color;
    private double price;
    private int stemLength;

    public Flower(String name, String color, double price, int stemLength) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.stemLength = stemLength;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public int getStemLength() {
        return stemLength;
    }

    @Override
    public int compareTo(Flower other) {
        return Integer.compare(this.stemLength, other.stemLength);
    }

    @Override
    public String toString() {
        return name + " (" + color + "), Длина стебля: " + stemLength;
    }
}
