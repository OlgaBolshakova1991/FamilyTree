import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler {
    private static final String DEFAULT_FILENAME = "person.txt";

    public static void saveFamilyTreeToFile(FamilyTree familyTree, String filename) {
        try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOut.writeObject(familyTree);
            System.out.println("Семейное дерево сохранено в файл: " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении семейного дерева: " + e.getMessage());
        }
    }

    public static FamilyTree loadFamilyTreeFromFile(String filename) {
        try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(filename))) {
            FamilyTree loadedFamilyTree = (FamilyTree) objectIn.readObject();
            System.out.println("Семейное дерево загружено из файла: " + filename);
            return loadedFamilyTree;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке семейного дерева: " + e.getMessage());
            return null;
        }
    }
    public void saveFamilyTreeToFile(FamilyTree familyTree) {
        saveFamilyTreeToFile(familyTree, DEFAULT_FILENAME);
    }

    public FamilyTree loadFamilyTreeFromFile() {
        return loadFamilyTreeFromFile(DEFAULT_FILENAME);
    }
}
