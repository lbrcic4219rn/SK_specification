import java.util.Collection;
import java.util.Date;
import java.util.Map;
//ideja je da jedan isti user za neko skladiste moze da bude admin a za neko drugo da ima drugi nivo privilegije; znaci da svaki user moze imati pristup ka vise skladista i za svako
//se zna koji je njegov nivo privilegije-> zbog toga su ovoj klasi metode i za READ, DOWNLOAD, UPLOAD, DELETE, ADMIN nivo privilegije.
public abstract class AbstractUser {

    private String userName;
    private String password;
    private Map<AbstractStorage, Privilege> storagesAndPrivileges;// spisak skladista kojima user ima pristup i nivo pristupa za svako skladiste

    public AbstractUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    //Prepraviti parametre i povratne vrednosti
    //Za svaku operaciju mora se definisati nad kojim skladistem se izvrsava!!!
    //Kada se zna na koje skladiste se odredjena operacija odnosi, mora da se proveri da li user koji zeli da izvrsi tu operaciju ima dovoljan nivo privilegije za
    //tu operaciju nad tim skladistem!!!
    public abstract void initStorage(String storageName, String rootLocation);
    public abstract void saveStorageData();// cuvanje vrednosti polja ove klase u nekom fajlu kako bi u sledecem pokretanju programa mogli da ih ponovo setujemo
    public abstract void createDir(String dirName, String path);
    public abstract void createDir(String dirName, String path, String namePrefix, int numberOfFiles);
    public abstract void createFile(String fileName, String path);
    public abstract void move(Collection<String> files, String path);
    public abstract void move(String file, String path);
    public abstract void delete(String path);
    public abstract void download(String path);
    public abstract Collection<String> searchFilesInDir(String dirPath);
    public abstract Collection<String> searchDirsInDir(String dirPath);
    public abstract Collection<String> searchByName(String fileName);
    public abstract Collection<String> searchByExtension(String extension);
    public abstract Collection<String> searchByNameSorted(String fileName);
    public abstract Date getModificationDate(String path);
    public abstract Date getCreationDate(String path);
    public abstract Collection<String> searchByDateCreationRange(Date start, Date end);
    public abstract Collection<String> searchFilesInDirByDateCreationRange(Date start, Date end, String dirPath);

    //adminove metode
    public abstract void setStorageSize(int bytes, AbstractStorage storage);
    public abstract void setForbiddenExtensions(Collection<String> extensions, AbstractStorage storage);
    public abstract void setMaxFileNumberInDir(int number, AbstractStorage storage, AbstractDirectory directory);
    public abstract void addUser(AbstractUser user, AbstractStorage storage, Privilege privilege);
    public abstract void removeUser(AbstractUser user, AbstractStorage storage);

    //Mozda je bolje obrnuti kompletnu logiku. Umesto da user ima mapu skladista, skladiste moze da ima mapu usera!? Isto ostaje ideja da jedan user ima razlicite uloge u
    // razlicitim skladistima, samo da se menja nacin upravljanja skladistima. Da skladiste cuva informaciju o tome ko njime moze kako da upravlja?
    // Da li ta informacija moze da se cuva na obe strane-> i da skladiste ima mapu usera i da user ima mapu skladista? Da li to ima smisla?

}
