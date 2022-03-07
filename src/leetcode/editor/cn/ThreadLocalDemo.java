package leetcode.editor.cn;

public class ThreadLocalDemo {
    public static void main(String[] args) {
        DemoThread demoThread = new DemoThread();
        Thread thread = new Thread(demoThread, "线程");
        thread.start();
    }

    static class DemoThread implements Runnable {

        private static ThreadLocal<User> userThreadLocal;

        @Override
        public void run() {
            userThreadLocal = new ThreadLocal<>();
            userThreadLocal.set(new User("张三", 3));
            System.gc();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            User user = userThreadLocal.get();
            System.out.println(user);
        }
    }

    static class User {
        private String name;
        private Integer age;

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
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


    }
}
