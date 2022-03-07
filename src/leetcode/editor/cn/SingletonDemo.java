package leetcode.editor.cn;

public class SingletonDemo {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.setName("张三");
        singleton.setAge(18);
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton2.toString());
    }

    static class Singleton{
        private static volatile Singleton singleton;

        @Override
        public String toString() {
            return "Singleton{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        private String name;
        private Integer age;

        public static Singleton getInstance(){
            if (singleton==null){
                synchronized (Singleton.class){
                    if (singleton==null){
                        singleton = new Singleton();
                    }
                }
            }
            return singleton;
        }
    }
}
