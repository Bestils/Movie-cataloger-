package pl.kubie.catalogue;
import java.util.Scanner;
import java.util.regex.Pattern;


public class CatalogueApplication {

	static Scanner NumberScanner = new Scanner(System.in);
	static Scanner StringScanner = new Scanner(System.in);

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
			System.out.println("[3] Zmień Ocenę filmu");
			System.out.println("[4] Zmień Gatunek filmu //niedziała ");
			System.out.println("[5] Posortuj wedłóg //niedziała");
			System.out.println("[6] Dodaj komentarz do filmu //niedziała");
			System.out.println("[7] Usuń film //niedziała ");
			System.out.println("[8] Zamknij program" + "\n");

			//POBRANIE OPCJI OD UŻYTKOWNIKA
			System.out.println("Wybierz opcję i zatwierdź klawiszem ENTER");
			wyborUzytkownika = (NumberScanner.nextInt());
switch (wyborUzytkownika){


			case 1:	 {
				//DODAJ Film DO KOLEKCJI
				StwórzZapisZFilmem();
			}
			break;
			case 2: {
				//WYŚWIETL FilmY
				WypiszDaneOFilmie.wyswietlFilmy();

				//WYBIERZ Film Z LISTY
				System.out.println("Wybierz numer Film, który ma się Wyświetlić i zatwierdź klawiszem ENTER");
				Integer numerFilmu;
				do {
					numerFilmu = NumberScanner.nextInt();
					if (numerFilmu >= 0 && numerFilmu < WypiszDaneOFilmie.Filmy.size()) {
						poprawny = true;

						//PRZEDSTAW Film
						WypiszDaneOFilmie.przedstawSie(numerFilmu);
					} else {
						System.out.println("Błędny numer Film! Podajnumer ponownie.");
						poprawny = false;
					}
				}
				while (!poprawny); //WALIDUJ WYBÓR}}
			}
			break;
	case 3:{


		WypiszDaneOFilmie.wyswietlFilmy();
		System.out.println("Wybierz film jakiemu chcesz zmienić ocenę");
		WypiszDaneOFilmie.Ustawocenę(NumberScanner.nextInt());




	}
	case 4:{


		WypiszDaneOFilmie.wyswietlFilmy();
		System.out.println("Wybierz film jaki chcesz zmienić Kategorię");
		WypiszDaneOFilmie.Ustawocenę(NumberScanner.nextInt());




	}
	break;
			case 8:  {
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


		private static void StwórzZapisZFilmem(){
		Film JakiśFilm = new Film();


		System.out.println("#############################################################");
		System.out.println("#                                                           #");
		System.out.println("#                   ***DODAWANIE Filmu***                   #");
		System.out.println("#                                                           #");
		System.out.println("#############################################################");

		String MovieTitle;

		System.out.print("Podaj Tytół Filmu: ");
			MovieTitle = StringScanner.nextLine();
		JakiśFilm.SetMovieTitle(MovieTitle);



		//Ocena
		Pattern wzóroceny = Pattern.compile("[0-9]?");
		String  OcenaPobrana;
		do {
			System.out.print("Podaj Ocene Film 0-9: ");
			OcenaPobrana = StringScanner.nextLine();

			if (wzóroceny.matcher(OcenaPobrana).matches()) {
				JakiśFilm.SetMovieRate(Integer.valueOf(OcenaPobrana));
			}
		} while (JakiśFilm.getRate() == null);

		//Gatunek Filmu

		System.out.print("Podaj Jaki to gatunek  Filmu: ");
			String Gatunek = StringScanner.nextLine();
			JakiśFilm.SetMovieType(Gatunek);

			WypiszDaneOFilmie.dodajFilmDoKolekcji(JakiśFilm);
	}




}