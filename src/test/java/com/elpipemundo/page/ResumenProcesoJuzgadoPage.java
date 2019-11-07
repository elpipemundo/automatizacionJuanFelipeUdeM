package com.elpipemundo.page;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://procesos.ramajudicial.gov.co/jepms/medellinjepms/adju.asp")
public class ResumenProcesoJuzgadoPage extends PageObject {

    /*Mapping de controles que serán usados en las pruebas*/
    public static final Target LNK_DETALLE_RADICADO=Target.the("Detalle radicado condena").located(By.xpath("//a[contains(text(),' (ver informaci')]"));

}
