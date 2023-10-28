package main;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class Seans implements Serializable{
	private String tytul;
	private String dzien;
	private String godzina;
	private int ograniczeniaWiekowe;
	private List<Integer> miejsca;
	
	public Seans(final String tytul, final String dzien, final String godzina, final int ograniczeniaWiekowe, 
			final List<Integer> wybraneMiejsca ) {
		this.tytul = tytul;
		this.dzien = dzien;
		this.godzina = godzina;
		this.ograniczeniaWiekowe = ograniczeniaWiekowe;
		this.miejsca = wybraneMiejsca;
	}
	//Settery
	public Seans setTytul(final String tytul) {
		this.tytul = tytul;
		return this;
	}
	public Seans setDzien(final String dzien) {
		this.dzien = dzien;
		return this;
	}
	public Seans setGodzina(final String godzina) {
		this.godzina = godzina;
		return this;
	}
	public Seans setOgraniczenia(final int ograniczeniaWiekowe) {
		this.ograniczeniaWiekowe = ograniczeniaWiekowe;
		return this;
	}
	public Seans setMiejsca(final List<Integer> miejsca) {
		this.miejsca = miejsca;
		return this;
	}
	//Gettery
	public String getTytul() {
		return this.tytul;
	}
	public String getDzien() {
		return this.dzien;
	}
	public String getGodzina() {
		return this.godzina;
	}
	public int getOgraniczenia() {
		return this.ograniczeniaWiekowe;
	}
	public List<Integer> getMiejsca() {
		return this.miejsca;
	}
}
