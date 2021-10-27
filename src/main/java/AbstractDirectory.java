import java.util.Collection;

public abstract class AbstractDirectory {

    private AbstractStorage parentStorage;//skladiste kome direktorijum pripada
    private AbstractDirectory parentDirectory;//direktorijum u kom se ovaj direktorijum nalazi. Ukoliko se nalazi direktno u skladistu(nije ugnjezden u neki drugi dir) ovo polje je null
    private Collection<AbstractFile> files;
    private int maxFileNumber;

    public AbstractDirectory(AbstractStorage parentStorage, AbstractDirectory parentDirectory, Collection<AbstractFile> files) {
        this.parentStorage = parentStorage;
        this.parentDirectory = parentDirectory;
        this.files = files;
        this.maxFileNumber = Integer.MAX_VALUE;
    }

    public AbstractStorage getParentStorage() {
        return parentStorage;
    }

    public void setParentStorage(AbstractStorage parentStorage) {
        this.parentStorage = parentStorage;
    }

    public AbstractDirectory getParentDirectory() {
        return parentDirectory;
    }

    public void setParentDirectory(AbstractDirectory parentDirectory) {
        this.parentDirectory = parentDirectory;
    }

    public Collection<AbstractFile> getFiles() {
        return files;
    }

    public void setFiles(Collection<AbstractFile> files) {
        this.files = files;
    }

    public int getMaxFileNumber() {
        return maxFileNumber;
    }

    public void setMaxFileNumber(int maxFileNumber) {
        this.maxFileNumber = maxFileNumber;
    }
}
