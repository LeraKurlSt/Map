public class Main {
    public static void main(String[] args) {
        Contacts contact1 = new Contacts("Arina");
        try {
            contact1.addNewNumber(111, "work");
            contact1.addNewNumber(222, "home");
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }

        Contacts contact2 = new Contacts("Sunshine");
        try {
            contact2.addNewNumber(333, "work");
            contact2.addNewNumber(444, "mobile");
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }

        Contacts contact3 = new Contacts("Roma");
        try {
            contact3.addNewNumber(555, "mobile");
            contact3.addNewNumber(666, "home");
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }


        System.out.println("Contact book: ");
        Repository.printRepository();
        System.out.println("---------------------------------------------------------------");


        Repository.showContactNumber(555);
        System.out.println("---------------------------------------------------------------");

        Repository.showContactByName("Arina");
        System.out.println("---------------------------------------------------------------");

        Repository.showContactNumber(565);
        System.out.println("---------------------------------------------------------------");

        Repository.showContactByName("Lera");

    }
}
