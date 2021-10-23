import java.util.Collection;
import java.util.Date;

public interface Storage {

    //storage operations
    public void initStorage(String storageName, String path);
    public void createDir(String dirName, String path);
    public void createDir(String dirName, String path, String namePrefix, int numberOfFiles);
    public void createFile(String fileName, String path);
    public void move(Collection<String> files, String path);
    public void move(String file, String path);
    public void delete(String path);
    public Collection<String> searchFilesInDir(String dirPath);
    public Collection<String> searchDirsInDir(String dirPath);
    public Collection<String> searchByName(String fileName);
    public Collection<String> searchByExtension(String extension);
    public Collection<String> searchByNameSorted(String fileName);
    public Date getModificationDate(String path);
    public Date getCreationDate(String path);
    public Collection<String> searchByDateCreationRange(Date start, Date end);
    public Collection<String> searchFilesInDirByDateCreationRange(Date start, Date end, String dirPath);
    public void download(String path);
    //admin operations:
    public void setStorageSize(int bytes);
    public void setForbiddenExtensions(Collection<String> extensions);
    public void setMaxFileNumberInDir(int number);
    public void addUser(Object object);
    public void removeUser(Object object);

}
