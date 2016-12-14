/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public abstract class EpisodesRanking extends Observable {

    /**
     * Nombre d'episodis al ranking.
     */
    protected final int num;
    protected ArrayList<Episode> top;

    public EpisodesRanking(int num) {
        this.num = num;
        top = new ArrayList<>();
    }

    public void update(Episode e) {
        int oldPosition = top.indexOf(e);
        int newPosition = updateElementPosition(e, oldPosition);

        if (oldPosition != newPosition && (oldPosition <= num - 1 || newPosition <= num - 1)) {
            notifyObservers();
        }
    }

    private int updateElementPosition(Episode e, int oldPos) {
        // Mirem si es moura.
        boolean toMove;
        if (top.isEmpty()) {
            top.add(e);
            return 0;
        } else if (oldPos == -1) {
            // no hi és, s'ha de buscar la seva posicio.
            int pos = getPosition(e);
            top.add(pos, e);
            return pos;
        } else if (oldPos == 0) {
            // esta al top 1
            toMove = getHigherElement(top.get(1), e) != e;
        } else if (oldPos == top.size() - 1) {
            // esta a abaix de tot
            toMove = getHigherElement(top.get(oldPos - 1), e) == e;
        } else {
            // esta a una posicio intermitja
            toMove = getHigherElement(top.get(oldPos - 1), e) == e || getHigherElement(top.get(oldPos + 1), e) != e;
        }
        // Si s'ha de moure l'eliminem i li busquem la nova posicio (els altres no fa falta tocarlos
        if (toMove) {
            top.remove(e);
            int pos = getPosition(e);
            top.add(pos, e);
            return pos; // NOVA POSICIO
        }
        return oldPos; // L'EPISODI NO S'HA DE MOURE
    }

    /**
     * Cerca binaria de la posicio adequada d'episodi. La funcio
     * "getHigherElement" es qui marca quin element es mes gran.
     *
     * @param ep
     * @return
     */
    private int getPosition(Episode ep) {
        int start = 0, end = top.size() - 1, middle;
        while (start <= end) {
            middle = start + (end - start) / 2;
            Episode middleEl = top.get(middle);
            if (getHigherElement(middleEl, ep) == ep) {
                // Esta a la primera meitat.
                end = middle - 1;
            } else if (getHigherElement(middleEl, ep) == middleEl) {
                // Esta a la segona meitat.
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return start;
    }

    protected abstract Episode getHigherElement(Episode ep1, Episode ep2);
}
