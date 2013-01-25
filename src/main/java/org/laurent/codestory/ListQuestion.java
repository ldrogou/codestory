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
    participation("Es+tu+heureux+de+participer(OUI/NON)"),
    mailing("Es+tu+abonne+a+la+mailing+list(OUI/NON)"),
    enonce1("Es+tu+pret+a+recevoir+une+enonce+au+format+markdown+par+http+post(OUI/NON)"),
    repondTjrsOui("Est+ce+que+tu+reponds+toujours+oui(OUI/NON)"),
    recuEnonce("As+tu+bien+recu+le+premier+enonce(OUI/NON)"),
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
