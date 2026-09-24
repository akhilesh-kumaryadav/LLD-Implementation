package FileSystem.Solution;

// Step 2: Leaf -> File
public class File implements FileSystemComponent {
    String fileName;

    public File(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void printContents() {
        System.out.println(" - File name: " + fileName);
    }
}