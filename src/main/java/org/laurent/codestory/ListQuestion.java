/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.laurent.codestory;

/**
 *
 * @author Maelle_Iris
 */
public enum ListQuestion {

    eMail("Quelleesttonadresseemail"),
    participation("Estuheureuxdeparticiper(OUI/NON)"),
    mailing("Estuabonnealamailinglist(OUI/NON)"),
    enonce1("Estupretarecevoiruneenonceauformatmarkdownparhttppost(OUI/NON)"),
    repondTjrsOui("Estcequeturepondstoujoursoui(OUI/NON)"),
    recuEnonce("Astubienreculepremierenonce(OUI/NON)"),
    bugEtapePrec("As+tu+passe+une+bonne+nuit+malgre+les+bugs+de+l+etape+precedente(PAS_TOP/BOF/QUELS_BUGS)"),
    OuiNon("(OUI/NON)"),
    PasTopBofQuelsBugs("(PAS_TOP/BOF/QUELS_BUGS)"),
    OUI("OUI"),
    NON("NON"),
    PAS_TOP("PAS_TOP"),
    BOF("BOF"),
    QUELS_BUGS("QUELS_BUGS");
     
    private String value;

    private ListQuestion(String value) {
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
    
};
