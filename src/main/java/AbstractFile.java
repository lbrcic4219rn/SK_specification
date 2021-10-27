public abstract class AbstractFile {

    private AbstractDirectory parentDir;

    public AbstractFile(AbstractDirectory parentDir) {
        this.parentDir = parentDir;
    }

    public AbstractDirectory getParentDir() {
        return parentDir;
    }

    public void setParentDir(AbstractDirectory parentDir) {
        this.parentDir = parentDir;
    }

}
