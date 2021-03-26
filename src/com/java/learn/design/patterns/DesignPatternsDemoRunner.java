package com.java.learn.design.patterns;

import com.java.learn.design.patterns.behavioral.chainofresponsibility.*;
import com.java.learn.design.patterns.behavioral.command.Broker;
import com.java.learn.design.patterns.behavioral.command.Buy;
import com.java.learn.design.patterns.behavioral.command.MarketTransaction;
import com.java.learn.design.patterns.behavioral.command.Sell;
import com.java.learn.design.patterns.creational.builder.BankAccount;
import com.java.learn.design.patterns.creational.factory.ShapeFactory;
import com.java.learn.design.patterns.creational.factory.models.Shape;
import com.java.learn.design.patterns.creational.prototype.Rectangle;
import com.java.learn.design.patterns.creational.prototype.Triangle;
import com.java.learn.design.patterns.creational.singletone.NaiveSingleton;
import com.java.learn.design.patterns.structural.bridge.AbstractShape;
import com.java.learn.design.patterns.structural.bridge.Circle;
import com.java.learn.design.patterns.structural.bridge.GreenCircle;
import com.java.learn.design.patterns.structural.bridge.RedCircle;
import com.java.learn.design.patterns.structural.composite.CompanyDirector;
import com.java.learn.design.patterns.structural.composite.Developer;
import com.java.learn.design.patterns.structural.composite.Employee;
import com.java.learn.design.patterns.structural.composite.Manager;
import com.java.learn.design.patterns.structural.proxy.ThirdPartyYouTube;
import com.java.learn.design.patterns.structural.proxy.YouTubeCacheProxy;
import com.java.learn.design.patterns.structural.proxy.YouTubeDownloader;

import java.util.ArrayList;
import java.util.List;

/**
 * A very nice site about all the design patterns:
 * https://refactoring.guru/
 */
public class DesignPatternsDemoRunner {

    private static final String FACTORY = "Factory";
    private static final String BRIDGE = "Bridge";
    private static final String BUILDER = "Builder";
    private static final String CHAIN_OF_RESPONSIBILITY = "Chain of Responsibility";
    private static final String COMMAND = "Command";
    private static final String SINGLETON = "Singleton";
    private static final String PROTOTYPE = "Prototype";
    private static final String COMPOSITE = "Composite";
    private static final String PROXY = "Proxy";

    private static Server server;
    private static void initCORServer() {
        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        // All checks are linked. Client can build various chains using the same
        // components.
        Middleware middleware = new ThrottlingMiddleware(2);
        middleware.linkWith(new UserExistsMiddleware(server))
                .linkWith(new UserRoleMiddleware());

        // Server gets a chain from client code.
        server.setMiddleware(middleware);
    }

    public static void main(String[] args) {
        factoryDesignDemo();

        bridgeDesignDemo();

        builderDesignDemo();

        chainOfResponsibilityDesignDemo();

        commandDesignDemo();

        singletonDesignDemo();

        prototypeDesignDemo();

        compositeDesignDemo();

        //TODO: uncomment only when you want to learn about Proxy Design Pattern; slow down the execution.
        //proxyDesignDemo();
    }

    private static void proxyDesignDemo() {
        printDesignPatternStart(PROXY);

        YouTubeDownloader naiveDownloader = new YouTubeDownloader(new ThirdPartyYouTube());
        YouTubeDownloader smartDownloader = new YouTubeDownloader(new YouTubeCacheProxy());

        long naive = proxyTest(naiveDownloader);
        long smart = proxyTest(smartDownloader);
        System.out.print("Time saved by caching proxy: " + (naive - smart) + "ms");

        printDesignPatternEnd(PROXY);
    }

    private static long proxyTest(YouTubeDownloader downloader) {
        long startTime = System.currentTimeMillis();

        // User behavior in our app:
        downloader.renderPopularVideos();
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("dancesvideoo");
        // Users might visit the same page quite often.
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderVideoPage("someothervid");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Time elapsed: " + estimatedTime + "ms\n");
        return estimatedTime;
    }

    /**
     * Best design pattern for tree like structures
     */
    private static void compositeDesignDemo() {
        printDesignPatternStart(COMPOSITE);
        Developer dev = new Developer("Stan Smith", "Java Developer", 73219);
        Developer senior = new Developer("Jhon Jr. McCoy", "Senior Java Developer", 63217963);

        Manager manager = new Manager("Mr. Boss", "Project Manager", 899321);

        List<Employee> employees = new ArrayList<>();
        employees.add(manager);
        employees.add(senior);
        employees.add(dev);

        CompanyDirector ceo = new CompanyDirector("Jay Grand Bo$$", employees);
        ceo.showDetails();

        printDesignPatternEnd(COMPOSITE);
    }

