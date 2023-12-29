Feature:plan de pruebas orientado a las consultas del tipo soap



    #lectura archivo xml si funciona
  Scenario Outline: caso de prueba read xml <numero>
    Given url 'https://www.dataaccess.com/webservicesserver/NumberConversion.wso'
    When header Content-Type = 'text/xml'
    And def bodyX = read ('body.xml')
    And request bodyX
    And method POST
    And match //*[local-name()='NumberToWordsResult'] == '<valida> '


    Examples:
      | numero | valida        |
      | 2      | two           |
      | 800    | eight hundred |
      | 11     | eleven        |
      | 200    | two hundred   |

  @casoPost
  Scenario Outline: Test de prueba read xml <numero>
    * def funTestCase =
    """
    function(testCase){
        var utilsDate = Java.type('util.UtilsDate');
        var objTestCase = utilsDate.getTestCase(testCase);
        return objTestCase;
        }
    """
    * def testCase = funTestCase(<numero>)
    * def numero = testCase.getNumCaso()
    * def result = testCase.getNumeroTexto().getTextoNumero()

    Given url 'https://www.dataaccess.com/webservicesserver/NumberConversion.wso'
    When header Content-Type = 'text/xml'
    And request
  """
      <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:web="http://www.dataaccess.com/webservicesserver/">
        <soap:Header/>
        <soap:Body>
          <web:NumberToDollars>
            <web:dNum>#(numero)</web:dNum>
          </web:NumberToDollars>
        </soap:Body>
      </soap:Envelope>
      """
    And method POST
    And match //*[local-name()='NumberToDollarsResult'] == result


    Examples:
      | numero |
      | 1      |
      | 2      |
      | 3      |

  @tstYef
  Scenario Outline: Test de prueba read xml <tcs_num>
    * def getTestCase =
    """
    function(testCase){
        var utilsDate = Java.type('util.UtilsDate');
        var objTestCase = utilsDate.getPruebaData(testCase);
        return objTestCase;
        }
    """
    * def testCase = getTestCase(<tcs_num>)


    Given url 'https://www.dataaccess.com/webservicesserver/NumberConversion.wso'
    When header Content-Type = 'text/xml'
    And request
  """
       <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://services.booking.rumbonet.riu.com" xmlns:dtos="http://dtos.booking.rumbonet.riu.com" xmlns:ser1="http://services.common.rumbonet.riu.com">
           <soapenv:Header/>
           <soapenv:Body>
              <ser:recuperarTablaPreciosRB>
                 <ser:in0>
                    <dtos:codigoAccesoUsuario>DIRECTO</dtos:codigoAccesoUsuario>
                    <dtos:codigoAmbito>DIR</dtos:codigoAmbito>
                    <dtos:codigoPaisAmbito>ES</dtos:codigoPaisAmbito>
                    <dtos:codigoRegimen>MP</dtos:codigoRegimen>
                    <dtos:fechaEntrada>2023-12-05T00:00:00.000+00:00</dtos:fechaEntrada>
                    <dtos:fechaSalida>2023-12-10T00:00:00.000+00:00</dtos:fechaSalida>
                    <dtos:listaHabitaciones>
                       <dtos:listaHabitaciones>
                          <dtos:DispHabitacionDto>
                          <dtos:listaedades>
                          </dtos:listaedades>
                          <dtos:numeroAdultos>2</dtos:numeroAdultos>
                          <dtos:numeroBabies>0</dtos:numeroBabies>
                          <dtos:numeroInfants>0</dtos:numeroInfants>
                    </dtos:DispHabitacionDto>
                 </dtos:listaHabitaciones>
              </dtos:listaHabitaciones>
              <dtos:listaTipoHabitaciones>
                 <ser1:string>DDSB</ser1:string>
              </dtos:listaTipoHabitaciones>
              <dtos:listaHoteles>
                 <dtos:listaHoteles>
                          <ser1:int>141</ser1:int>
                       </dtos:listaHoteles>
                    </dtos:listaHoteles>
                    <dtos:numeroAdultos>2</dtos:numeroAdultos>
                    <dtos:numeroBabies>0</dtos:numeroBabies>
                    <dtos:numeroHabitaciones>1</dtos:numeroHabitaciones>
                    <dtos:numeroInfants>0</dtos:numeroInfants>
                 </ser:in0>
              </ser:recuperarTablaPreciosRB>
           </soapenv:Body>
        </soapenv:Envelope>
      """
    And method POST
    #And match //*[local-name()='NumberToDollarsResult'] == result


    Examples:
      | tcs_num |
      | TEST_1  |
      | TEST_2  |
