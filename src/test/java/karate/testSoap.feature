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

  @firstTest
  Scenario Outline: Test de prueba read xml <numero>
    * def funTestCase =
    """
    function(testCase){
        var utilsDate = Java.type('util.UtilsDate');
        var objTestCase = utilsDate.getTestCase(testCase);
        return objTestCase;
        }
    """

    * def funRequest =
    """
    function(numero){
        var utilsDate = Java.type('util.UtilsDate');
        var request = utilsDate.request(numero);
        return request;
        }
    """

    * def testCase = funTestCase('<numero>')
    * def numero = testCase.getNumCaso()
    * def result = testCase.getNumeroTexto().getTextoNumero()
    * def v_request = funRequest(numero)
    * print v_request


    Given url 'https://www.dataaccess.com/webservicesserver/NumberConversion.wso'
    When header Content-Type = 'text/xml'
    And request
    """
      v_request
    """
    And method POST
    And match //*[local-name()='NumberToDollarsResult'] == result
    ###############responseSOAP####################
    * print '<response>: ', response
    * def responseSOAP =
    """
    function(response){
        var utilsDate = Java.type('util.UtilsDate');
        var request = utilsDate.responseSOAP(response);
        }
    """
    * def miRespuesta = response
    * print 'Variable: ', miRespuesta
    * def responseSOAPAsString = miRespuesta.toString()
    * def callResponseSOAP = responseSOAP(responseSOAPAsString)
    ###############FIN responseSOAP####################

    * def numberToDollarsResult = //*[local-name()='NumberToDollarsResult']
    * print '<NumberToDollarsResult>: ', numberToDollarsResult


    Examples:
      | numero |
      | 1      |
      | 2      |
      | 3      |


@soloJSON
  Scenario: Crear un nuevo producto
    Given path '/catalog/product'
    * url 'https://mystoreapi.com'

    * def funRequest =
    """
    function(){
        var utilsDate = Java.type('util.UtilsDate');
        var request = utilsDate.requestMyStoreApiTres();
        return request;
        }
    """
    * def v_rest = funRequest()
    * print 'REQUEST>>: ', v_rest


    * configure ssl = true
    And header Accept = 'application/json'
    And header Content-Type = 'application/json'
    And request   v_rest
    When method post
    Then status 201
    And print 'result ',response

  * def responseJSON =
    """
    function(response){
         var ValidarResponse = Java.type('util.ValidarResponse');
        var request = ValidarResponse.convertObjectToList(response);
        return request;
        }
    """
  #* def stringResponse = response
  #* print 'stringResponse: ', stringResponse
  #* print 'obj.toString(): ', stringResponse.toString()
   * def responseRest = responseJSON(response)





  @LeerXML
  Scenario: leerXML
    Given url 'https://www.dataaccess.com/webservicesserver/NumberConversion.wso'
    When header Content-Type = 'text/xml'
    * def auxResponse = read ('responseSOAP.xml')
    And print 'responsex ',auxResponse
    #And def json = $bodyX
    #And print 'json >',json

    ###############responseSOAP####################
    * def responseSOAP =
    """
    function(response){
         var ValidarResponse = Java.type('util.ValidarResponse');
        var request = ValidarResponse.readResponseSOAP(response);
        return request;
        }
    """
    ##* def miRespuesta = response <---Es la q va!!!
    * def miRespuesta = auxResponse
    ##VEO LA REPUESTA
    * print 'miRespuesta: ', miRespuesta

    ####SOLO PARA PRUEBAS LOCALES FORMATIAMOS EL ARCHIVO PARA PODER TRABAJAR EN EL XML
    * def responseSOAPAsString = miRespuesta
    * print 'responseSOAPAsString: ', responseSOAPAsString
    * def xmlFormateado = karate.prettyXml(miRespuesta)

    ####ENVIAMOS ANALISAR EL RESPONSE DEL SERVICIO SOAP
    * def callResponseSOAP = responseSOAP(xmlFormateado)
    * print 'callResponseSOAP: ', callResponseSOAP.toString()



  @TestJSON
  Scenario: Crear un nuevo producto
    Given path '/catalog/product'
    * url 'https://mystoreapi.com'

    * def funRequest =
    """
    function(){
        var utilsDate = Java.type('util.UtilsDate');
        var request = utilsDate.requestMyStoreApiTres();
        return request;
        }
    """
    * def v_rest = funRequest()
    * print 'REQUEST>>: ', v_rest


    * configure ssl = true
    And header Accept = 'application/json'
    And header Content-Type = 'application/json'
    And request   v_rest
    When method post
    Then status 201
    And print 'result ',response


    #######
    * def responseJSON =
    """
    function(response){
         var ValidarResponse = Java.type('util.ValidarResponse');
        var request = ValidarResponse.readResponseRest(response);
        return request;
        }
    """
    * def stringResponse = response
    * print 'stringResponse: ', stringResponse
    #* def responseRest = responseJSON(stringResponse)
    * def auxResponse = read ('responseRest.json')
    * print 'auxResponse: ',auxResponse
    * def responseRest = responseJSON(auxResponse)