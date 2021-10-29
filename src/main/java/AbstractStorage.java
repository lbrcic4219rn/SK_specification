import java.util.Collection;
import java.util.Date;

public abstract class AbstractStorage {

    private String storageName;
    private AbstractUser admin;//administrator skladista
    private String rootLocation;// lokacija na racunaru(ili google drajvu) gde se nalazi direktorijum koji predstavlja ovo skladiste
    private Collection<AbstractDirectory> directories;//kolekcija svih direktorijuma u ovom skladistu
    private Collection<AbstractUser> users;

    public AbstractStorage(String storageName, AbstractUser admin, String rootLocation, Collection<AbstractDirectory> dirs, Collection<AbstractUser> users) {
        this.storageName = storageName;
        this.admin = admin;
        this.rootLocation = rootLocation;
        this.directories = dirs;
        this.users = users;
    }

    public void addDirectory(AbstractDirectory dir){
        this.directories.add(dir);
    }
    public void removeDirectory(AbstractDirectory dir){
        this.directories.remove(dir);
    }
    public void cleanStorage(){
        this.directories.clear();
    }

    public AbstractUser getAdmin() {
        return admin;
    }

    public String getRootLocation() {
        return rootLocation;
    }

    public Collection<AbstractDirectory> getDirectories() {
        return directories;
    }

}
