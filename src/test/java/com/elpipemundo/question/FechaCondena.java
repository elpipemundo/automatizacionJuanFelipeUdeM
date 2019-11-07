package com.elpipemundo.question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


import static com.elpipemundo.page.DetalleProcesoJuzgadoPage.TD_FECHA_CONDENA;

/*Verificar que la fecha de condena es la esperado*/
public class FechaCondena implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {

        return TD_FECHA_CONDENA.resolveFor(actor).getText();
    }

    public static FechaCondena fechaCondena(){
        return new FechaCondena();
    }
}
