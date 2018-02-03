package pl.kubie.catalogue;
import java.util.Scanner;


public class CatalogueApplication {

	static Scanner NumberScanner = new Scanner(System.in);
	static Scanner StringScanner = new Scanner(System.in);

	static ShowMovieInfos ShowMovieInfos = new ShowMovieInfos();

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
			System.out.println("[1] Add Movie");
			System.out.println("[2] Show all  Movies");
			System.out.println("[3] Change Movie Rate");
			System.out.println("[4] Change Movie Category ");
			System.out.println("[5] Sort Movies By //niedziała");
			System.out.println("[6] Add Commentary to Movie//niedziała");
			System.out.println("[7] Delete Movie  ");
			System.out.println("[8] Close Program" + "\n");

			//POBRANIE OPCJI OD UŻYTKOWNIKA
			System.out.println("Wybierz opcję i zatwierdź klawiszem ENTER");
			wyborUzytkownika = (NumberScanner.nextInt());
			switch (wyborUzytkownika){


				case 1:	 {
					//DODAJ Movie DO KOLEKCJI
					CreateNewMovie();
				}
				break;
				case 2: {
					//WYŚWIETL Movies
					ShowMovieInfos.ShowMovies();

					//WYBIERZ Movie Z LISTY
					System.out.println("Wybierz numer Movie, który ma się Wyświetlić i zatwierdź klawiszem ENTER");
					Integer numerMovieu;
					do {
						numerMovieu = NumberScanner.nextInt();
						if (numerMovieu >= 0 && numerMovieu < ShowMovieInfos.Movies.size()) {
							poprawny = true;

							//PRZEDSTAW Movie
							ShowMovieInfos.ShowMovieInformations(numerMovieu);
						} else {
							System.out.println("Błędny numer Movie! Podajnumer ponownie.");
							poprawny = false;
						}
					}
					while (!poprawny); //WALIDUJ WYBÓR}}
				}
				break;
				case 3:{


					ShowMovieInfos.ShowMovies();
					System.out.println("Wybierz Movie jakiemu chcesz zmienić ocenę");
					ShowMovieInfos.SetRate(NumberScanner.nextInt());




				}
				case 4:{


					ShowMovieInfos.ShowMovies();
					System.out.println("Wybierz Movie jaki chcesz zmienić Kategorię");
					ShowMovieInfos.SetCategory(NumberScanner.nextInt());




				}
				break;
				case 5:{
					System.out.println("#############################################################");
					System.out.println("#                                                           #");
					System.out.println("#                 ***Wyszukaj Movie wedłóg***                #");
					System.out.println("#                                                           #");
					System.out.println("#############################################################");
					System.out.println("[1] Nazwy");
					System.out.println("[2] Kategori");
					System.out.println("[3] Oceny");


				}
				break;
				case 6:{





				}
				break;
				case 7:{
					ShowMovieInfos.ShowMovies();
					System.out.println("Wybierz Movie jaki chcesz usunąć");
					ShowMovieInfos.DeleteMovie(NumberScanner.nextInt());
				}break;
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


	private static void CreateNewMovie(){
		Movie JakiśMovie = new Movie();
		ShowMovieInfos.AddMovieToCollection(JakiśMovie);

		System.out.println("#############################################################");
		System.out.println("#                                                           #");
		System.out.println("#                   ***DODAWANIE Movieu***                   #");
		System.out.println("#                                                           #");
		System.out.println("#############################################################");

		String MovieTitle;

		System.out.print("Podaj Tytół Movieu: ");
		MovieTitle = StringScanner.nextLine();
		JakiśMovie.SetMovieTitle(MovieTitle);



		//Ocena
		ShowMovieInfos.SetRate(ShowMovieInfos.Movies.size() - 1);

		//Gatunek Movieu
		System.out.print("Podaj Jaki to gatunek  Movieu: ");
		ShowMovieInfos.SetCategory(ShowMovieInfos.Movies.size() - 1);


	}




}