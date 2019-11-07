package com.elpipemundo.page;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://procesos.ramajudicial.gov.co/jepms/medellinjepms/lista.asp")
public class ListadoProcesosJuzgadoPage extends PageObject {

/*El mapping es dinámico porque depende del radicado de condena, ya que una persona puede tener
varios, por los cual se debe mapear el expecífico*/
    public static final Target pathDinamicoCondena(String cambio){
        return Target.the("Buscar condenas en ciudad "+cambio).located(By.xpath("//table/tbody/tr/td/a[text()='{condena}']".replace("{condena}",cambio)));
    }

}
