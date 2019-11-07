package com.elpipemundo.page;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ListadoProcesosJuzgadoPage extends PageObject {


    public static final Target pathDinamicoCondena(String cambio){
        return Target.the("Buscar condenas en ciudad "+cambio).located(By.xpath("//table/tbody/tr/td/a[text()='{condena}']".replace("{condena}",cambio)));
    }

}
