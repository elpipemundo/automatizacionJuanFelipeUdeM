package com.elpipemundo.page;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ResumenProcesoJuzgadoPage extends PageObject {


    public static final Target LNK_DETALLE_RADICADO=Target.the("Detalle radicado condena").located(By.xpath("//a[contains(text(),' (ver informaci')]"));

}
