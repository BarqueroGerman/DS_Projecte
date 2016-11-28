package edu.ub.informatica.disseny.totseries;

import org.xml.sax.helpers.DefaultHandler;

/**
 * Test de carrega de fitxer XML de TotSeries
 * 
 */
public class TotSeriesXMLTest extends DefaultHandler {

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
            new TotSeriesXMLTest("data/TotSeries.xml");
	}

	/**
	 * Parseja el fitxer XML i guarda les dades
	 * 
	 * @param nomFitxer fitxer XML a parsejar
	 */
	public TotSeriesXMLTest(String nomFitxer) {
		TotSeriesDataManager dataManager = new TotSeriesDataManager();
		dataManager.obtenirDades(nomFitxer);
	}
}
