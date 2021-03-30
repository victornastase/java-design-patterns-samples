package com.java.learn.design.patterns;

import com.java.learn.design.patterns.behavioral.chainofresponsibility.*;
import com.java.learn.design.patterns.behavioral.command.Broker;
import com.java.learn.design.patterns.behavioral.command.Buy;
import com.java.learn.design.patterns.behavioral.command.MarketTransaction;
import com.java.learn.design.patterns.behavioral.command.Sell;
import com.java.learn.design.patterns.behavioral.iterator.NamesRepository;
import com.java.learn.design.patterns.behavioral.mediator.ChatMediator;
import com.java.learn.design.patterns.behavioral.mediator.ChatMediatorContext;
import com.java.learn.design.patterns.behavioral.mediator.ChatUser;
import com.java.learn.design.patterns.behavioral.mediator.User;
import com.java.learn.design.patterns.behavioral.memento.EmployeeCaretaker;
import com.java.learn.design.patterns.behavioral.memento.EmployeeMemento;
import com.java.learn.design.patterns.behavioral.memento.EmployeePerson;
import com.java.learn.design.patterns.behavioral.observer.Editor;
import com.java.learn.design.patterns.behavioral.observer.EmailNotificationListener;
import com.java.learn.design.patterns.behavioral.observer.LogOpenListener;
import com.java.learn.design.patterns.behavioral.state.AlertContext;
import com.java.learn.design.patterns.behavioral.state.Silent;
import com.java.learn.design.patterns.behavioral.strategy.AddOperation;
import com.java.learn.design.patterns.behavioral.strategy.MathContext;
import com.java.learn.design.patterns.behavioral.strategy.MultiplyOperation;
import com.java.learn.design.patterns.behavioral.strategy.SubstractOperation;
import com.java.learn.design.patterns.behavioral.template.Facebook;
import com.java.learn.design.patterns.behavioral.template.Network;
import com.java.learn.design.patterns.behavioral.template.Twitter;
import com.java.learn.design.patterns.behavioral.visitor.*;
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
import com.java.learn.design.patterns.structural.decorator.*;
import com.java.learn.design.patterns.structural.facade.FrontDeskFacade;
import com.java.learn.design.patterns.structural.flyweight.CoffeeFactory;
import com.java.learn.design.patterns.structural.flyweight.CoffeeFlavour;
import com.java.learn.design.patterns.structural.flyweight.CoffeeLatteArt;
import com.java.learn.design.patterns.structural.flyweight.CoffeeShop;
import com.java.learn.design.patterns.structural.proxy.ThirdPartyYouTube;
import com.java.learn.design.patterns.structural.proxy.YouTubeCacheProxy;
import com.java.learn.design.patterns.structural.proxy.YouTubeDownloader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
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
    private static final String FACADE = "Facade";
    private static final String DECORATOR = "Decorator";
    private static final String FLYWEIGHT = "Flyweight";
    private static final String ITERATOR = "Iterator";
    private static final String OBSERVER = "Observer";
    private static final String STATE = "State";
    private static final String STRATEGY = "Strategy";
    private static final String MEDIATOR = "Mediator";
    private static final String MEMENTO = "Memento";
    private static final String VISITOR = "Visitor";
    private static final String TEMPLATE = "Template";

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

    public static void main(String[] args) throws IOException {
        factoryDesignDemo();

        bridgeDesignDemo();

        builderDesignDemo();

        chainOfResponsibilityDesignDemo();

        commandDesignDemo();

        singletonDesignDemo();

        prototypeDesignDemo();

        compositeDesignDemo();

        //TODO: uncomment only when you want to learn about Proxy Design Pattern; slows down the execution.
        //proxyDesignDemo();

        facadeDesignDemo();

        decoratorDesignDemo();

        flyweightDesignDemo();

        iteratorDesignDemo();

        observerDesignDemo();

        stateDesignDemo();

        strategyDesignDemo();

        mediatorDesignDemo();

        mementoDesignDemo();

        visitorDesignDemo();

        //TODO: uncomment only when you want to learn about Template Design Pattern; slows down the execution.
        //templateDesignDemo();
    }

    private static void templateDesignDemo() throws IOException {
        printDesignPatternStart(TEMPLATE);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Network network = null;
        System.out.print("Input user name: ");
        String userName = reader.readLine();
        System.out.print("Input password: ");
        String password = reader.readLine();

        // Enter the message.
        System.out.print("Input message: ");
        String message = reader.readLine();

        System.out.println("\nChoose social network for posting message.\n" +
                "1 - Facebook\n" +
                "2 - Twitter");
        int choice = Integer.parseInt(reader.readLine());

        // Create proper network object and send the message.
        if (choice == 1) {
            network = new Facebook(userName, password);
        } else if (choice == 2) {
            network = new Twitter(userName, password);
        }
        network.post(message);

        printDesignPatternEnd(TEMPLATE);
    }

    private static void visitorDesignDemo() {
        printDesignPatternStart(VISITOR);

        VisitorDot dot = new VisitorDot(1, 10, 55);
        VisitorCircle circle = new VisitorCircle(2, 23, 15, 10);
        VisitorRectangle rectangle = new VisitorRectangle(3, 10, 17, 20, 30);

        CompoundShape compoundShape = new CompoundShape(4);
        compoundShape.add(dot);
        compoundShape.add(circle);
        compoundShape.add(rectangle);

        CompoundShape c = new CompoundShape(5);
        c.add(dot);
        compoundShape.add(c);

        export(circle, compoundShape);

        printDesignPatternEnd(VISITOR);
    }

    private static void export(VisitorShape... shapes) {
        XMLExportVisitor exportVisitor = new XMLExportVisitor();
        System.out.println(exportVisitor.export(shapes));
    }

    private static void mementoDesignDemo() {
        printDesignPatternStart(MEMENTO);

        EmployeeCaretaker caretaker = new EmployeeCaretaker();
        System.out.println("creating employee objects with intial values");
        EmployeePerson racheal = new EmployeePerson(100);
        racheal.setName("Racheal");
        racheal.setDesignation("Lead");
        racheal.setSalary(100000);
        racheal.setDepartment("R&D");
        racheal.setProject("Transportation Management");
        EmployeePerson micheal = new EmployeePerson(101);
        micheal.setName("Micheal");
        micheal.setDesignation("Developer");
        micheal.setSalary(75000);
        micheal.setDepartment("Engineering");
        micheal.setProject("IoT");
        System.out.println(racheal);
        System.out.println(micheal);

        EmployeeMemento rachealMemento = racheal.createMemento();
        EmployeeMemento michealMemento = micheal.createMemento();

        caretaker.addMemento(racheal.getEmpId(), "Saved at intitial stage", rachealMemento);
        caretaker.addMemento(micheal.getEmpId(), "Saved at intitial stage", michealMemento);

        System.out.println("\nracheal got promotion");
        racheal.setDesignation("Manager");
        racheal.setSalary(120000);
        System.out.println("micheal assigned to another project.");
        micheal.setProject("Android App");
        System.out.println(racheal);
        System.out.println(micheal);
        rachealMemento = racheal.createMemento();
        michealMemento = micheal.createMemento();

        caretaker.addMemento(racheal.getEmpId(), "Saved at promotion", rachealMemento);
        caretaker.addMemento(micheal.getEmpId(), "Saved at android project", michealMemento);

        System.out.println("\nracheal got increment");
        racheal.setSalary(140000);
        System.out.println("micheal got promotion");
        micheal.setDesignation("Lead Developer");
        micheal.setSalary(90000);
        System.out.println(racheal);
        System.out.println(micheal);
        rachealMemento = racheal.createMemento();
        michealMemento = micheal.createMemento();
        caretaker.addMemento(racheal.getEmpId(), "Saved at increment", rachealMemento);
        caretaker.addMemento(micheal.getEmpId(), "Saved at promotion", michealMemento);
        System.out.println("\nLet's print the stored memento objects we have");
        caretaker.printStoredMementoObjects();

        System.out.println("\nnow for some reason, we like to revert racheal to initial stage.");
        System.out.println("and micheal to android project.");
        rachealMemento = caretaker.getMemento(racheal.getEmpId(), "Saved at intitial stage");
        michealMemento = caretaker.getMemento(micheal.getEmpId(), "Saved at android project");
        racheal.restore(rachealMemento);
        micheal.restore(michealMemento);
        System.out.println(racheal);
        System.out.println(micheal);

        printDesignPatternEnd(MEMENTO);
    }

    private static void mediatorDesignDemo() {
        printDesignPatternStart(MEDIATOR);

        ChatMediator mediator = new ChatMediatorContext();
        User user1 = new ChatUser(mediator, "Pankaj");
        User user2 = new ChatUser(mediator, "Lisa");
        User user3 = new ChatUser(mediator, "Saurabh");
        User user4 = new ChatUser(mediator, "David");
        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);

        user1.send("Hi all!");

        printDesignPatternEnd(MEDIATOR);
    }

    private static void strategyDesignDemo() {
        printDesignPatternStart(STRATEGY);

        MathContext context = new MathContext(new AddOperation());
        System.out.println("10 + 5 = " + context.executeOperation(10, 5));

        context = new MathContext(new SubstractOperation());
        System.out.println("10 - 5 = " + context.executeOperation(10, 5));

        context = new MathContext(new MultiplyOperation());
        System.out.println("10 * 5 = " + context.executeOperation(10, 5));

        printDesignPatternEnd(STRATEGY);
    }

    private static void stateDesignDemo() {
        printDesignPatternStart(STATE);

        AlertContext context = new AlertContext();
        context.alert();
        context.alert();
        context.setCurrentState(new Silent());
        context.alert();

        printDesignPatternEnd(STATE);
    }

    private static void observerDesignDemo() {
        printDesignPatternStart(OBSERVER);

        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@test.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        printDesignPatternEnd(OBSERVER);
    }

    private static void iteratorDesignDemo() {
        printDesignPatternStart(ITERATOR);

        NamesRepository repo = new NamesRepository();
        Iterator<String> repoIterator = repo.getIterator();
        while(repoIterator.hasNext()) {
            System.out.println(repoIterator.next());
        }
        System.out.println("Same result but using for-each loop");
        String[] names = repo.names;
        for(String name : names) {
            System.out.println(name);
        }

        printDesignPatternEnd(ITERATOR);
    }

    private static void flyweightDesignDemo() {
        printDesignPatternStart(FLYWEIGHT);

        CoffeeShop shop = new CoffeeShop();

        shop.takeOrder(CoffeeFlavour.CAPPUCCINO, CoffeeLatteArt.BARISTA_SWAG, 5);
        shop.takeOrder(CoffeeFlavour.AFFOGATO, CoffeeLatteArt.FRENCH, 7);
        shop.takeOrder(CoffeeFlavour.ESPRESSO, CoffeeLatteArt.FISHBONE, 1);
        shop.takeOrder(CoffeeFlavour.LATTE, CoffeeLatteArt.DISNEY, 3);
        shop.takeOrder(CoffeeFlavour.CAPPUCCINO, CoffeeLatteArt.CAT, 2);
        shop.takeOrder(CoffeeFlavour.ESPRESSO, CoffeeLatteArt.FISHBONE, 8);
        shop.takeOrder(CoffeeFlavour.AFFOGATO, CoffeeLatteArt.BARISTA_SWAG, 4);
        shop.takeOrder(CoffeeFlavour.CAPPUCCINO, CoffeeLatteArt.DISNEY, 10);
        shop.takeOrder(CoffeeFlavour.LATTE, CoffeeLatteArt.LITTLE_BUNNY, 6);
        shop.takeOrder(CoffeeFlavour.FRAPPUCCINO, CoffeeLatteArt.DISNEY, 9);

        System.out.println("------------------------------------------------------------");
        System.out.println("Number of Order Objects: " + CoffeeShop.getNumberOfOrders());
        System.out.println("Number of Coffee Objects: " + CoffeeFactory.getNumberOfCoffee());

        printDesignPatternEnd(FLYWEIGHT);
    }

    private static void decoratorDesignDemo() throws FileNotFoundException {
        printDesignPatternStart(DECORATOR);

        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        DataSourceDecorator encoded = new CompressionDecorator(new EncryptionDecorator(new FileDataSource("out/OutputDecorator.txt")));

        encoded.writeData(salaryRecords);

        DataSource plain = new FileDataSource("out/OutputDecorator.txt");
        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());

        printDesignPatternEnd(DECORATOR);
    }

    private static void facadeDesignDemo() {
        printDesignPatternStart(FACADE);

        FrontDeskFacade frontDesk = new FrontDeskFacade();
        frontDesk.openAccount();
        frontDesk.emitCard();

        printDesignPatternEnd(FACADE);
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
