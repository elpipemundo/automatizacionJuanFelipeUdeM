package com.elpipemundo.page;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://procesos.ramajudicial.gov.co/jepms/medellinjepms/suje.asp")
public class DetalleProcesoJuzgadoPage extends PageObject {
    /*Mapping de controles que serán usados en las pruebas*/

    public static final Target TD_FECHA_CONDENA=Target.the("Fecha Condena").locatedBy("//table[18]/tbody/tr[2]/td[4]/div/font");
    public static final Target TD_DELITO_CONDENA=Target.the("Delito Condena").locatedBy("//table[8]/tbody/tr[8]/td[2]/font");

}
