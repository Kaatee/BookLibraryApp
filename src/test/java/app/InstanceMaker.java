package app;

import model.*;

public class InstanceMaker {
    private static InstanceMaker instance;
    private static Book[] exceptedBooksList;

    private InstanceMaker(){}

    /**
     * prepare tests instances for deserializer
     * @return
     */
    public static synchronized InstanceMaker getInstance(){
        if(instance==null) {
            instance = new InstanceMaker();
            IndustryIdentifiers indIdent11 = new IndustryIdentifiers("9788324677658");
            IndustryIdentifiers indIdent12 = new IndustryIdentifiers("8324677658");
            IndustryIdentifiers[] indIdenList1 = {indIdent11, indIdent12};
            ImageLinks imageLinks1 = new ImageLinks("http://books.google.com/books/content?id=mVNjAgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api");
            String[] authors1 = {"Cay S. Horstmann", "Gary Cornell"};
            String[] categories1 = {"Java", "Computers", "Test"};
            VolumeInfo vi1 = new VolumeInfo("Java. Techniki zaawansowane. Wydanie IX", null, "Helion", "2013-12-09", "Dziewiąte ...",
                    indIdenList1, 992, imageLinks1, "pl", "http://books.google.pl/books?id=mVNjAgAAQBAJ&printsec=frontcover&dq=java&hl=&cd=5&source=gbs_api",
                    3.0, authors1, categories1);
            Book book1 = new Book(vi1);


            IndustryIdentifiers indIdent21 = new IndustryIdentifiers("0131002872");
            IndustryIdentifiers indIdent22 = new IndustryIdentifiers("9780131002876");
            IndustryIdentifiers[] indIdenList2 = {indIdent21, indIdent22};
            ImageLinks imageLinks2 = new ImageLinks("http://books.google.com/books/content?id=Ql6QgWf6i7cC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api");
            String[] authors2 = {"Bruce Eckel"};
            String[] categories2 = {"Computers", "Java"};
            VolumeInfo vi2 = new VolumeInfo("Thinking in Java", null, "Prentice Hall Professional", "2003", "An overview of the programming language's fundamentals covers syntax, initialization, implementation, classes, error handling, objects, applets, multiple threads, projects, and network programming.",
                    indIdenList2, 1119, imageLinks2, "en", "http://books.google.pl/books?id=Ql6QgWf6i7cC&printsec=frontcover&dq=java&hl=&cd=7&source=gbs_api",
                    4.0, authors2, categories2);
            Book book2 = new Book(vi2);


            IndustryIdentifiers indIdent31 = new IndustryIdentifiers("9781592432172");
            IndustryIdentifiers indIdent32 = new IndustryIdentifiers("1592432174");
            IndustryIdentifiers[] indIdenList3 = {indIdent31, indIdent32};
            ImageLinks imageLinks3 = new ImageLinks("http://books.google.com/books/content?id=7tkN1CYzn2cC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api");
            String[] authors3 = {"Bruce Eckel"};
            String[] categories3 = {"Computers"};
            VolumeInfo vi3 = new VolumeInfo("A Hypervista of the Java Landscape", null, "InfoStrategist.com", null, null,
                    indIdenList3, null, imageLinks3, "en", "http://books.google.pl/books?id=7tkN1CYzn2cC&pg=PP1&dq=java&hl=&cd=1&source=gbs_api",
                    3.5, authors3, categories3);
            Book book3 = new Book(vi3);


            IndustryIdentifiers indIdent41 = new IndustryIdentifiers("1234");
            IndustryIdentifiers indIdent42 = new IndustryIdentifiers("2345");
            IndustryIdentifiers[] indIdenList4 = {indIdent41, indIdent42};
            //ImageLinks imageLinks4 = new ImageLinks(null);
            ImageLinks imageLinks4 = null;
            String[] authors4 = {"Gary Cornell"};
            VolumeInfo vi4 = new VolumeInfo("Test Title", null, null, null, null,
                    indIdenList4, null, imageLinks4, null, null,
                    null, authors4, null);
            Book book4 = new Book(vi4);

            instance.exceptedBooksList = new Book[]{book1, book2, book3, book4};

            return instance;
        }
        return instance;
    }


    /**
     * @return exceptedBooksList
     */
    public static Book[] getExceptedBooksList() {
        return exceptedBooksList;
    }
}
