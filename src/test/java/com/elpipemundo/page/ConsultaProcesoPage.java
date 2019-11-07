package com.elpipemundo.page;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://procesos.ramajudicial.gov.co/consultaprocesos/ConsultaJusticias21.aspx")
public class ConsultaProcesoPage extends PageObject {
    /*Mapping de controles que serán usados en las pruebas*/
    public static final Target SELECT_CIUDAD=Target.the("Select de Ciudad").located(By.id("ddlCiudad"));

    public static final Target SELECT_ENTIDAD=Target.the("Select de Entidad").located(By.id("ddlEntidadEspecialidad"));
    /*Debido a que se presenta errores con el encoding de 'Número de Radicación' al ejecutarlo decidí utilizar este xpath ya que es único elemento
   * que existe en el DOM para un Input*/
    public static final Target TEXT_RADICADO=Target.the("Nro. Radicado").located(By.xpath("//input[@onkeypress=\" return num(event)\"]"));
    public static final Target TEXT_BARRA = Target.the("Text barra").located(By.id("ConsultarNum"));


    public static final Target SELECT_CIUDAD_JUZGADO=Target.the("Select de Ciudad juzgado").located(By.id("ddlJuzgados"));
    public static final Target BTN_JUZGADO=Target.the("Ir al juzgado").locatedBy("//input[@id='btnIrJuzgados']");





}
