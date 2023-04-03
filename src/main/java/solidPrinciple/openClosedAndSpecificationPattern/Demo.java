package solidPrinciple.openClosedAndSpecificationPattern;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

enum Color {
    RED, GREEN, BLUE
}

enum Size {
    SMALL, MEDIUM, LARGE, HUGE
}

class Product {
    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }
}
// This filter class is defeating the Open - Closed principal
class ProductsFilter {
    public Stream<Product> filterByColor(List<Product> products, Color color) {
        return products.stream().filter(e -> e.color == color);
    }

    public Stream<Product> filerBySize(List<Product> products, Size size) {
        return products.stream().filter(e -> e.size == size);
    }

    public Stream<Product> fileterBySizeAndColor(List<Product> products, Size size, Color color) {
        return products.stream().filter(e -> e.size == size && e.color == color);
    }
}

public  class Demo {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Apple", Color.RED, Size.MEDIUM),
                new Product("Banana", Color.GREEN, Size.MEDIUM),
                new Product("Car", Color.BLUE, Size.HUGE));

        System.out.println("***Previous filter***");
        ProductsFilter prevFilter = new ProductsFilter();
        prevFilter.filterByColor(products, Color.RED).forEach(e -> System.out.println("- "+e.name+", "+e.color+", "+e.size));
        prevFilter.filerBySize(products, Size.HUGE).forEach(e -> System.out.println("- "+e.name+", "+e.color+", "+e.size));

        System.out.println("***New filter***");
        ImprovisedFilter improvisedFilter = new ImprovisedFilter();
        improvisedFilter.filter(products, new ColorSpecification(Color.RED)).forEach(e -> System.out.println("- "+e.name+", "+e.color+", "+e.size));
        improvisedFilter.filter(products, new SizeSpecification(Size.HUGE)).forEach(e -> System.out.println("- "+e.name+", "+e.color+", "+e.size));
    }
}

//*** Here we are  making best use of open closed principle
interface Filter<T> {
    Stream<T> filter(List<T> items, Specification<T> specification);
}

interface Specification<T> {
    boolean isSatisfied(T item);
}

class ColorSpecification implements Specification<Product> {
    private final Color color;

    public ColorSpecification(Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.color == color;
    }
}

class SizeSpecification implements Specification<Product> {
    private final Size size;

    public SizeSpecification(Size size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.size == size;
    }
}

class ImprovisedFilter implements Filter<Product> {
    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> specification) {
        return items.stream().filter(specification::isSatisfied);
    }
}
