package learn.mutumju.ch01recall;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

/**
 * Allows the creation of files and folders that are guaranteed to be deleted when the test method finishes.
 */
public class TemporaryFolderRuleTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testUsingTempFolder1() throws IOException {
        File createdFile = folder.newFile("file1.txt");
        File createdFolder = folder.newFolder("folder1");
        System.out.println("createdFile.exists(): " + createdFile.exists());
        System.out.println("createdFolder.exists(): " + createdFolder.exists());
    }

    @Test
    public void testUsingTempFolder2() throws IOException {
        File createdFile = folder.newFile("file2.txt");
        File createdFolder = folder.newFolder("folder2");
        System.out.println("createdFile.exists(): " + createdFile.exists());
        System.out.println("createdFolder.exists(): " + createdFolder.exists());
    }
}