    private static void prototypeDesignDemo() {
        printDesignPatternStart(PROTOTYPE);

        List<com.java.learn.design.patterns.creational.prototype.Shape> shapes = new ArrayList<>();
        List<com.java.learn.design.patterns.creational.prototype.Shape> shapesCopy = new ArrayList<>();

        Triangle triangle = new Triangle();
        triangle.setColor("RED");
        triangle.setBase(10);

        Triangle anotherTriangle = new Triangle();
        anotherTriangle.setX(5);
        anotherTriangle.setY(8);
        anotherTriangle.setColor("RED");
        anotherTriangle.setBase(10);

        Rectangle rectangle = new Rectangle();
        rectangle.setColor("BLUE");
        rectangle.setHeight(10);
        rectangle.setHeight(20);

        shapes.add(triangle);
        shapes.add(anotherTriangle);
        shapes.add(rectangle);

        cloneAndCompare(shapes, shapesCopy);

        printDesignPatternEnd(PROTOTYPE);
    }

    private static void cloneAndCompare(List<com.java.learn.design.patterns.creational.prototype.Shape> shapes, List<com.java.learn.design.patterns.creational.prototype.Shape> shapesCopy) {
        for (com.java.learn.design.patterns.creational.prototype.Shape shape : shapes) {
            shapesCopy.add(shape.clone());
        }

        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != shapesCopy.get(i)) {
                System.out.println(i + ": Shapes are different objects (yay!)");
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    System.out.println(i + ": And they are identical (yay!)");
                } else {
                    System.out.println(i + ": But they are not identical (booo!)");
                }
            } else {
                System.out.println(i + ": Shape objects are the same (booo!)");
            }
        }
    }


    private static void singletonDesignDemo() {
        printDesignPatternStart(SINGLETON);

        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:" + "\n");
        NaiveSingleton singleton = NaiveSingleton.getInstance("FOO");
        NaiveSingleton anotherSingleton = NaiveSingleton.getInstance("BAR");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);

        printDesignPatternEnd(SINGLETON);
    }

    private static void commandDesignDemo() {
        printDesignPatternStart(COMMAND);

        //Initialize receiver
        MarketTransaction transaction = new MarketTransaction("BNPP stock", 10);
        //Create commands
        Buy buyOrder = new Buy(transaction);
        Sell sellOrder = new Sell(transaction);
        //Create sender
        Broker broker = new Broker();
        broker.takeOrder(buyOrder);
        broker.takeOrder(sellOrder);
        broker.placeOrders();

        printDesignPatternEnd(COMMAND);
    }

    private static void chainOfResponsibilityDesignDemo() {
        printDesignPatternStart(CHAIN_OF_RESPONSIBILITY);
        initCORServer();
        String userOne = "admin@example.com";
        String passOne = "admin_pass";

        String userTwo = "test@nomail.org";
        String passTwo = "no_pass";

        System.out.println("Check " + userOne + "/" + passOne + "\n");
        server.logIn(userOne, passOne);
        System.out.println("Check " + userTwo + "/" + passTwo + "\n");
        server.logIn(userTwo, passTwo);

        printDesignPatternEnd(CHAIN_OF_RESPONSIBILITY);
    }

    private static void builderDesignDemo() {
        printDesignPatternStart(BUILDER);

        BankAccount account = new BankAccount.Builder(1234L)
                .withOwner("Victor")
                .atBranch("BRD")
                .openingBalance(0)
                .atRate(2.5)
                .build();
        System.out.println(account);

        //Because of the design we can miss fields
        BankAccount anotherAccount = new BankAccount.Builder(4567L)
                .withOwner("Gabriel")
                //.atBranch("BNPP")
                .openingBalance(100)
                //.atRate(2.5)
                .build();
        System.out.println(anotherAccount);

        printDesignPatternEnd(BUILDER);
    }

    private static void bridgeDesignDemo() {
        printDesignPatternStart(BRIDGE);

        AbstractShape redCircle = new Circle(10, 10, 2, new RedCircle());
        AbstractShape greenCircle = new Circle(10, 10, 2, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();

        printDesignPatternEnd(BRIDGE);
    }

    private static void factoryDesignDemo() {
        printDesignPatternStart(FACTORY);

        ShapeFactory factory = new ShapeFactory();

        Shape circle = factory.createShape("CIRCLE");
        Shape rectangle = factory.createShape("RECTANGLE");
        Shape square = factory.createShape("SQUARE");

        circle.whoAmI();
        rectangle.whoAmI();
        square.whoAmI();

        printDesignPatternEnd(FACTORY);
    }

    public static void printDesignPatternStart(String designName) {
        System.out.println("=== START " + designName + " DEMO ===");
    }

    public static void printDesignPatternEnd(String designName) {
        System.out.println("=== END " + designName + " DEMO ===\n");
    }
}
