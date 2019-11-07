package com.elpipemundo.page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;



@DefaultUrl("https://ramajudicial.gov.co/")
public class RamaJudicialInicioPage extends PageObject {
    /*Mapping de controles que serán usados en las pruebas*/
    public static final Target BTN_CONSULTAR_PROCESO=Target.the("Boton Consulta de procesos").locatedBy("//*[text()=' Consulta de Procesos ']");

}
