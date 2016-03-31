package Singelloop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;

import javax.swing.JFileChooser;

/**
 * The test class TestSingelloop.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestSingelloop {
	private Tijdstip elfUur, startTienKm, tweeUurMiddag, halfVijfMiddag;
	private Deelnemer piet, gijs, jun, job, casper, marlous, indigo;
	private Deelnemer jan, rick;
	private Deelnemer sophie, carmen, nienke;
	private Afstand deTienKm, prestatieLoop5Km, halveMarathon;
	private Afstand familieloop1, familieloop2, familieloop3;
	private Deelname deelnameGijs, deelnameJun, deelnameJob, deelnameCasper, deelnameMarlous, deelnameIndigo;
	private Deelname deelnameRick, deelnameJan, deelnameSophie, deelnameCarmen, deelnameNienke;
	private Singelloop singelloop2011;
	File singelloopFile = null;

	/**
	 * Default constructor for test class TestSingelloop
	 */
	public TestSingelloop() {

	}

	/**
	 * Sets up the test fixture.
	 *
	 * Called before every test case method.
	 */

	public void setUp() {
		Collections.sort(singelloop2011.geefDeelnames());
		Collections.sort(singelloop2011.geefDeelnames(), new ComparatorOpNaam());
		piet = new Deelnemer("Piet", false, 1990);
		jan = new Deelnemer("Jan", false, 1985);
		sophie = new Deelnemer("Sophie", true, 1992);
		carmen = new Deelnemer("Carmen", true, 1991);
		nienke = new Deelnemer("Nienke", true, 1988);

		marlous = new Deelnemer("Marlous", true, 2001);
		indigo = new Deelnemer("Indigo", false, 2001);
		rick = new Deelnemer("Rick", false, 2001);

		job = new Deelnemer("Job", false, 2000);
		casper = new Deelnemer("Indigo", false, 2000);
		jun = new Deelnemer("Jun", true, 2000);
		gijs = new Deelnemer("Gijs", true, 2000);

		elfUur = new Tijdstip(11, 0, 0);
		prestatieLoop5Km = new Afstand(5000, elfUur);

		startTienKm = new Tijdstip(11, 25, 0);
		deTienKm = new Afstand(10000, startTienKm);

		tweeUurMiddag = new Tijdstip(14, 0, 0);
		halveMarathon = new Afstand(21097, tweeUurMiddag);

		halfVijfMiddag = new Tijdstip(16, 30, 0);
		familieloop1 = new Afstand(1650, halfVijfMiddag);
		familieloop2 = new Afstand(3000, halfVijfMiddag);
		familieloop3 = new Afstand(4400, halfVijfMiddag);

		deelnameIndigo = new Deelname(indigo, familieloop2);
		deelnameIndigo.zetEindtijd(new Tijdstip(16, 49, 22));

		deelnameGijs = new Deelname(gijs, familieloop3);
		deelnameGijs.zetEindtijd(new Tijdstip(16, 55, 22));

		deelnameJun = new Deelname(jun, familieloop2);
		deelnameJun.zetEindtijd(new Tijdstip(16, 51, 22));

		deelnameJob = new Deelname(job, prestatieLoop5Km);
		deelnameJob.zetEindtijd(new Tijdstip(11, 26, 22));

		deelnameCasper = new Deelname(casper, prestatieLoop5Km);
		deelnameCasper.zetEindtijd(new Tijdstip(11, 31, 22));

		singelloop2011 = new Singelloop();
		singelloop2011.voegDeelnameToe(deelnameIndigo);
		singelloop2011.voegDeelnameToe(deelnameGijs);
		singelloop2011.voegDeelnameToe(deelnameJun);
		singelloop2011.voegDeelnameToe(deelnameJob);
		singelloop2011.voegDeelnameToe(deelnameCasper);
	}

	/**
	 * Tears down the test fixture.
	 *
	 * Called after every test case method.
	 */

	public void tearDown() {
	}

	public void save() {
		JFileChooser fileChooser = new JFileChooser(singelloopFile);

		singelloopFile = fileChooser.getSelectedFile();
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(singelloopFile));
			oos.writeObject(singelloop2011);
			oos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (oos != null) {

			}
		}

	}

	public void open() {
		JFileChooser fileChooser = new JFileChooser(singelloopFile);
		singelloopFile = fileChooser.getSelectedFile();
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(singelloopFile));
			singelloop2011 = (Singelloop) ois.readObject();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
	}

}
