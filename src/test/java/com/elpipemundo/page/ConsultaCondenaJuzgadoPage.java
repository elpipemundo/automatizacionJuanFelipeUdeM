package com.elpipemundo.page;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://procesos.ramajudicial.gov.co/jepms/medellinjepms/conectar.asp")
public class ConsultaCondenaJuzgadoPage extends PageObject {
/*Mapping de controles que serán usados en las pruebas*/


    public static final Target SELECT_OPCION_BUSQUEDA=Target.the("Select de opción búsqueda").located(By.xpath("//select[@name='cbadju']"));

    public static final Target TEXT_DATO_FILTRO=Target.the("Dato filtro búsqueda").located(By.xpath("//input[@name='norad']"));

    public static final Target BTN_BUSCAR=Target.the("Buscar condenas").located(By.xpath("//input[@name='Buscar']"));

}
