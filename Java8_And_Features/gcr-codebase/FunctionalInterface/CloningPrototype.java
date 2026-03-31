class ProductPrototype implements Cloneable {
    private String name;
    private double price;
    private String category;
    
    public ProductPrototype(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    @Override
    public ProductPrototype clone() {
        try {
            return (ProductPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + ", category='" + category + "'}";
    }
}

class DocumentTemplate implements Cloneable {
    private String title;
    private String content;
    private String format;
    
    public DocumentTemplate(String title, String content, String format) {
        this.title = title;
        this.content = content;
        this.format = format;
    }
    
    @Override
    public DocumentTemplate clone() {
        try {
            return (DocumentTemplate) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    @Override
    public String toString() {
        return "Document{title='" + title + "', content='" + content + "', format='" + format + "'}";
    }
}

public class CloningPrototype {
    public static void main(String[] args) {
        ProductPrototype originalProduct = new ProductPrototype("Laptop", 999.99, "Electronics");
        DocumentTemplate originalDoc = new DocumentTemplate("Report", "Sample content", "PDF");
        
        ProductPrototype clonedProduct = originalProduct.clone();
        clonedProduct.setName("Gaming Laptop");
        clonedProduct.setPrice(1299.99);
        
        DocumentTemplate clonedDoc = originalDoc.clone();
        clonedDoc.setTitle("Monthly Report");
        clonedDoc.setContent("Monthly sales data");
        
        System.out.println("Original: " + originalProduct);
        System.out.println("Cloned: " + clonedProduct);
        
        System.out.println("Original: " + originalDoc);
        System.out.println("Cloned: " + clonedDoc);
    }
}