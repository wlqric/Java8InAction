package lambdasinaction.chap8;


/**
 * @author raoulDoc
 */
public class StrategyMain {

    public static void main(String[] args) {
        // old school
        Validator v1 = new Validator(new IsNumeric());
        System.out.println(v1.validate("aaaa"));
        Validator v2 = new Validator(new IsAllLowerCase ());
        System.out.println(v2.validate("bbbb"));


        // with lambdas 不需要声明新的类来实现不同的策略，更简洁。
        Validator v3 = new Validator((String s) -> s.matches("\\d+"));
        System.out.println(v3.validate("aaaa"));
        Validator v4 = new Validator((String s) -> s.matches("[a-z]+"));
        System.out.println(v4.validate("bbbb"));
    }

    interface ValidationStrategy {
        boolean execute(String s);
    }

    private static class IsAllLowerCase implements ValidationStrategy {
        @Override
        public boolean execute(String s){
            return s.matches("[a-z]+");
        }
    }

    private static class IsNumeric implements ValidationStrategy {
        @Override
        public boolean execute(String s){
            return s.matches("\\d+");
        }
    }

    private static class Validator{
        private final ValidationStrategy strategy;

        public Validator(ValidationStrategy v){
            this.strategy = v;
        }

        public boolean validate(String s){
            return strategy.execute(s); }
    }
}
