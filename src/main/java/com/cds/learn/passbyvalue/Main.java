package com.cds.learn.passbyvalue;

/**
 *
 */
public class Main {

    public static void modifyReference(Foo cRef) {
        cRef.setAttribute("c");
    }

    public static void changeReference(Foo aRef) {
        Foo bRef = new Foo("b");
        aRef = bRef;
    }

    public static void main(String[] args) {
        Foo fooRef = new Foo("a");
        changeReference(fooRef);
        System.out.println(fooRef.getAttribute());

        modifyReference(fooRef);
        System.out.println(fooRef.getAttribute());
    }


    public static class Foo {
        String attribute;

        public Foo(String attribute) {
            this.attribute = attribute;
        }

        public String getAttribute() {
            return attribute;
        }

        public void setAttribute(String attribute) {
            this.attribute = attribute;
        }
    }
}
