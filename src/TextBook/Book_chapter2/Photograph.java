package TextBook.Book_chapter2;

public class Photograph implements Sellable {


    private String descript;
    private int price;
    private boolean color;

    public Photograph(String descript, int price, boolean color) {
        this.descript = descript;
        this.price = price;
        this.color = color;
    }



    @Override
    public String description() {
        return descript;
    }

    @Override
    public int listPrice() {
        return price;
    }

    @Override
    public int lowestPrice() {
        return price/2;
    }

    public boolean isColor(){
        return color;
    }
}
