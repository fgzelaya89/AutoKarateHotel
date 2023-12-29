Feature: SOAP Test

  Background:
    * url 'https://www.dataaccess.com/webservicesserver/NumberConversion.wso'

    # Definir la función deveulve el valor parametrizado
    * def valida =
  """
   function(){
        var c = Java.type('util.UtilsDate');

        return new c().getValida();
        }
  """



  Scenario Outline:: Verify SOAP Service Response
    * def v_Valida = valida()

    Given request
      """
      <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:web="http://www.dataaccess.com/webservicesserver/">
        <soap:Header/>
        <soap:Body>
          <web:NumberToDollars>
            <web:dNum>501</web:dNum>
          </web:NumberToDollars>
        </soap:Body>
      </soap:Envelope>
      """
    When soap action 'https://www.dataaccess.com/webservicesserver/NumberToDollars'
    Then status 200
    And match //*[local-name()='NumberToDollarsResult'] == v_Valida
    And print response
    And match /^sdasd$/
    * print 'response: ', response , v_Valida
    Examples:
      | Repuesta                     |
      | five hundred and one dollars |