# language: es
Característica: Consultar Condena
    Felipe como ciudadano
    Quiere consultar la condena de Sergio

    Escenario: Consultar expediente de penas para SERGIO ELIECER - MARTINEZ PEREZ
      Dado  que "SERGIO ELIECER - MARTINEZ PEREZ" cuenta con proceso judicial en la ciudad de "MEDELLIN"
      Cuando se consulta el expediente por "Documento de identificación del sujeto" para el documento "71984905" y selecciona el radicado "76892600019120090015901"
      Entonces debe contar con condena del "17/9/2013" por el delito de "INASISTENCIA ALIMENTARIA ART. 233 C.P. -"
