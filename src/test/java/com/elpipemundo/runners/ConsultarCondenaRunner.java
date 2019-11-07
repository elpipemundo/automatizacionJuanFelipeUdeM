package com.elpipemundo.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/*Une lo de Gherki con lo de lenguaje Java*/
@RunWith(CucumberWithSerenity.class)/*Va a ser una clase ejecutable*/
@CucumberOptions(
        features = "src/test/resources/features/consultar_condena.feature",/*Ubicacion de los feature*/
        glue = {"com.elpipemundo.stepdefinitions"},/*Donde van a estar pos StpeDefinitions, permiten transformar de lenguaje humano a Java*/
        snippets = SnippetType.CAMELCASE
)
public class ConsultarCondenaRunner {
}
