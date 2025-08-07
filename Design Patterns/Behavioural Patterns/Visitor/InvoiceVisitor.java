package Visitor;

public class InvoiceVisitor implements ItemVisitor {

    public void visit(PhysicalProduct item) {
        System.out.println("Invoice: " + item.name + " - Shipping to customer");
    }

    public void visit(DigitalProduct item) {
        System.out.println("Invoice: " + item.name + " - Email with download link");
    }

}
