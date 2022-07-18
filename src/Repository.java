import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class Repository {
    private static HashMap<Integer, Contacts> InRepository = new HashMap<>();
    private static HashMap<String, Integer> contactsRepository = new HashMap<>();

    public static HashMap<Integer, Contacts> getInRepository(){
        return InRepository;
    }

    public static boolean AlreadyExist(int phoneNumber){
        return InRepository.containsKey(phoneNumber);
    }

    public static void addNewContact(int phoneNumber, @NotNull Contacts contact) throws Exception{
        if (InRepository.containsKey(phoneNumber)){
            throw new Exception("This number is already exist");
        }
        InRepository.put(phoneNumber, contact);
        contactsRepository.put(contact.getName(), phoneNumber);
    }

    @NonCLI
    public static Contacts searchByPhoneNumber(int phoneNumber) throws Exception{
        if (!InRepository.containsKey(phoneNumber)){
            throw new Exception("The number " + phoneNumber + " is not found");
        }
        return InRepository.get(phoneNumber);
    }

    @NonCLI
    public static Contacts searchByName(@NotNull String name) throws Exception{
        if (!contactsRepository.containsKey(name)){
            throw new Exception("The name" + name + " is not found");
        }
        int phoneNumber = contactsRepository.get(name);
        return searchByPhoneNumber(phoneNumber);
    }

    public static void showContactNumber(int phoneNumber){
        Contacts person = null;
        try {
            person = Repository.searchByPhoneNumber(phoneNumber);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        if (person != null){
            System.out.println("The contact Number " + phoneNumber + " belongs to " + person.getName());
        }
    }

    public static void showContactByName(String name){
        Contacts person = null;
        try {
            person = searchByName(name);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        if (person != null){
            System.out.println(person.getContactInfo());
        }
    }

    public static void printRepository(){
        getInRepository().values()
                .stream()
                .distinct()
                .toList()
                .stream().sorted()
                .forEach(r -> System.out.println(r.getContactInfo()));

    }
}
