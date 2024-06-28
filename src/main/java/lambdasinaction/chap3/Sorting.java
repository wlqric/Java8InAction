package lambdasinaction.chap3;

import java.util.*;
import static java.util.Comparator.comparing;

public class Sorting {

    public static final String GREEN = "green";
    public static final String RED = "red";

    public enum Color {
        RED("red"),
        GREEN("green");

        private String description;

        // 构造方法，枚举类型的构造方法必须声明为private权限
        private Color(String description) {
            this.description = description;
        }

        // 获取描述的方法
        public String getDescription() {
            return description;
        }
    }

    public static void main(String...args){

        // 1
        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(new Apple(80, GREEN), new Apple(155, GREEN), new Apple(120, RED)));

        // [Apple{color='green', weight=80}, Apple{color='red', weight=120}, Apple{color='green', weight=155}]
        inventory.sort(new AppleComparator());
        System.out.println(inventory);

        // reshuffling things a little
        inventory.set(1, new Apple(30, GREEN));
        
        // 2
        // [Apple{color='green', weight=30}, Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        inventory.sort(new Comparator<Apple>() {
            public int compare(Apple a1, Apple a2){
                return a1.getWeight().compareTo(a2.getWeight()); 
        }});
        System.out.println(inventory);

        // reshuffling things a little
        inventory.set(1, new Apple(20, RED));
        
        // 3
        // [Apple{color='red', weight=20}, Apple{color='green', weight=30}, Apple{color='green', weight=155}]
        // Java编译器可以根据Lambda出现的上下文来推断表达式参数类型。
        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
        System.out.println(inventory);
        
        // reshuffling things a little
        inventory.set(1, new Apple(10, RED));

        // 4pre
        // 使用静态辅助方法
        inventory.sort(comparing((a) -> a.getWeight()));

        // 4
        // [Apple{color='red', weight=10}, Apple{color='red', weight=20}, Apple{color='green', weight=155}]
        // 最终解决方案：使用Comparator中的静态辅助方法
        inventory.sort(comparing(Apple::getWeight));
        System.out.println(inventory);

        inventory.sort(comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getColor));
    }

    public static class Apple {
        private Integer weight = 0;
        private String color = "";

        public Apple(Integer weight, String color){
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                   "color='" + color + '\'' +
                   ", weight=" + weight +
                   '}';
        }
    }

    static class AppleComparator implements Comparator<Apple> {
        public int compare(Apple a1, Apple a2){
            return a1.getWeight().compareTo(a2.getWeight());
        }
    }
}
