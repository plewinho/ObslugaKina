package main;

import java.io.Serializable;
import java.util.List;

public class Klient implements Serializable {
	private String nazwisko;
	private String imie;
	private String mail;
	private String telefon;
	private Seans seans;
	private List<Integer> miejsca;
	
	public Klient(String nazwisko, String imie, String mail, String telefon, Seans seans, List<Integer> miejsca) {
		this.nazwisko = nazwisko;
		this.imie = imie;
		this.mail = mail;
		this.telefon = telefon;
		this.seans = seans;
		this.miejsca = miejsca;
	}
	//Settery
	public Klient setNazwisko(final String nazwisko) {
		this.nazwisko = nazwisko;
		return this;
	}
	public Klient setImie(final String imie) {
		this.imie = imie;
		return this;
	}
	public Klient setMail(final String mail) {
		this.mail = mail;
		return this;
	}
	public Klient setTelefon(final String telefon) {
		this.telefon = telefon;
		return this;
	}
	public Klient setSeans(final Seans seans) {
		this.seans = seans;
		return this;
	}
	public Klient setMiejsce(final List<Integer> wybraneMiejsca) {
		this.miejsca = wybraneMiejsca;
		return this;
	}
	//Gettery
	public String getNazwisko() {
		return this.nazwisko;
	}
	public String getImie() {
		return this.imie;
	}
	public String getMail() {
		return this.mail;
	}
	public String getTelefon() {
		return this.telefon;
	}
	public Seans getSeans() {
		return this.seans;
	}
	public List<Integer> getMiejsca() {
		return this.miejsca;
	}
}
