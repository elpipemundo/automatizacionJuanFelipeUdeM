package com.elpipemundo.question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


import static com.elpipemundo.page.DetalleProcesoJuzgadoPage.TD_DELITO_CONDENA;

/*Verificar que el tipo de delito es el esperado*/
public class DelitoCondena implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {

        return TD_DELITO_CONDENA.resolveFor(actor).getText();
    }

    public static DelitoCondena delitoCondena(){
        return new DelitoCondena();
    }
}
