# Car rental 

## dokumentáció - asztali alkalmazás

## 2023

<!-- Lépjünk be az api könyvtárba:

```bash
cd api
```

El kell indítanunk a Hai-servert felületet:

```bash
hai-server --watch database.json
``` -->
## Futtatás

Fontos hogy a restapi szerver fusson,
enélkül nem fut az alkalmazás.

Lépjünk be az src könyvtárba:

```bash
cd src
```

Most le kell töltenünk a függőségeket, ha megvannak adjuk hozzá a függőségeket (Java projects => Referenced Libraries):

```bash
gson-2.10.1.jar,
junit-jupiter-api-5.9.1.jar,
junit-platform-console-standalone-1.9.1.jar,
javafx-sdk-20 :
    javafx.base.jar
    javafx.controls.jar
    javafx.fxml.jar
    javafx.graphics.jar
    javafx.media.jar
    javafx.properties
    javafx.swing.jar
    javafx.web.jar
    javafx-swt.jar
```

Hozzáadás után töltsük újra az ablakot a biztos indtítás édekében,
majd ezt követve futtasuk a programot.

## Szerkezet

Az asztali alkalmazás java, javafx

Három felület került megvalósításra:

LoginView - Bejelentkezési felület
MainView - Táblázat, autók adatainak módosítása
RegistryView - Új felhasználó felvétele

### Bejelentkezési felület

Ez a felület jelenik meg a program indításakor,
itt a program bekér egy email-t valamint egy jelszót,
ezek a code-ban vannak felütüntetve (IdandPass).
A bejelentkezés gombra kattinva tudunk tovább lépni,
hiteles adatok megadása után.

### Táblázat, regisztrációs felület

A bejelentkezés követően, elösször is megjelenik 
az autók ablak, mellette megtalálható a regisztrácíó fül.
Az autók fül egy táblázatot jelenít meg, ami tartalmazza az autók adatait,
ezek szerkeszthetők, törölhetők, valamint módunkban áll új autó felvétele,
ezt a táblázat alatt lévő beviteli mezők biztosítják.
Az id mezőn kívül minden mező szerkeszthető.

A regisztrációra kattintva, új felhasználót tudunk felvenni,
ehez meg kell adnunk a kért adatokat,
majd a regisztáció fülre kattintva, hiteles adatok megadása után
sikeresen felvettünk egy új felhasználót.

