/*
 * HelloWorldAnonymousClasses
 * Code rewrote using named classes to implement it
 */
package anonimousclasses;

/**
 * Class prints to console using anonymous classes 
 * @author George
 */
public class HelloWorldAnonymousClasses {

// Inner interface HelloWorld
interface HelloWorld {
    public void greet();
    public void greetSomeone(String someone);
}

// Method sayHello prints 
public void sayHello() {
    
// Local class EnglishGreetings implemented in the method sayHello()
class EnglishGreeting implements HelloWorld {
    String name = "nuCONTEAZAce";
    @Override
    public void greet() {
        greetSomeone("world");
    }
    @Override
    public void greetSomeone(String someone) {
        name = someone;
    System.out.println("Hello " + name);
    }
}
// end of EnglishGreeting local class

// create an anonimous class that greets in French language
HelloWorld frenchGreeting;
frenchGreeting = new HelloWorld() {
    String name = "nuCONTEAZAce";
    @Override
    public void greet() {
        greetSomeone("nuCONTEAZAce");
    }
    @Override
    public void greetSomeone(String someone) {
        name = someone;
        System.out.println("Salut " + name);
    }
};
// end of anonimous class

// create an anonimous class for Spanish language
HelloWorld spanishGreeting;
spanishGreeting = new HelloWorld() {
    String name = "nuCONTEAZAce";
    @Override
    public void greet() {
        greetSomeone("mundo");
    }
    @Override
    public void greetSomeone(String someone) {
        name = someone;
        System.out.println("Hola, " + name);
    }
};
// end of anonymous class

    HelloWorld englishGreeting = new EnglishGreeting();
    englishGreeting.greet();
    frenchGreeting.greetSomeone("Fred");
    spanishGreeting.greet();
}  
// create an EnglishGreeting object/instance

// main method
public static void main(String... args) {
    HelloWorldAnonymousClasses myApp = new HelloWorldAnonymousClasses();
    myApp.sayHello();
}
}
