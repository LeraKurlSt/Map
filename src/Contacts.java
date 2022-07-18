import java.util.HashMap;
import java.util.Map;

public class Contacts implements Comparable<Contacts>{

    @Override
    public int compareTo(Contacts o) {
        return this.getName().compareTo(o.getName());
    }

    private HashMap<Integer, String> contactsStorage = new HashMap<>();
    private String name;

    public Contacts(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void addNewNumber(int phoneNumber, String contactName) throws Exception{
        if (Repository.AlreadyExist(phoneNumber)){
            throw new Exception("This contact is already exist");
        }
        if (contactsStorage.containsKey(phoneNumber)){
            throw new Exception("This contact is already exist");
        }
        contactsStorage.put(phoneNumber, contactName);
        Repository.addNewContact(phoneNumber, this);
    }

    @Override
    public String toString(){
        return "Contact: name: " + name;
    }

    @NonCLI
    public String getContactInfo(){
        String s = toString();

        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer, String> phone:contactsStorage.entrySet()){
            stringBuilder.append("\n number:").append(phone.getKey()).append(" contactInfo:").append(phone.getValue());
        }
        if (!stringBuilder.isEmpty()){
//            stringBuilder.append("\n}");
            s += stringBuilder.toString();
        }
        return s;
    }
}
