package domain;

import java.util.ArrayList;
import java.util.List;

public class PraktijkExamenService {

    public List<PraktijkExamen> praktijkExamens = new ArrayList<>();

    public PraktijkExamenService(){
    }

    public List<PraktijkExamen> getPraktijkExamens() {
        return praktijkExamens;
    }

    public void addPraktijkExamen(PraktijkExamen pE) {
        praktijkExamens.add(pE);
    }
}
