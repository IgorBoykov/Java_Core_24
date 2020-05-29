package Task;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {

		Cinema cinema = new Cinema(new Time(10, 00), new Time(22, 00));

		Scanner sc = new Scanner(System.in);
		while (true) {
			menu();
			String str = sc.next();
			switch (str) {
			case "1":
				System.out.println("Введіть назву фільму:");
				String name = sc.next();
				System.out.println("Введіть скільки годин триває фільм:");
				int hour = sc.nextInt();
				System.out.println("Введіть скільки хвилин триває фільм:");
				int min = sc.nextInt();
				Time timeDuration = new Time(hour, min);
				Movie mov = new Movie(name, timeDuration);
				cinema.addMovie(mov);
				System.out.println("Фільм додано!");
				break;

			case "2":
				System.out.println("Ведіть індекс фільму з фільмотеки:");
				int index = sc.nextInt();
				System.out.println("Коли почати сеанс? год:");
				int hour2 = sc.nextInt();
				System.out.println("Коли почати сеанс? хв:");
				int min2 = sc.nextInt();
				System.out.println("В який день почати? (вводити англійською)?");
				String day = sc.next();
				Time startTime = new Time(hour2, min2);
				Seance seans = new Seance(cinema.moviesLibrary.get(index), startTime);
				cinema.addSeance(seans, day);
				System.out.println("Сеанс додано!");
				break;

			case "3":
				System.out.println("Введіть індекс фільму:");
				int index3 = sc.nextInt();
				cinema.removeMovie(cinema.moviesLibrary.get(index3));
				break;

			case "4":
				System.out.println("В який день необхідно видалити сеанс (вводити англійською)?");
				String day3 = sc.next();
				System.out.println("Сеанс видалено");
				break;

			case "5":
				System.out.println("Monday: " + cinema.schedules.get(Days.MONDAY));
				System.out.println("Tuesday: " + cinema.schedules.get(Days.TUESDAY));
				System.out.println("Wednesday: " + cinema.schedules.get(Days.WEDNESDAY));
				System.out.println("Thursday: " + cinema.schedules.get(Days.THURSDAY));
				System.out.println("Friday: " + cinema.schedules.get(Days.FRIDAY));
				System.out.println("Saturday: " + cinema.schedules.get(Days.SATURDAY));
				System.out.println("Sunday: " + cinema.schedules.get(Days.SUNDAY));
				break;

			case "0":
				System.exit(0);
			}
		}

	}

	private static void menu() {
		System.out.println("Введіть 1, щоб додати фільм у фільмотеку");
		System.out.println("Введіть 2, щоб додати сеанс в розклад на конкретний день");
		System.out.println("Введіть 3, щоб видалити фільм з фільмотеки");
		System.out.println("Введіть 4, щоб видалити сеанс в конкретний день");
		System.out.println("Введіть 5, щоб вивести розклад");
		System.out.println("Введіть 0, щоб вийти");
		System.out.println();

	}
}
