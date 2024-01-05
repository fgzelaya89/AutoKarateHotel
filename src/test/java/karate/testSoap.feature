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

  @first
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
    * print '<response>: ', response

    * def numberToDollarsResult = //*[local-name()='NumberToDollarsResult']
    * print '<NumberToDollarsResult>: ', numberToDollarsResult


    Examples:
      | numero |
      | 1      |
      | 2      |
      | 3      |


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


  Scenario: Buscar un valor en el XML
    Given def xmlData =
    """
    <root>
        <element1>valor1</element1>
        <element2>valor2</element2>
        <element3>
            <subelement>valor3</subelement>
        </element3>
    </root>
    """

    When def valorEncontrado = karate.xmlPath(xmlData, "/root/element2").text()

    Then match valorEncontrado == 'valor2'