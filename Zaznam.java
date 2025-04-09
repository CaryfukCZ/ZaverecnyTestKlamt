public class Zaznam {
	
	private final String jmeno;
	private final String prijmeni;
	private final String vek;
	private final String telefon;
	
	/**
	 * Konstruktor
	 * @param jmeno
	 * @param prijmeni
	 * @param vek
	 * @param telefon
	 */
	public Zaznam(String jmeno, String prijmeni, String vek, String telefon) {
		this.jmeno = jmeno;
		this.prijmeni = prijmeni;
		this.vek = vek;
		this.telefon = telefon;
	}
	
	/**
	 * @return navrací jmeno a přijmení
	 */
	public String getJmeno() {
		return jmeno;
	}
	
	public String getPrijmeni() {
		return prijmeni;
	}

	public String getVek() {
		return vek;
	}

	public String getTelefon() {
		return telefon;
	}
	
	/**
	 * Vrátí textovou reprezentaci záznamu.
	 * @return
	 */
	@Override
	public String toString() {
		return String.format("%s %s, %s, %s", jmeno, prijmeni, vek, telefon);
	}
}


