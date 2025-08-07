package Visitor;

public interface ItemVisitor {
    void visit(PhysicalProduct item);
    void visit(DigitalProduct item);
}
