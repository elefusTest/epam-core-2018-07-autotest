package com.epam.se02;

public abstract class Example2 {

    private final String string;

    protected Example2(String string) {
        this.string = string;
    }

    public abstract void say();

    public String getString() {
        return string;
    }
}

class Example2Child extends Example2 {

    Example2Child() {
        super("string value");
    }

    @Override
    public void say() {
        System.out.println("Hello from Example2Child: " + getString());
    }
}

class Launcher {

    public static void main(String[] args) {
        Example2 ref = new Example2Child();
        ref.say();
    }
}
