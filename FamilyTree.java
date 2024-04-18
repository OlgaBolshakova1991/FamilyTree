import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Person> familyMembers;

    public FamilyTree() {
        familyMembers = new ArrayList<>();
    }

    public void addFamilyMember(Person person) {
        familyMembers.add(person);
    }

    public Person findFamilyMemberByName(String name) {
        for (Person person : familyMembers) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }
    
    public List<Person> getFamilyMembers() {
        return familyMembers;
    }
}
