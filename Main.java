import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Создаем объекты ребенка, родителей и семейного дерева
        Child child = new Child("Иван", LocalDate.of(2005, 3, 15), null, Gender.MALE);
        Parent father = new Parent("Петр", LocalDate.of(1975, 8, 20), null, Gender.MALE);
        Parent mother = new Parent("Анна", LocalDate.of(1980, 10, 10), null, Gender.FEMALE);
        
        FamilyTree familyTree = new FamilyTree();
        
        // Добавляем ребенка и родителей в семейное дерево
        familyTree.addFamilyMember(child);
        familyTree.addFamilyMember(father);
        familyTree.addFamilyMember(mother);
        

        Person foundPerson = familyTree.findFamilyMemberByName("Иван");
        if (foundPerson != null) {
            System.out.println("Найден: " + foundPerson.getName());
            System.out.println("Дата рождения: " + foundPerson.getDob()); 
            System.out.println("Дата смерти: " + foundPerson.getDod());
            System.out.println("Возраст: " + foundPerson.getAge());
            System.out.println("Пол: " + foundPerson.getGender());
        } 
        else {
            System.out.println("Такого члена семьи нет");
        }
    
        
        
        // Сохраняем семейное дерево в файл
        FileHandler.saveFamilyTreeToFile(familyTree, ("person.txt"));
        
        // Загружаем семейное дерево из файла
        FamilyTree loadedFamilyTree = FileHandler.loadFamilyTreeFromFile("person.txt");
        
        // Выводим информацию о загруженном семейном дереве
        if (loadedFamilyTree != null) {
            System.out.println("Загруженное семейное дерево содержит " + ((Object) loadedFamilyTree.getFamilyMembers().size()) + " членов семьи.");
        }
    }
}


