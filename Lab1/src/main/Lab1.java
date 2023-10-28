package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Lab1 {
	private static Set<Integer> wybraneMiejsca = new HashSet<>();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Wprowadz dane klienta: ");
		Klient klient = wprowadzDaneKlienta(scanner);
		
		Set<Integer> dostepneMiejsca = new HashSet<>(przykladoweMiejsca());
		Set<Integer> zajeteMiejsca = new HashSet<>();
		List<Integer> wybraneMiejsca = wybierzMiejsca(scanner, dostepneMiejsca, zajeteMiejsca);
		
		klient.setMiejsce(wybraneMiejsca);
		
		Seans seans1 = new Seans("Java", "2023-10-14", "19:00", 16, wybraneMiejsca);
		Seans seans2 = new Seans("Cpp", "2023-10-14", "16:00", 14, wybraneMiejsca);
		
		List<Seans> dostepneSeanse = Arrays.asList(seans1, seans2);
		
		System.out.println("Dostepne seanse: ");
		for(int i = 0; i < dostepneSeanse.size(); i++) {
			System.out.println(i + 1 + ". " + dostepneSeanse.get(i).getTytul());
		}
		
		System.out.print("Wybierz numer seansu: ");
		int numerSeansu = scanner.nextInt();
		Seans wybranySeans = dostepneSeanse.get(numerSeansu - 1);
		
		System.out.println("Dostepne miejsca na seans: " + wybranySeans.getTytul() + ":");
		wyswietlMiejsca(dostepneMiejsca);
		
		klient.setSeans(wybranySeans);
		
		zapiszDaneDoPliku("klienci.dat", Collections.singletonList(klient));
		zapiszDaneDoPliku("seanse.dat", Collections.singletonList(seans1));
		
		
		Klient wczytanyKlient = (Klient) odczytajDaneZPliku("klienci.dat").get(0);
		Seans wczytanySeans = (Seans) odczytajDaneZPliku("seanse.dat").get(0);
		
		System.out.println("Wprowadzono dane klienta: ");
		System.out.println("1.Imie: " + wczytanyKlient.getImie());
		System.out.println("2.Nazwisko: " + wczytanyKlient.getNazwisko());
		System.out.println("3.Mail: " + wczytanyKlient.getMail());
		System.out.println("4.Telefon: " + wczytanyKlient.getTelefon());
		
		
		System.out.println("Dane seansu: ");
		System.out.println("1.Tytul: " + wczytanySeans.getTytul());
		System.out.println("2.Dzien: " + wczytanySeans.getDzien());
		System.out.println("3.Godzina: " + wczytanySeans.getGodzina());
		System.out.println("4.Ograniczenie wiekowe: " + wczytanySeans.getOgraniczenia());
		System.out.println("5.Miejsca: " + wczytanySeans.getMiejsca());
		
		scanner.close();
	}
	
	public static Set<Integer> przykladoweMiejsca() {
		Set<Integer> miejsca = new HashSet<>();
		miejsca.add(1);
		miejsca.add(2);
		miejsca.add(3);
		miejsca.add(4);
		miejsca.add(5);
		miejsca.add(6);
		miejsca.add(7);
		miejsca.add(8);
		miejsca.add(9);
		
		return miejsca;
	}
	
	public static void wyswietlMiejsca(Set<Integer> dostepneMiejsca) {
		System.out.println("Dostepne miejsca: ");
		for(Integer miejsce : dostepneMiejsca) {
			System.out.print(miejsce + " ");
		}
		System.out.println();
	}
	public static List<Integer> wybierzMiejsca(Scanner scanner, Set<Integer> dostepneMiejsca, Set<Integer> zajeteMiejsca) {
		List<Integer> wybraneMiejsca = new ArrayList<>();
		
		while(true) {
			System.out.print("Wybierz miejsce (0 - zakończ wybieranie): ");
			int numerMiejsca = scanner.nextInt();
			
			if(numerMiejsca == 0) {
				break;
			}
			
			if(dostepneMiejsca.contains(numerMiejsca) && !zajeteMiejsca.contains(numerMiejsca)) {
				wybraneMiejsca.add(numerMiejsca);
				zajeteMiejsca.add(numerMiejsca);
			} else {
				System.out.println("Miejsce jest zajete!");
			}
		}
		return wybraneMiejsca;
	}
	
	public static Klient wprowadzDaneKlienta(Scanner scanner) {
		System.out.print("Imie: ");
		String imie = scanner.nextLine();
		System.out.print("Nazwisko: ");
		String nazwisko = scanner.nextLine();
		System.out.print("Mail: ");
		String mail = scanner.nextLine();
		System.out.print("Telefon: ");
		String telefon = scanner.nextLine();
		
		return new Klient(nazwisko, imie, mail, telefon, null, null);
	}
	
	public static void zapiszDaneDoPliku(String nazwaPliku, List<?> dane) {
		try (FileOutputStream fos = new FileOutputStream(nazwaPliku);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(dane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static <T> List<T> odczytajDaneZPliku(String nazwaPliku) {
		List<T> dane = new ArrayList<>();
		try (FileInputStream fis = new FileInputStream(nazwaPliku);
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			dane = (List<T>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return dane;
	}

}
