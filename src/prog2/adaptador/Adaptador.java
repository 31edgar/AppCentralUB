package prog2.adaptador;

import java.io.*;
import java.util.ArrayList;

import prog2.model.Dades;
import prog2.vista.*;

/**
 * Classe adaptadora per gestionar la comunicació amb la classe {@link Dades}.
 * <p>
 * Aquesta classe actua com a intermediària entre el sistema i les operacions relacionades amb la central,
 * permetent la interacció amb diversos components com el reactor, el sistema de refrigeració i el sistema de barres.
 * També proporciona funcionalitats per carregar i guardar l'estat de la central en fitxers.
 * </p>
 *
 * @author Guillem Calvet
 * @author Edgar Esparza
 * @version 1.0
 * @see Dades
 * @since 1.0
 */
public class Adaptador {

    // creem una instància de Dades i un atribut per a carregar una central
    private static Dades dades = new Dades();

    // Mètodes per finalitzar el dia i obtenir les barres

    /**
     * Finalitza el dia de la central, passant la demanda de potència com a paràmetre.
     *
     * @param demandaPotencia La demanda de potència que s'ha de considerar al finalitzar el dia.
     * @return Una cadena amb el resultat del finalitzar el dia.
     */
    public static String finalitzaDia(float demandaPotencia) {
        return dades.finalitzaDia(demandaPotencia).toString();
    }

    /**
     * Obté els guanys acumulats.
     *
     * @return Els guanys acumulats.
     */
    public static float getGuanysAcumulats() {
        return dades.getGuanysAcumulats();
    }

    /**
     * Obté l'estat de les bombes
     *
     * @return Estats
     */
    public static ArrayList<Boolean> getEstatBombes() {
        return dades.getEstatBombes();
    }

    /**
     * Obté si el reactor està activat
     *
     * @return Activat
     */
    public static boolean isReactorActivat() {
        return dades.isReactorActivat();
    }

    /**
     * Obté el dia.
     *
     * @return El dia.
     */
    public static int getDia() {
        return dades.getDia();
    }

    /**
     * Obté el valor d'inserció de les barres.
     *
     * @return El valor d'inserció de les barres.
     */
    public static float getInsercioBarres() {
        return dades.getInsercioBarres();
    }

    /**
     * Estableix el valor d'inserció de les barres.
     *
     * @param insercioBarres El valor a establir per a la inserció de les barres.
     */
    public static void setInsercioBarres(float insercioBarres) {
        dades.setInsercioBarres(insercioBarres);
    }

    // Mètodes per gestionar el reactor

    /**
     * Activa el reactor de la central.
     */
    public static void activaReactor() {
        dades.activaReactor();
    }

    /**
     * Desactiva el reactor de la central.
     */
    public static void desactivaReactor() {
        dades.desactivaReactor();
    }

    /**
     * Mostra l'estat actual del reactor.
     *
     * @return Una cadena amb la representació de l'estat del reactor.
     */
    public static String mostraReactor() {
        return dades.mostraReactor().toString();
    }

    // Mètodes per gestionar el sistema de refrigeració

    /**
     * Activa totes les bombes del sistema de refrigeració.
     */
    public static void activaBombes() {
        dades.activaBombes();
    }

    /**
     * Desactiva totes les bombes del sistema de refrigeració.
     */
    public static void desactivaBombes() {
        dades.desactivaBombes();
    }

    /**
     * Activa una bomba específica del sistema de refrigeració.
     *
     * @param id L'ID de la bomba que es vol activar.
     */
    public static void activaBomba(int id) {
        dades.activaBomba(id);
    }

    /**
     * Desactiva una bomba específica del sistema de refrigeració.
     *
     * @param id L'ID de la bomba que es vol desactivar.
     */
    public static void desactivaBomba(int id) {
        dades.desactivaBomba(id);
    }

    /**
     * Mostra l'estat actual del sistema de refrigeració.
     *
     * @return Una cadena amb la representació de l'estat del sistema de refrigeració.
     */
    public static String mostraSistemaRefrigeracio() {
        return dades.mostraSistemaRefrigeracio().toString();
    }

    // Mètodes per gestionar l'estat de la central

    /**
     * Mostra l'estat general de la central.
     *
     * @return Una cadena amb la representació de l'estat de la central.
     */
    public static String mostraEstatCentral() {
        return dades.mostraEstat().toString();
    }

    /**
     * Mostra la bitàcola de la central.
     *
     * @return Una cadena amb la representació de la bitàcola de la central.
     */
    public static String mostraBitacola() {
        return dades.mostraBitacola().toString();
    }

    /**
     * Mostra les incidències de la central.
     *
     * @return Una cadena amb la representació de les incidències de la central.
     */
    public static String mostraIncidencies() {
        return dades.mostraIncidencies().toString();
    }

    /**
     * Calcula la demanda satisfeta per la central.
     *
     * @return Un array amb els valors de la demanda satisfeta.
     */
    public static String mostraDemandaSatisfeta() {

        if (getDia() == 1){
            float[] llista = dades.demandaSatisfeta(getDemandaInicial());
            return ("- Demanda de potència actual: " + llista[0] +
                    "\n- Potència generada (amb la configuració actual): " + llista[1] +
                    "\n- Percentatge de demanda satisfeta: " + llista[2] + " %");
        }
        else{
            float[] llista = dades.demandaSatisfeta(getDemandaActual());
            return ("- Demanda de potència actual: " + llista[0] +
                    "\n- Potència generada (amb la configuració actual): " + llista[1] +
                    "\n- Percentatge de demanda satisfeta: " + llista[2] + " %");
        }
    }

    // Mètodes per al tractament de dades (guardar i carregar l'estat)

    /**
     * Guarda l'estat actual de la central en un fitxer.
     *
     * @param camiDesti Ruta del fitxer on es guardarà l'estat.
     * @throws CentralUBException Si hi ha un error en el procés de guardat.
     */
    public static void guardaDades(String camiDesti) throws CentralUBException {
        File fitxer = new File(camiDesti);
        try {
            FileOutputStream fout = new FileOutputStream(fitxer);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(dades);
            oos.close();
        } catch (Exception e) {
            throw new CentralUBException("No s'ha pogut guardar la central.");
        }
    }

    /**
     * Carrega un estat de la central des d'un fitxer.
     *
     * @param camiOrigen Ruta del fitxer a carregar.
     * @throws CentralUBException Si hi ha un error en el procés de càrrega.
     */
    public static void carregaDades(String camiOrigen) throws CentralUBException {
        try {
            FileInputStream fin = new FileInputStream(camiOrigen);
            ObjectInputStream ois = new ObjectInputStream(fin);
            dades = (Dades) ois.readObject();
            ois.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void setDemandaActual(float demandaPotencia) throws CentralUBException {
        dades.setDemandaActual(demandaPotencia);
    }
    public static float getDemandaActual() {return dades.getDemandaActual();}

    public static void setDemandaInicial(float demandaPotencia) throws CentralUBException {
        dades.setDemandaInicial(demandaPotencia);
    }
    public static float getDemandaInicial() {return dades.getDemandaInicial();}

}
