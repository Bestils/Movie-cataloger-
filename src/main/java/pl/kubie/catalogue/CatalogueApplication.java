package pl.kubie.catalogue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;


public class CatalogueApplication {

	static Scanner sc = new Scanner(System.in);

	static Filmy Filmy= new Filmy();

	public static void main(String[] args) {

		//MENU
		String  wyborUzytkownika;
		boolean poprawny;
		do {
			//WYŚWIETLENIE POZYCJI MENU
			System.out.println("#############################################################");
			System.out.println("#                                                           #");
			System.out.println("#                        ***MENU***                         #");
			System.out.println("#                                                           #");
			System.out.println("#############################################################");
			System.out.println("[1] Dodaj Film");
			System.out.println("[2] Wypisz wszystkie filmy");
			System.out.println("[3] Oceń film");
			System.out.println("[4] Zamknij program" + "\n");

			//POBRANIE OPCJI OD UŻYTKOWNIKA
			System.out.println("Wybierz opcję i zatwierdź klawiszem ENTER");
			wyborUzytkownika = (getUserInput());
switch (wyborUzytkownika){


			case 1:	 {
				//DODAJ Film DO KOLEKCJI
				dodajFilm();

			}case 2: {
				//WYŚWIETL FilmY
				Filmy.wyswietlFilmy();}

				//WYBIERZ Film Z LISTY
				System.out.println("Wybierz numer Film, który ma się Wyświetlić i zatwierdź klawiszem ENTER");
				int numerFilm;
				do {
					numerFilm = Integer.parseInt(getUserInput());
					if (numerFilm >= 0 && numerFilm < Film.Filmy.size()) {
						poprawny = true;

						//PRZEDSTAW Film
						Filmy.Wyświetl(numerFilm);
					} else {
						System.out.println("Błędny numer Film! Podajnumer ponownie.");
						poprawny = false;
					}
				}
				while (!poprawny); //WALIDUJ WYBÓR

			}case 4:  {
				System.out.print("Zamykam program...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.exit(0);
			}

		} while (wyborUzytkownika != "3");
	}


	private static void dodajFilm() {
		Film Film = new Film();

		System.out.println("#############################################################");
		System.out.println("#                                                           #");
		System.out.println("#                   ***DODAWANIE Filmu***                    #");
		System.out.println("#                                                           #");
		System.out.println("#############################################################");

		//Film
		System.out.print("Podaj Tytół Filmu: ");
		Film.setmovietitle(getUserInput());



		//Ocena
		Pattern wzóroceny = Pattern.compile("[0-9]?");
		String  OcenaPobrana;
		do {
			System.out.print("Podaj Ocene Film: ");
			OcenaPobrana = getUserInput();

			if (wzóroceny.matcher(OcenaPobrana).matches()) {
				Film.Setocena(Float.valueOf(OcenaPobrana));
			}
		} while (Film.getOcena() == null);

		//Gatunek Filmu
		System.out.print("Podaj Jaki to gatunek  Filmu: ");
		Film.SetType(getUserInput());

		Filmy.dodajFilm(Film);
	}

	public static String getUserInput() {
		return sc.nextLine().trim();
	}


}