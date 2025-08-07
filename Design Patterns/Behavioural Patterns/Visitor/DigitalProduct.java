package Visitor;

public class DigitalProduct implements Item {
    String name;
    int downloadSizeInMB;

    public DigitalProduct(String name, int downloadSizeInMB) {
        this.name = name;
        this.downloadSizeInMB = downloadSizeInMB;
    }

    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }
}
