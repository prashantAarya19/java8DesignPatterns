package designPatterns.creationalDesignPatterns.builderPattern;

public class Demo {
    public static void main(String[] args) {
        String[] words = {"Hello", "World"};

        StringBuilder sb = new StringBuilder();
        sb.append("<ul>\n");
        for(String word : words) {
            sb.append(String.format("  <li>%s</li>\n", word));
        }
        sb.append("</ul>\n");
        System.out.println(sb);
    }
}
