package pl.kubie.catalogue;
import java.util.Scanner;
import java.util.regex.Pattern;


public class CatalogueApplication {

	static Scanner sc = new Scanner(System.in);

	static WypiszDaneOFilmie WypiszDaneOFilmie= new WypiszDaneOFilmie();

	public static void main(String[] args) {

		//MENU
		Integer  wyborUzytkownika;
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
			wyborUzytkownika = (sc.nextInt());
switch (wyborUzytkownika){


			case 1:	 {
				//DODAJ Film DO KOLEKCJI
				dodajFilm();
			}
			case 2: {
				//WYŚWIETL FilmY
		WypiszDaneOFilmie.wyswietlFilmy();}

				//WYBIERZ Film Z LISTY
				System.out.println("Wybierz numer Film, który ma się Wyświetlić i zatwierdź klawiszem ENTER");
				Integer numerFilmu;
				do {
					numerFilmu = Integer.parseInt(sc.nextLine());
					if (numerFilmu >= 0 && numerFilmu < WypiszDaneOFilmie.Filmy.size()) {
						poprawny = true;

						//PRZEDSTAW Film
						WypiszDaneOFilmie.wyswietlFilmy();
					} else {
						System.out.println("Błędny numer Film! Podajnumer ponownie.");
						poprawny = false;
					}
				}
				while (!poprawny); //WALIDUJ WYBÓR

			case 4:  {
				System.out.print("Zamykam program...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.exit(0);
			}


	}

		} while(true);
	}


		private static void dodajFilm(){
		Film Film = new Film();

		System.out.println("#############################################################");
		System.out.println("#                                                           #");
		System.out.println("#                   ***DODAWANIE Filmu***                    #");
		System.out.println("#                                                           #");
		System.out.println("#############################################################");

		//Film
		System.out.print("Podaj Tytół Filmu: ");
		Film.SetMovieTitle(sc.nextLine());



		//Ocena
		Pattern wzóroceny = Pattern.compile("[0-9]?");
		String  OcenaPobrana;
		do {
			System.out.print("Podaj Ocene Film: ");
			OcenaPobrana = sc.nextLine();

			if (wzóroceny.matcher(OcenaPobrana).matches()) {
				Film.SetMovieRate(Integer.valueOf(OcenaPobrana));
			}
		} while (Film.getRate() == null);

		//Gatunek Filmu
		System.out.print("Podaj Jaki to gatunek  Filmu: ");
		Film.SetMovieTitle(sc.nextLine());

			WypiszDaneOFilmie.dodajFilm(Film);
	}




}