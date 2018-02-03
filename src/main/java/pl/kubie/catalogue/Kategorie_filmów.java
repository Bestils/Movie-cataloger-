package pl.kubie.catalogue;

/**
 * Created by Gladus on 03.02.2018.
 */
public enum Kategorie_Movieów {
    Dramat(1),
    Komedia(2),
    Romans(3),
    Akcji(4),
    Thriler(5),
    Dokumentalny(6),
    Fantasy(7),
    Kriminał(8),
    Psychologiczny(9),
    Przygodowy(10),
    Rodzinny(11);
public int ValueNumber;
    Kategorie_Movieów(int ValueNumber){
        this.ValueNumber=ValueNumber;
    }
}
