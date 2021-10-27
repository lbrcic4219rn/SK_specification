public enum Privilege {
    READ, DOWNLOAD, UPLOAD, DELETE, ADMIN;
    //Privilegije su poredjane hijerarhijski: najmanja privilegija koju user moze da ima je read. Ako neki user ima privilegiju download, automatski ima i privilegiju read
    //tj. ima pristup operacijama istog ili nizeg nivoa privilegije -> User sa admin privilegijom moze da izvrsava sve operacije
}
