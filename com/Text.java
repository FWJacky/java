/**
 * @ClassName Text
 * @Description TODO
 * @Author L
 * @Date 2019/4/9 13:11
 * @Version 1.0
 **/

//class A {
//    private String name = "A的私有域";
//    public String getName() {
//        return name;
//    }
//}
//class B {
//    private int age = 20;
//    upublic int getAge() {
//        return age;
//    }
//}
//class Outter {
//    private class InnerClassA extends A {
//        public String name() {
//            return super.getName();
//        }
//    }
//    private class InnerClassB extends B {
//        public int age() {
//            return super.getAge();
//        }
//    }
//    public String name() {
//        return new InnerClassA().name();
//    }
//    public int age() {
//        return new InnerClassB().age();
//    }
//}

//    class Outter {
//        private String outName;
//        private int outAge;
//
//        class Inner {
//            private int InnerAge;
//            public Inner() {
//                Outter.this.outName = "I am Outter class";
//                Outter.this.outAge = 20;
//            }
//            public void display() {
//                System.out.println(outName);
//                System.out.println(outAge);
//            }
//        }
//}

    class Outter{
        public void display() {
            Inner inner = new Inner();
            inner.display();
        }
        class Inner {
            public void display() {
                System.out.println("I am InnerClass");
            }
        }
}
public class Text {
    public static void main(String[] args) {
        Outter outter = new Outter();
        outter.display();
//        Outter.Inner inner = new Outter().new Inner();
//        inner.display();
//        Outter outter = new Outter();
//        System.out.println(outter.name());
//        System.out.println(outter.age());
    }
}
